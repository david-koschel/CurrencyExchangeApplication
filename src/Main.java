import model.CurrencyLoaderImpl;
import view.ExchangeRateDisplay;

public class Main {

    public static void main(String[] args) {
        CurrencyLoaderImpl currencyLoader = new CurrencyLoaderImpl();
        new ExchangeRateDisplay(currencyLoader.loadCurrencies());
    }
}
