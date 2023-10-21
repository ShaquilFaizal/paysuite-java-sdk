package mz.co.hypertech.paysuitejavasdk;

import mz.co.hypertech.paysuitejavasdk.internal.PaySuiteResponseFailure;

public interface Callback {
    void onSuccess(PaySuiteResponse response);
    void onError(PaySuiteResponseFailure errorResponse);
}
