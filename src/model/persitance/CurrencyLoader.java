package model.persitance;

import model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> loadCurrencies();
}
