package controller;

import model.Currency;
import model.ExchangeRate;
import model.ExchangedMoney;
import model.persitance.ExchangeRateLoader;
import model.ExchangeRateLoaderImpl;
import view.ExchangeRateDialog;

import javax.swing.*;

public class ExchangeRateController {

    private final ExchangeRateLoader exchangeRateLoader;

    public ExchangeRateController() {
        this.exchangeRateLoader = new ExchangeRateLoaderImpl();
    }

    public void showDialog(JFrame frame, Currency from, Currency to, String totalMoney) {
        try {
            new ExchangeRateDialog(frame, new ExchangedMoney(Float.parseFloat(totalMoney), getExchangeRate(from, to)));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Introduce valid number.");
        }
    }

    private ExchangeRate getExchangeRate(Currency from, Currency to) {
        return exchangeRateLoader.exchangeRateLoader(from, to);
    }
}
