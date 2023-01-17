package model;

import model.persitance.ExchangeRateLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ExchangeRateLoaderImpl implements ExchangeRateLoader {

    private static final String urlString = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/%s/%s.json";

    @Override
    public ExchangeRate exchangeRateLoader(Currency from, Currency to) {
        return ExchangeRate.of(from, to, getRateFromWebService(from, to));
    }

    private float getRateFromWebService(Currency from, Currency to) {
        return getRateFromJsonString(
                jsonStringFromUrl(
                        String.format(urlString, from.getCode().toLowerCase(), to.getCode().toLowerCase())
                )
        );
    }

    private float getRateFromJsonString(String json) {
        json = json.split(": ")[2];
        return Float.parseFloat(json.substring(0, json.length() - 2));
    }

    private String jsonStringFromUrl(String urlString) {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(json);
    }
}
