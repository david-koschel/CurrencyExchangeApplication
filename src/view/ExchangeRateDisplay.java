package view;

import controller.ExchangeRateController;
import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExchangeRateDisplay extends JFrame {

    private final JComboBox<Currency> from, to;
    private final List<Currency> currencies;
    private final ExchangeRateController exchangeRateController;
    private final JTextField input;

    public ExchangeRateDisplay(List<Currency> currencies) {
        super("EXCHANGE RATE CONVERTER");
        this.currencies = currencies;
        this.exchangeRateController = new ExchangeRateController();
        from = createDropdown();
        to = createDropdown();
        input = createInputText();
        setContentPane(createMainPanel());
        setVisible(true);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Currency Exchange Converter");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(inputPanel());
        panel.add(dropdownPanel("From: ", from));
        panel.add(dropdownPanel("To: ", to));
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accept();
            }
        });
        panel.add(button);
        button.setAlignmentX(CENTER_ALIGNMENT);
        return panel;
    }

    private JPanel inputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Money to convert: ");
        panel.add(label);
        panel.add(input);
        panel.setAlignmentX(CENTER_ALIGNMENT);
        return panel;
    }

    private JPanel dropdownPanel(String text, JComboBox dropdown) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel(text);
        panel.add(label);
        panel.add(dropdown);
        panel.setAlignmentX(CENTER_ALIGNMENT);
        return panel;
    }

    private JTextField createInputText() {
        JTextField result = new JTextField();
        result.setColumns(10);
        return result;
    }

    private JComboBox<Currency> createDropdown() {
        return new JComboBox<>(currencies.toArray(Currency[]::new));
    }

    private void accept() {
        exchangeRateController.showDialog(
                this,
                from.getItemAt(from.getSelectedIndex()),
                to.getItemAt(to.getSelectedIndex()),
                getFormattedInputText()
        );

    }

    private String getFormattedInputText() {
        return input.getText().replaceAll("[,']", ".");
    }
}