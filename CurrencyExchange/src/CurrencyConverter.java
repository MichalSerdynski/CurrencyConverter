import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {

    private JLabel fromLabel, toLabel, resultLabel;
    private JTextField inputField;
    private JComboBox<String> fromBox, toBox;
    private JButton convertButton;

    private String[] currencies = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD"};

    public CurrencyConverter() {
        super("Currency Converter");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        fromLabel = new JLabel("From:");
        panel.add(fromLabel);

        fromBox = new JComboBox<>(currencies);
        panel.add(fromBox);

        toLabel = new JLabel("To:");
        panel.add(toLabel);

        toBox = new JComboBox<>(currencies);
        panel.add(toBox);

        JLabel inputLabel = new JLabel("Amount:");
        panel.add(inputLabel);

        inputField = new JTextField(10);
        panel.add(inputField);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        panel.add(convertButton);

        resultLabel = new JLabel("");
        panel.add(resultLabel);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String from = fromBox.getSelectedItem().toString();
            String to = toBox.getSelectedItem().toString();
            double amount = Double.parseDouble(inputField.getText());

            double convertedAmount = convert(from, to, amount);
            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, from, convertedAmount, to));
        }
    }

    private double convert(String from, String to, double amount) {
        // You can use any currency exchange API to get the exchange rate and perform the conversion
        // In this example, we are using a fixed exchange rate for demonstration purposes
        double exchangeRate = getExchangeRate(from, to);
        return amount * exchangeRate;
    }

    private double getExchangeRate(String from, String to) {
        switch (from) {
            case "USD":
                switch (to) {
                    case "USD":
                        return 1;
                    case "EUR":
                        return 0.85;
                    case "GBP":
                        return 0.72;
                    case "JPY":
                        return 109.71;
                    case "CAD":
                        return 1.26;
                    case "AUD":
                        return 1.31;
                }
            case "EUR":
                switch (to) {
                    case "USD":
                        return 1.18;
                    case "EUR":
                        return 1;
                    case "GBP":
                        return 0.85;
                    case "JPY":
                        return 129.88;
                    case "CAD":
                        return 1.49;
                    case "AUD":
                        return 1.55;
                }
            case "GBP":
                switch (to) {
                    case "USD":
                        return 1.39;
                    case "EUR":
                        return 1.18;
                    case "GBP":
                        return 1;
                    case "JPY":
                        return 153.27;
                    case "CAD":
                        return 1.77;
                    case "AUD":
                        return 1.84;
                }
            case "JPY":
                switch (to) {
                    case "USD":
                        return 0.0091;
                    case "EUR":
                        return 0.0077;
                    case "GBP":
                        return 0.0065;
                    case "JPY":
                        return 1;
                    case "CAD":
                        return 0.011;
                    case "AUD":
                        return 0.012;
                }
            case "CAD":
                switch (to) {
                    case "USD":
                        return 0.79;
                    case "EUR":
                        return 0.67;
                    case "GBP":
                        return 0.56;
                    case "JPY":
                        return 91.91;
                    case "CAD":
                        return 1;
                    case "AUD":
                        return 1.04;
                }
            case "AUD":
                switch (to) {
                    case "USD":
                        return 0.76;
                    case "EUR":
                        return 0.64;
                    case "GBP":
                        return 0.54;
                    case "JPY":
                        return 83.68;
                    case "CAD":
                        return 0.96;
                    case "AUD":
                        return 1;
                }
            default:
                throw new IllegalArgumentException("Invalid currency");
        }
    }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CurrencyConverter converter = new CurrencyConverter();
                converter.setVisible(true);
            });
        }
    }
