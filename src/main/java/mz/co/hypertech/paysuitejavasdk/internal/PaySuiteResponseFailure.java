package mz.co.hypertech.paysuitejavasdk.internal;

public class PaySuiteResponseFailure {
    private String status;
    private String message;

    public PaySuiteResponseFailure(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public PaySuiteResponseFailure() {
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
