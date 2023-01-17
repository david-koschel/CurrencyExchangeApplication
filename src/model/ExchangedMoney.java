package model;

public class ExchangedMoney {

    private float count;

    private ExchangeRate exchangeRate;

    public ExchangedMoney(float count, ExchangeRate exchangeRate) {
        this.count = count;
        this.exchangeRate = exchangeRate;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public float getConvertedCurrency() {
        return count * exchangeRate.getRate();
    }

    @Override
    public String toString() {
        return String.format("%.2f%s equals to %.2f%s", count,
                exchangeRate.getFrom().getCode(),
                getConvertedCurrency(),
                exchangeRate.getTo().getCode());
    }
}
