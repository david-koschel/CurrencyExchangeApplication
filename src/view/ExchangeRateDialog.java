package view;

import model.ExchangedMoney;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExchangeRateDialog extends JDialog {

    public ExchangeRateDialog(Frame owner, ExchangedMoney exchangedMoney) {
        super(owner, true);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(exchangedMoney.toString());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        setContentPane(panel);
        setSize(300, 85);
        setLocationRelativeTo(owner);
        setVisible(true);
        pack();
    }
}
