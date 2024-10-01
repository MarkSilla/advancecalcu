import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class RoundedButton extends JButton {
    private final int cornerRadius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.cornerRadius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        super.paintComponent(g2);
        g2.dispose();
    }
}

public class dataBoysCalculator {
    private double currentValue = 0;
    private boolean isNewOperation = false;

    public static void main(String[] args) {
        new dataBoysCalculator().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Data Boys Advance Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(550, 625);
        frame.getContentPane().setBackground(Color.black);

        JTextField display = new JTextField();
        display.setBounds(25, 25, 485, 100);
        display.setEditable(false);
        display.setBackground(Color.white);
        display.setForeground(Color.BLACK);
        frame.add(display);

        ActionListener listener = e -> ButtonClick(e, display);

        // Button creation 
        createRoundedButton("DEL", 25, 140, listener, frame, 65, new Color(204, 0, 0), Color.WHITE);
        createRoundedButton("AC", 95, 140, listener, frame, 65, new Color(204, 0, 0), Color.WHITE);   
        createRoundedButton("+/-", 165, 140, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("+", 235, 140, listener, frame, 65, new Color(255, 153, 0), Color.WHITE);
        createRoundedButton("FLR", 305, 140, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("CEIL", 375, 140, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("INT", 445, 140, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("7", 25, 195, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("8", 95, 195, listener, frame, 65,Color.white, Color.BLACK);
        createRoundedButton("9", 165, 195, listener, frame, 65,Color.white, Color.BLACK);
        createRoundedButton("-", 235, 195, listener, frame, 65, new Color(255, 153, 0), Color.white);
        createRoundedButton("//", 305, 195, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("%", 375, 195, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("N!", 445, 195, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("4", 25, 250, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("5", 95, 250, listener, frame, 65,Color.white, Color.BLACK);
        createRoundedButton("6", 165, 250, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("×", 235, 250, listener, frame, 65, new Color(250, 153, 0), Color.WHITE);      
        createRoundedImageButton("equationimages/squareroot.png", 305, 250, listener, frame, 40,40);
        createRoundedImageButton("equationimages/cuberoot.png", 375, 250, listener, frame, 40,40);
        createRoundedImageButton("equationimages/summation.png", 445, 250, listener, frame, 40, 40);
        createRoundedButton("1", 25, 305, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("2", 95, 305, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("3", 165, 305, listener, frame, 65, Color.white, Color.BLACK); 
        createRoundedButton("÷", 235, 305, listener, frame, 65, new Color(250, 153, 0), Color.white);       
        createRoundedImageButton("equationimages/xy.png", 305, 305, listener, frame, 40, 40);
        createRoundedImageButton("equationimages/xyz.png", 375, 305, listener, frame, 40, 40);
        createRoundedImageButton("equationimages/Pi.png", 445, 305, listener, frame, 40, 40);
        createRoundedButton("0", 25, 360, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton(".", 95, 360, listener, frame, 65, Color.white, Color.BLACK);
        createRoundedButton("=", 165, 360, listener, frame, 135, new Color(0, 153, 0), Color.white);
        createRoundedImageButton("equationimages/dualsummation.png", 305, 360, listener, frame, 80, 40);
        createRoundedImageButton("equationimages/dualpi.png", 415, 360, listener, frame, 70, 40);
        createRoundedButton("SET", 25, 415, listener, frame, 275, new Color(102,102,102), Color.WHITE);
        createRoundedImageButton("equationimages/log2x.png", 305, 415, listener, frame, 80, 40);
        createRoundedImageButton("equationimages/logx.png", 415, 415, listener, frame, 70, 40);
        createRoundedButton("A", 25, 470, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("B", 95, 470, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("C", 165, 470, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedButton("D", 235, 470, listener, frame, 65, new Color(102,102,102), Color.WHITE);
        createRoundedImageButton("equationimages/asumb.png", 305, 470, listener, frame, 80, 40);
        createRoundedImageButton("equationimages/adivb.png", 415, 470, listener, frame, 70, 40);       
        createRoundedImageButton("equationimages/x.png", 25, 525, listener, frame, 50, 40);        
        createRoundedImageButton("equationimages/xsumy.png", 105, 525, listener, frame, 50, 40);        
        createRoundedImageButton("equationimages/xy.png", 185, 525, listener, frame, 50, 40);        
        createRoundedImageButton("equationimages/c.png", 265, 525, listener, frame, 50, 40);        
        createRoundedImageButton("equationimages/xsumc.png", 345, 525, listener, frame, 55, 40);        
        createRoundedImageButton("equationimages/xc.png", 430, 525, listener, frame, 55, 40);
        frame.setVisible(true);
    }
     
    //for RoundedButtons
    private void createRoundedButton(String text, int x, int y, ActionListener listener, JFrame frame, int width, Color backgroundColor, Color foreGroundColor) {
        RoundedButton button = new RoundedButton(text, 20);
        button.setBounds(x, y, width, 50);
        button.setForeground(foreGroundColor); 
        button.setFont(new Font("Serif", Font.PLAIN, 14));
        button.setBackground(backgroundColor); 
        button.addActionListener(listener);
        frame.add(button);
    }

    //for RoundedImageButtons
    private void createRoundedImageButton(String imageName, int x, int y, ActionListener listener, JFrame frame, int imageWidth, int imageHeight) {
        ImageIcon originalIcon = new ImageIcon(imageName);
        Image resizedImage = originalIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

        RoundedButton button = new RoundedButton("", 20); // Create a rounded button with no text
        button.setIcon(new ImageIcon(resizedImage)); // Set the resized image as the button icon
        button.setBounds(x, y, imageWidth + 25, imageHeight + 10); // Adjust the bounds for the button
        button.setBackground(new Color(204,204,204));
        button.setFont(new Font("Serif", Font.PLAIN, 14));
        button.addActionListener(listener);
        frame.add(button);
    }


    private void ButtonClick(ActionEvent e, JTextField display) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "=":
                calculate(display);
                break;
            case "DEL":
                clearLastEntry(display);
                break;
            case "AC":
                clearAllEntry(display);
                break;
            default:
                appendToDisplay(display, buttonText);
                break;
        }
    }

    private void appendToDisplay(JTextField display, String text) {
        String currentText = display.getText();
    
        if (isNewOperation) {
            display.setText(text);
            isNewOperation = false; 
        } else {
            // Check if the last character is an operator
            if (!currentText.isEmpty()) {
                char lastChar = currentText.charAt(currentText.length() - 1);
    
                // If the last character is not an operator, append the new text
                if (!isOperator(lastChar)) {
                    // If the new text is a number or a decimal, append it normally
                    if (Character.isDigit(text.charAt(0)) || text.equals(".")) {
                        display.setText(currentText + text);
                    } else { // If the new text is an operator, add a space before appending
                        display.setText(currentText + " " + text + " ");
                    }
                } else {
                    // Last character was an operator; replace it with the new operator
                    display.setText(currentText.substring(0, currentText.length() - 1) + " " + text + " ");
                }
            } else {
                
                display.setText(text);
            }
        }
    }
    

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '×' || ch == '÷';
    }

    private void clearLastEntry(JTextField display) {
        String currentText = display.getText();
        if (!currentText.isEmpty()) {
            display.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private void clearAllEntry(JTextField display) {
        display.setText("");
        currentValue = 0;
        isNewOperation = true;
    }

    private void calculate(JTextField display) {
        String input = display.getText().trim();
        if (input.isEmpty()) return;
    
        // Split the input based on spaces
        String[] tokens = input.split("\\s+"); // Split by one or more spaces
    
        if (tokens.length == 3) { // Expecting format "num1 operator num2"
            try {
                double firstValue = Double.parseDouble(tokens[0].trim());
                String operator = tokens[1].trim();
                double secondValue = Double.parseDouble(tokens[2].trim());
    
                switch (operator) {
                    case "+":
                        currentValue = firstValue + secondValue;
                        break;
                    case "-":
                        currentValue = firstValue - secondValue;
                        break;
                    case "×":
                        currentValue = firstValue * secondValue;
                        break;
                    case "÷":
                        if (secondValue != 0) {
                            currentValue = firstValue / secondValue;
                        } else {
                            display.setText("Cannot divide by zero");
                            return;
                        }
                        break;
                    default:
                        display.setText("Invalid operation");
                        return;
                }
    
                display.setText(String.valueOf(currentValue));
                isNewOperation = true; // Reset the new operation flag
            } catch (NumberFormatException e) {
                display.setText("Error"); // Handle parsing error
            }
        } else {
            display.setText("Invalid input");
        }
    }
}    