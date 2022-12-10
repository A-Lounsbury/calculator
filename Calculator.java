import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener
{
	public static final int WIDTH = 320;
	public static final int HEIGHT = 300;
	public static final int NUMBER_OF_DIGITS = 30;
	
	private JLabel resultLabel;
	private JLabel operandLabel;
	private JTextField resultField;
	private JTextField operandField;
	private double result = 0.0;
	private double operand = 0.0;
	
	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();
		calculator.setVisible(true);
	}
	
	public Calculator()
	{
		setTitle("Java Swing GUI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		
		resultLabel = new JLabel("Result");
		operandLabel = new JLabel("Operand");
		
		resultField = new JTextField("0.0", NUMBER_OF_DIGITS);
		operandField = new JTextField("", NUMBER_OF_DIGITS);
		
		resultField.setEditable(false);
		operandField.setEditable(false);
		
		JPanel resultPanel = new JPanel(new GridLayout(2, 1));
		resultPanel.add(resultLabel);
		resultPanel.add(resultField);
		
		JPanel operandPanel = new JPanel(new GridLayout(2, 1));
		operandPanel.add(operandLabel);
		operandPanel.add(operandField);
		
		JPanel topPanel = new JPanel(new GridLayout(1, 2)); // holds result and operand
		
		topPanel.add(resultPanel);
		topPanel.add(operandPanel);
		
		add(topPanel, BorderLayout.NORTH);
		
		// making 5 rows of buttons
		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
		
		// reset, clear
		JPanel row1 = new JPanel(new GridLayout(1, 2));
		row1.setLayout(new FlowLayout());
		
		JButton resetButton = new JButton("Reset");
		resetButton.setPreferredSize(new Dimension(82, 26));
		resetButton.addActionListener(this);
		row1.add(resetButton);
		JButton clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(82, 26));
		clearButton.addActionListener(this);
		row1.add(clearButton);
		buttonPanel.add(row1);
		
		// 7, 8, 9, +
		JPanel row2 = new JPanel(new GridLayout(1, 4));
		row2.setLayout(new FlowLayout());
		
		JButton sevenButton = new JButton("7"); 
		sevenButton.addActionListener(this);
		row2.add(sevenButton);
		JButton eightButton = new JButton("8"); 
		eightButton.addActionListener(this);
		row2.add(eightButton);
		JButton nineButton = new JButton("9"); 
		nineButton.addActionListener(this);
		row2.add(nineButton);
		JButton addButton = new JButton("+"); 
		addButton.addActionListener(this);
		row2.add(addButton);
		buttonPanel.add(row2);
		
		// 4, 5, 6, -
		JPanel row3 = new JPanel(new GridLayout(1, 4));
		row3.setLayout(new FlowLayout());
		
		JButton fourButton = new JButton("4"); 
		fourButton.addActionListener(this);
		row3.add(fourButton);
		JButton fiveButton = new JButton("5"); 
		fiveButton.addActionListener(this);
		row3.add(fiveButton);
		JButton sixButton = new JButton("6"); 
		sixButton.addActionListener(this);
		row3.add(sixButton);
		JButton subtractButton = new JButton("-"); 
		subtractButton.addActionListener(this);
		row3.add(subtractButton);
		buttonPanel.add(row3);
		
		// 1, 2, 3, *
		JPanel row4 = new JPanel(new GridLayout(1, 4));
		row4.setLayout(new FlowLayout());
		
		JButton oneButton = new JButton("1"); 
		oneButton.addActionListener(this);
		row4.add(oneButton);
		JButton twoButton = new JButton("2"); 
		twoButton.addActionListener(this);
		row4.add(twoButton);
		JButton threeButton = new JButton("3"); 
		threeButton.addActionListener(this);
		row4.add(threeButton);
		JButton multiplyButton = new JButton("*"); 
		multiplyButton.addActionListener(this);
		row4.add(multiplyButton);
		buttonPanel.add(row4);
		
		// 0, ., /
		JPanel row5 = new JPanel(new GridLayout(1, 3));
		row5.setLayout(new FlowLayout());
		
		JButton zeroButton = new JButton("0");
		zeroButton.setPreferredSize(new Dimension(82, 26));
		zeroButton.addActionListener(this);
		row5.add(zeroButton);
		
		JButton decimalButton = new JButton("."); 
		decimalButton.addActionListener(this);
		row5.add(decimalButton);
		JButton divideButton = new JButton("/"); 
		divideButton.addActionListener(this);
		row5.add(divideButton);
		buttonPanel.add(row5);

		add(buttonPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e)
	{
			assumingCorrectNumberFormats(e);
	}
	
	public void assumingCorrectNumberFormats(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("+"))
		{
			if (operandField.getText().compareTo("") != 0) // if they entered an operand
			{
				result = result + stringToDouble(operandField.getText());
				operandField.setText("");
			}
			else // they have yet to enter an operand
				System.out.println("You must enter a value first.");

			resultField.setText(Double.toString(result));
			operandField.setText("");
		}
		else if (actionCommand.equals("-"))
		{
			if (operandField.getText().compareTo("") != 0)
			{
				result = result - stringToDouble(operandField.getText());
				operandField.setText("");
			}
			else
				System.out.println("You must enter a value first.");
				
			resultField.setText(Double.toString(result));
			operandField.setText("");
		}
		else if (actionCommand.equals("*"))
		{
			if (operandField.getText().compareTo("") != 0)
			{
				result = result * stringToDouble(operandField.getText());
				operandField.setText("");
			}
			else
				System.out.println("You must enter a value first.");
				
			resultField.setText(Double.toString(result));
		}
		else if (actionCommand.equals("/"))
		{
			try
			{
				if (operandField.getText().compareTo("") == 0)
					System.out.println("You must enter a value first.");
				else if (stringToDouble(operandField.getText()) > -1.0 * Math.pow(10, -10) && stringToDouble(operandField.getText()) < 1.0 * Math.pow(10, -10))
				{
					throw new DivideByZeroException();
				}				
				else
					result = result / stringToDouble(operandField.getText());
			}
			catch(DivideByZeroException err)
			{
				System.out.println(err.getMessage());
			}
			resultField.setText(Double.toString(result));
			operandField.setText("");
		}
		else if (actionCommand.equals("."))
		{
			if (operandField.getText().compareTo("") != 0)
			{
				// if there isn't already a decimal
				if (operandField.getText().indexOf('.') == -1)
					operandField.setText(operandField.getText() + ".");
			}
			else
				operandField.setText("0.");
		}
		else if (actionCommand.equals("Reset"))
		{
			result = 0.0;
			resultField.setText("0.0");
		}
		else if (actionCommand.equals("Clear"))
		{
			operandField.setText("");
		}
		else if (actionCommand.equals("0"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "0");
		}
		else if (actionCommand.equals("1"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "1");
			else
				operandField.setText("1");
		}
		else if (actionCommand.equals("2"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "2");
			else
				operandField.setText("2");
		}
		else if (actionCommand.equals("3"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "3");
			else
				operandField.setText("3");
		}
		else if (actionCommand.equals("4"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "4");
			else
				operandField.setText("4");
		}
		else if (actionCommand.equals("5"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "5");
			else
				operandField.setText("5");
		}
		else if (actionCommand.equals("6"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "6");
			else
				operandField.setText("6");
		}
		else if (actionCommand.equals("7"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "7");
			else
				operandField.setText("7");
		}
		else if (actionCommand.equals("8"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "8");
			else
				operandField.setText("8");
		}
		else if (actionCommand.equals("9"))
		{
			if (operandField.getText().compareTo("0") != 0)
				operandField.setText(operandField.getText() + "9");
			else
				operandField.setText("9");
		}
		else
			operandField.setText("Unexpected error.");
	}
	
	private static double stringToDouble(String s)
	{
		return Double.parseDouble(s.trim());
	}
}
