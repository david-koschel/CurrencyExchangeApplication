package model;

public class ExchangeRate {

    private Currency from;

    private Currency to;

    private float rate;

    public static ExchangeRate of(Currency from, Currency to, float rate) {
        return new ExchangeRate(from, to, rate);
    }

    private ExchangeRate(Currency from, Currency to, float rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format("1%s = %f%s", from.getCode(), rate, to.getCode());
    }
}
