package mz.co.hypertech.paysuitejavasdk.internal;

import mz.co.hypertech.paysuitejavasdk.Callback;
import mz.co.hypertech.paysuitejavasdk.PaySuiteRequest;

import java.io.IOException;

public interface PaySuiteSDK {
    Object initiatePaymentSync(PaySuiteRequest paySuiteRequest) throws IOException;

    void initiatePaymentAsync(PaySuiteRequest paySuiteRequest, Callback callback);
}
