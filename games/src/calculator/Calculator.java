package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
	private static JTextField textField;
	
	public static void createCal() {
		JFrame cal = new JFrame("계산기");

		JPanel panelView = new JPanel();
		panelView.setPreferredSize(new Dimension(500, 80));
		panelView.setLayout(new BoxLayout(panelView, BoxLayout.X_AXIS));

		textField = new JTextField();
		textField.setFont(new Font("맑은고딕", Font.PLAIN, 40));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setEnabled(false);
		panelView.add(textField);

		Container container = cal.getContentPane();
		container.add(panelView, BorderLayout.NORTH);

		JPanel panelCal = new JPanel();
		panelCal.setLayout(new GridLayout(4, 4));

		String[] buttons = { "7", "8", "9", "ⅹ", "4", "5", "6", "－"
				, "1", "2", "3", "＋", ".", "0", "÷", "＝" };

		JButton[] btn = new JButton[buttons.length];

		for (int i = 0; i < buttons.length; i++) {
			btn[i] = new JButton(buttons[i]);
			btn[i].setFont(new Font("맑은고딕", Font.PLAIN, 40));
			panelCal.add(btn[i]);
			btn[i].addActionListener(new InputAction());
		}
		
		container.add(panelCal, BorderLayout.CENTER);
		
		cal.setSize(500, 700);
		cal.setVisible(true);
	}
	
	public static class InputAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String inputKey = e.getActionCommand();
			textField.setText(inputKey);
		}
	}
	
	public static void main(String[] args) {
		createCal();
	}
}
