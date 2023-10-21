package mz.co.hypertech.paysuitejavasdk;

public class PaySuiteRequest {
    private String tx_ref;
    private String currency;
    private String is_test;
    private String purpose;
    private double amount;
    private String callback_url;
    private String redirect_url;

    public PaySuiteRequest() {
    }

    public String getTx_ref() {
        return tx_ref;
    }

    public void setTx_ref(String tx_ref) {
        this.tx_ref = tx_ref;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIs_test() {
        return is_test;
    }

    public void setIs_test(String is_test) {
        this.is_test = is_test;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    private PaySuiteRequest(Builder builder) {
        this.tx_ref = builder.tx_ref;
        this.currency = builder.currency;
        this.is_test = builder.is_test;
        this.purpose = builder.purpose;
        this.amount = builder.amount;
        this.callback_url = builder.callback_url;
        this.redirect_url = builder.redirect_url;
    }

    public static class Builder{
        private String tx_ref;
        private String currency;
        private String is_test;
        private String purpose;
        private double amount;
        private String callback_url;
        private String redirect_url;

        public Builder tx_ref(String tx_ref){
            this.tx_ref = tx_ref;
            return this;
        }
        public Builder currency(String currency){
            this.currency = currency;
            return this;
        }
        public Builder is_test(String is_test){
            this.is_test = is_test;
            return this;
        }  public Builder purpose(String purpose){
            this.purpose = purpose;
            return this;
        }
        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }
        public Builder callback_url(String callback_url){
            this.callback_url = callback_url;
            return this;
        }
        public Builder redirect_url(String redirect_url){
            this.redirect_url = redirect_url;
            return this;
        }

        public PaySuiteRequest build(){

            validate();
            return new PaySuiteRequest(this);
        }

        private void validate(){
            if(tx_ref != null && tx_ref.length() > 20){
                throw new IllegalArgumentException("tx_ref must contain a maximum 20 characters.");
            }

            if (!is_test.equals("1") && !is_test.equals("0")) {
                throw new IllegalArgumentException("is_test must be either '1' or '0'");
            }

            if(amount <= 0.0){
                throw  new IllegalArgumentException("Amount must be an integer and larger than 0.");
            }
        }
    }
}
