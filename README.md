# Currency-Converter

1. The entire application is written in Java, a general-purpose, object-oriented programming language.
Key Java features used:
- OOP principles (classes, inheritance)
- Data structures (arrays, HashMap)
- Exception handling (try-catch for number input)

2. Swing (Java GUI Toolkit)
- Java Swing is used for building the Graphical User Interface (GUI).
 Components used:
- JFrame – main window
- JLabel, JButton, JComboBox, JTextField – form elements
- ImageIcon – to display flag images
- GridLayout, GridBagConstraints – for layout management

3. Event Handling
-  Uses ActionListener to handle button clicks (ConvertAction inner class).
-  Also uses a custom ComboBox renderer (CurrencyComboBoxRenderer) to show flags next to currency names.

4. Java Collections
- A HashMap<String, String> (flagPaths) is used to map currency codes (e.g., "USD") to image file paths.

5. File System Integration
- The program loads images (flags) from your local file system using absolute paths.
- Uses ImageIcon to read images and render them in the GUI.

