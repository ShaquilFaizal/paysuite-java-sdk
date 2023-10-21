package mz.co.hypertech.paysuitejavasdk;

public class PaySuiteResponse {
    private String status;
    private String message;
    private String checkout_url;

    public PaySuiteResponse() {
    }

    public PaySuiteResponse(String status, String message, String checkout_url) {
        this.status = status;
        this.message = message;
        this.checkout_url = checkout_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCheckout_url() {
        return checkout_url;
    }

    public void setCheckout_url(String checkout_url) {
        this.checkout_url = checkout_url;
    }



    public PaySuiteResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
