package mz.co.hypertech.paysuitejavasdk.internal;

import mz.co.hypertech.paysuitejavasdk.PaySuiteRequest;
import mz.co.hypertech.paysuitejavasdk.PaySuiteResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PaySuiteService {
    @Headers(
            "Content-Type: application/json"
    )
    @POST("api/v1/payments")
    Call<PaySuiteResponse> post(
            @Header("Authorization") String authorization,
            @Body PaySuiteRequest paysuiteRequest);
}
