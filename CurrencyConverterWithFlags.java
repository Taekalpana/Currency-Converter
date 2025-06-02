
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class CurrencyConverterWithFlags extends JFrame {
	    private final String[] currencies = {"USD", "EUR", "JPY", "GBP", "CAD", "AUD", "CHF", "CNY", "INR"};
	    private final double[] exchangeRates = {1.00, 0.91, 150.3, 0.78, 1.38, 1.54, 0.91, 7.35, 83.1};
	    private final Map<String, String> flagPaths = new HashMap<>();
	    private JComboBox<String> fromCurrencyBox, toCurrencyBox;
	    private JTextField amountField;
	    private JLabel resultLabel;

	    public CurrencyConverterWithFlags() {
	        setTitle("Currency Converter with Flags");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(5, 2, 10, 10));

	        // Initialize flag paths
	        initializeFlagPaths();
	        setLocationRelativeTo(null);
	        initializeFlagPaths();
	        setVisible(true);

	        // UI Components
	        JLabel fromLabel = new JLabel("From:");
	        fromCurrencyBox = new JComboBox<>(currencies);
	        fromCurrencyBox.setRenderer(new CurrencyComboBoxRenderer());

	        JLabel toLabel = new JLabel("To:");
	        toCurrencyBox = new JComboBox<>(currencies);
	        toCurrencyBox.setRenderer(new CurrencyComboBoxRenderer());

	        JLabel amountLabel = new JLabel("Amount:");
	        amountField = new JTextField();

	        JButton convertButton = new JButton("Convert");
	        convertButton.addActionListener(new ConvertAction());

	        resultLabel = new JLabel("Result: ");
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10); 
	        gbc.anchor = GridBagConstraints.WEST; 

	        // Add components to the layout
	        gbc.gridx = 0; gbc.gridy = 0;
	        add(fromLabel, gbc);

	        gbc.gridx = 1; gbc.gridy = 0;
	        add(fromCurrencyBox, gbc);

	        gbc.gridx = 0; gbc.gridy = 1;
	        add(toLabel, gbc);

	        gbc.gridx = 1; gbc.gridy = 1;
	        add(toCurrencyBox, gbc);

	        gbc.gridx = 0; gbc.gridy = 2;
	        add(amountLabel, gbc);

	        gbc.gridx = 1; gbc.gridy = 2;
	        add(amountField, gbc);

	        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.CENTER; 
	        add(convertButton, gbc);

	        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
	        add(resultLabel, gbc);

	        setVisible(true);

	        // Add components to frame
	        add(fromLabel);
	        add(fromCurrencyBox);
	        add(toLabel);
	        add(toCurrencyBox);
	        add(amountLabel);
	        add(amountField);
	        add(new JLabel()); 
	        add(convertButton);
	        add(resultLabel);

	        setVisible(true);
	    }

	    private void initializeFlagPaths() {
	        flagPaths.put("USD", "C:\\Users\\keaha\\OneDrive\\Documents\\Projects\\minpro-5th\\usd.png");
	        flagPaths.put("EUR", "C:\\Users\\keaha\\OneDrive\\Documents\\Projects\\minpro-5th\\euro.png");
	        flagPaths.put("JPY", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 213826.png");
	        flagPaths.put("GBP", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214140.png");
	        flagPaths.put("CAD", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214259.png");
	        flagPaths.put("AUD", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214348.png");
	        flagPaths.put("CHF", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214437.png");
	        flagPaths.put("CNY", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214602.png");
	        flagPaths.put("INR", "C:\\Users\\keaha\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-29 214714.png");
	    }

	    private class ConvertAction implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                double amount = Double.parseDouble(amountField.getText());
	                int fromIndex = fromCurrencyBox.getSelectedIndex();
	                int toIndex = toCurrencyBox.getSelectedIndex();
	                double rate = exchangeRates[toIndex] / exchangeRates[fromIndex];
	                double result = amount * rate;
	                resultLabel.setText(String.format("Result: %.2f %s", result, currencies[toIndex]));
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
	            }
	        }
	    }

	    private class CurrencyComboBoxRenderer extends DefaultListCellRenderer {
	        @Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            String currency = (String) value;
	            String flagPath = flagPaths.get(currency);

	            if (flagPath != null) {
	                ImageIcon icon = new ImageIcon(flagPath);
	                label.setIcon(icon);
	            }
	            label.setHorizontalTextPosition(SwingConstants.RIGHT);
	            return label;
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(CurrencyConverterWithFlags::new);
	    }
	}

	



	