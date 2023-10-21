package mz.co.hypertech.paysuitejavasdk;

import mz.co.hypertech.paysuitejavasdk.internal.PaySuiteSDK;
import mz.co.hypertech.paysuitejavasdk.internal.PaySuiteSDKImpl;

import java.io.IOException;

public class Client {
    private final PaySuiteSDK paySuiteSDK;


    public Client(String apiKey) {
        this.paySuiteSDK = new PaySuiteSDKImpl(apiKey);
    }

    public Object initiatePaymentSync(PaySuiteRequest paySuiteRequest) throws IOException {
        return  paySuiteSDK.initiatePaymentSync(paySuiteRequest);
    }
}
