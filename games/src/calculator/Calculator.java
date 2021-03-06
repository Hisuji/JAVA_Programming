package calculator;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;

public class Calculator extends JFrame {
	private JFrame cal;
	private static JTextField textField;
	private static ArrayList<String> infix = new ArrayList<String>();
	private static Stack<String> operator = new Stack<String>();
	private static ArrayList<String> postfix = new ArrayList<String>();
	private static Stack<Float> calculation = new Stack<Float>();

	public void createCal() {
		cal = new JFrame("계산기");

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

		String[] buttons = { "7", "8", "9", "ⅹ", "4", "5", "6", "－", "1", "2", "3", "＋", "ｃ", "0", "÷", "＝" };

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
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static class InputAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String inputKey = e.getActionCommand();

			if (isNumber(inputKey)) {
				// 숫자키
				textField.setText(textField.getText() + inputKey);
			} else {
				// 연산키
				if (!textField.getText().isEmpty()) {
					// 숫자 저장
					infix.add(textField.getText());
					textField.setText("");
					if (!"＝".equals(inputKey) && !"ｃ".equals(inputKey)) {
						infix.add(inputKey);
					} else if ("ｃ".equals(inputKey)) {
						infix.clear();
						System.out.println("삭제 완료");
					} else {
						// 연산자가 2개 이상일 때만 곱셈, 나눗셈 괄호 적용
						int cnt = 0;
						for (int i = 0; i < infix.size(); i++) {
							if (!isNumber(infix.get(i))) {
								cnt++;
							}
						}

						System.out.println("중위 : " + infix);

						if (cnt >= 2) {
							addParentheses();
						}

						chageNotation();

						System.out.println("후위 : " + postfix);

						// 공백 제거
						for (int i = 0; i < postfix.size(); i++) {
							if (postfix.get(i).isEmpty()) {
								postfix.remove(i);
								--i;
							}
						}

						System.out.println("공백 제거 후위: " + postfix);

						calculate();
					}
				}
			}
		}

		public void calculate() {
			float num1;
			float num2;
			float temp;

			for (int i = 0; i < postfix.size(); i++) {
				if (isNumber(postfix.get(i))) {
					calculation.push(Float.parseFloat(postfix.get(i)));
				} else {
					num1 = calculation.pop();
					num2 = calculation.pop();

					switch (postfix.get(i)) {
					case "＋":
						temp = num2 + num1;
						calculation.push(temp);
						System.out.println(">>>" + calculation);
						break;

					case "ⅹ":
						temp = num2 * num1;
						calculation.push(temp);
						System.out.println(">>>" + calculation);
						break;

					case "÷":
						temp = num2 / num1;
						calculation.push(temp);
						System.out.println(">>>" + calculation);
						break;

					case "－":
						temp = num2 - num1;
						calculation.push(temp);
						System.out.println(">>>" + calculation);
						break;
					}
				}
			}

			if (calculation.size() == 1) {
				DecimalFormat format = new DecimalFormat("#.##");
				textField.setText(format.format(calculation.pop()));
			}
		}

		public void chageNotation() {
			for (int i = 0; i < infix.size(); i++) {
				if (isNumber(infix.get(i))) {
					postfix.add(i, infix.get(i));
				} else {
					if (!"(".equals(infix.get(i)) && !")".equals(infix.get(i))) {
						operator.push(infix.get(i));
						postfix.add(i, "");
					} else if ("(".equals(infix.get(i))) {
						postfix.add(i, "");
					} else if (")".equals(infix.get(i))) {
						postfix.add(i, "");
						postfix.set(i, operator.pop());
					}
				}
			}

			if (operator.size() != 0) {
				postfix.add(postfix.size(), "");

				for (int i = 0; i <= operator.size(); i++) {
					postfix.set(postfix.lastIndexOf(""), operator.pop());
				}
			}
		}

		public void addParentheses() {
			if (infix.contains("ⅹ") && !infix.contains("÷")) {
				createParentheses("ⅹ");
			}
			if (infix.contains("÷") && !infix.contains("ⅹ")) {
				createParentheses("÷");
			}
		}

		public boolean isNumber(String s) {
			try {
				Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		}

		public void createParentheses(String str) {
			int preIndex = infix.indexOf(str) - 2;
			infix.add(preIndex + 1, "(");

			int nextIndex = infix.indexOf(str) + 1;
			infix.add(nextIndex + 1, ")");

			System.out.println("괄호: " + infix);
		}
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.createCal();
	}
}
