import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
	JFrame frame;
	private String first = "";
	private String result = "";
	JTextField calfield;
	JTextField valuefield;
	GridLayout grid;
	JButton But;
	JPanel btnpanel;
	JPanel textpanel;
	ArrayList<Integer> ee = new ArrayList<Integer>();
	ArrayList<String> store = new ArrayList<String>();
	String[] button = { "7", "8", "9", "", "C", "4", "5", "6", "/", "*", "1", "2", "3", "-", "+", "", "0", "", ".",
			"=" };

	public Calculator() {
		frame = new JFrame("Calculator");
		calfield = new JTextField("");
		valuefield = new JTextField("0");
		textpanel = new JPanel();
		btnpanel = new JPanel();
		valuefield = new JTextField("0");
		calfield = new JTextField("");
	}

	// ==========================GUI======================================================================//
	public void gui() {
		valuefield.setHorizontalAlignment(JTextField.RIGHT);
		valuefield.setEditable(false);
		calfield.setHorizontalAlignment(JTextField.RIGHT);
		calfield.setEditable(false);

		textpanel.setLayout(new BorderLayout());
		textpanel.add(BorderLayout.NORTH, calfield);
		textpanel.add(BorderLayout.CENTER, valuefield);

		btnpanel.setLayout(new GridLayout(4, 3, 6, 6));

		for (int i = 0; i < button.length; i++) {
			But = new JButton(button[i]);
			But.addActionListener(this);
			btnpanel.add(But);
		}

		frame.add(textpanel, BorderLayout.NORTH);
		frame.add(btnpanel, BorderLayout.CENTER);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ===========================================================연산자,숫자
	// listener===========================================
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String read;

		try {

			if (s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8" || s == "9"
					|| s == "0" || s == ".") {
				calfield.setText(first);
				calfield.getText();
				valuefield.setText("");
				valuefield.getText();

				read = calfield.getText();
				first = read + s;
				calfield.setText(first);
				calfield.getText();
			}

			if (s == "/" || s == "*" || s == "-" || s == "+" || s == "=") {
				valuefield.setText(s);
				valuefield.getText();

				ee.add(Integer.parseInt(first));
				first = "";

				store.add(s);
			}

			if (s == "=") {
				int sum = 0;
				sum = ee.get(0);

				for (int a = 0, h = 1; a < ee.size(); a++, h++) {
					int ve = store.size();
					if (ve > 0) {
						ve--;

						if (store.get(a) == "+") {
							sum = sum + ee.get(h);
						} else if (store.get(a) == "-") {
							sum = sum - ee.get(h);
						} else if (store.get(a) == "*") {
							sum = sum * ee.get(h);
						} else if (store.get(a) == "/") {
							try {
								sum = sum / ee.get(h);
							} catch (Exception exc) {
								sum = 0;
							}
						}
					}
				}
				result = sum + "";
				calfield.setText(result);
				calfield.getText();
			}

			if (s == "C") {
				first = "";
				calfield.setText("0");
				calfield.getText();
				valuefield.setText("");
				valuefield.getText();
				ee.clear();
				store.clear();
			}

		} catch (Exception ex) {
			calfield.setText("Error");
			calfield.getText();
		}

	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.gui();
	}
}