package utils;

public class BankInfo {
    private String bankName;
    private double buyRate;
    private double sellRate;

    public BankInfo(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }
}
