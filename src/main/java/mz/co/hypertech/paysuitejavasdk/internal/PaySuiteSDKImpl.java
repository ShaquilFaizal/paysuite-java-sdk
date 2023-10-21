package mz.co.hypertech.paysuitejavasdk.internal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import mz.co.hypertech.paysuitejavasdk.Callback;
import mz.co.hypertech.paysuitejavasdk.PaySuiteRequest;
import mz.co.hypertech.paysuitejavasdk.PaySuiteResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

public class PaySuiteSDKImpl implements PaySuiteSDK, retrofit2.Callback<PaySuiteResponse>{

    private final String apiKey;
    private final PaySuiteService paySuiteService;
    private Callback callback;

    public PaySuiteSDKImpl(String apiKey) {
        this.apiKey = apiKey;
        this.paySuiteService = createPaySuiteService();
    }

    private PaySuiteService createPaySuiteService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://paysuite.co.mz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(PaySuiteService.class);
    }
    public Object initiatePaymentSync(PaySuiteRequest paySuiteRequest) throws IOException {
        Call<PaySuiteResponse> call = paySuiteService.post(apiKey,paySuiteRequest);
        Response<PaySuiteResponse> response = call.execute();

        if (response.isSuccessful()) {
            return response.body();
        } else {
            return handleErrorResponse(response);
        }
    }

    @Override
    public void initiatePaymentAsync(PaySuiteRequest paySuiteRequest, Callback callback) {
        validatePaySuiteRequest(paySuiteRequest);
        this.callback = callback;
        Call<PaySuiteResponse> call = paySuiteService.post(apiKey, paySuiteRequest);
        call.enqueue(this);
    }

    private PaySuiteResponseFailure handleErrorResponse (Response<PaySuiteResponse> response){
        try {
            String errorResponse = response.errorBody().string();
            JsonObject errorJson = new Gson().fromJson(errorResponse, JsonObject.class);
            String message = errorJson.get("message").getAsString();
            return new PaySuiteResponseFailure(Integer.toString(response.code()), message);
        } catch (IOException | JsonParseException e) {
            return new PaySuiteResponseFailure("500", "An error occurred: " + e.getMessage());
        }
    }

    private void validatePaySuiteRequest(PaySuiteRequest paySuiteRequest) {
        if (paySuiteRequest.getTx_ref() == null) {
            throw new IllegalArgumentException("The 'tx_ref' field in PaySuiteRequest is required for payment initiation.");
        }
    }

    @Override
    public void onResponse(Call<PaySuiteResponse> call, Response<PaySuiteResponse> response) {
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            callback.onError(handleErrorResponse(response));
        }
    }

    @Override
    public void onFailure(Call<PaySuiteResponse> call, Throwable throwable) {
        callback.onError(new PaySuiteResponseFailure("500", "An Error occurred: " + throwable.getMessage()));
    }
}
