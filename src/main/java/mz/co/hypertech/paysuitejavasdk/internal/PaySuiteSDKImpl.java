package mz.co.hypertech.paysuitejavasdk.internal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import mz.co.hypertech.paysuitejavasdk.PaySuiteRequest;
import mz.co.hypertech.paysuitejavasdk.PaySuiteResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

public class PaySuiteSDKImpl implements PaySuiteSDK{

    private final String apiKey;
    private final PaySuiteService paySuiteService;

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
}
