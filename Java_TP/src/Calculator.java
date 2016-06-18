import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel;
	private JPanel calpanel;
	private JPanel valuepanel;
	private JPanel btnpanel;

	private JTextField calfield;
	private JTextField valuefield;

	private JTextField temp;
	private JTextField operator;
	private JTextField back;

	private JButton jbutton[];

	String[] button = { "7", "8", "9", "" , "C" , "4", "5", "6", "/",  "*", "1", "2", "3", "-", "+", "" , "0", "" , ".", "="};

	private double answer = 0;
	private double k;

	public Calculator() {
		super("Calculator");
		setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		calpanel = new JPanel();
		valuepanel = new JPanel();

		calfield = new JTextField(20);
		valuefield = new JTextField(20);

		valuefield.setHorizontalAlignment(JTextField.RIGHT);

		temp = new JTextField();
		back = new JTextField();

		btnpanel = new JPanel();
		btnpanel.setLayout(new GridLayout(4, 5));

		jbutton = new JButton[21];

		panel.add(calpanel);
		panel.add(valuepanel);

		operator = new JTextField();

		operator.setText("");

		for (int i = 0; i < button.length; i++) {
			jbutton[i] = new JButton(button[i]);
			jbutton[i].addActionListener(this);
			btnpanel.add(jbutton[i]);
		}
		
		calpanel.add(calfield);
		valuepanel.add(valuefield);

		add(panel, BorderLayout.NORTH);
		add(btnpanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		//¼ö ÀÔ·Â
		if (s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8" || s == "9"
				|| s == "0" || s == ".") {
			calfield.setText(calfield.getText() + s);
			temp.setText(temp.getText() + s);
		}

	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setSize(250, 300);
		c.setVisible(true);
	}

}