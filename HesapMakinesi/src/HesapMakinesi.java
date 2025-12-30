import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class HesapMakinesi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	
	private double answer,number;
	int operation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HesapMakinesi frame = new HesapMakinesi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addInput(String str) {
		input.setText(input.getText() + str );
	}
	
	public void calculate() {
		switch(operation){
			case 1:
				answer = number + Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 2:
				answer = number - Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 3:
				answer = number * Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 4:
				answer = number / Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
				
		}
	}
	/**
	 * Create the frame.
	 */
	public HesapMakinesi() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBackground(Color.DARK_GRAY);
		screen.setBounds(10, 11, 365, 69);
		contentPane.add(screen);
		screen.setLayout(null);
		
		input = new JTextField();
		input.setForeground(Color.WHITE);
		input.setBackground(Color.DARK_GRAY);
		input.setEditable(false);
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		input.setBounds(0, 20, 365, 38);
		screen.add(input);
		input.setColumns(10);
		
		JLabel lbl = new JLabel("");
		lbl.setForeground(Color.WHITE);
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		lbl.setBounds(0, 0, 365, 20);
		screen.add(lbl);
		
		JPanel control = new JPanel();
		control.setBackground(Color.DARK_GRAY);
		control.setBounds(10, 91, 365, 359);
		contentPane.add(control);
		control.setLayout(new GridLayout(0, 4, 20, 20));
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("8");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 1;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("4");
		btnNewButton_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_7.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("5");
		btnNewButton_7_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_7_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_7_1);
		
		JButton btnNewButton = new JButton("6");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton("-");
		btnNewButton_6.setBackground(Color.ORANGE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 2;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_6.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("1");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("2");
		btnNewButton_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_9.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("3");
		btnNewButton_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_8.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("*");
		btnNewButton_10.setBackground(Color.ORANGE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 3;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_10.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("0");
		btnNewButton_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
				}
		});
		btnNewButton_11.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_11);
		
		JButton btnNewButton_7_2 = new JButton("=");
		btnNewButton_7_2.setBackground(Color.ORANGE);
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
				lbl.setText("");
			}
		});
		btnNewButton_7_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_7_2);
		
		JButton btnNewButton_7_3 = new JButton("C");
		btnNewButton_7_3.setBackground(Color.ORANGE);
		btnNewButton_7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		btnNewButton_7_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_7_3);
		
		JButton btnNewButton_7_4 = new JButton("/");
		btnNewButton_7_4.setBackground(Color.ORANGE);
		btnNewButton_7_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 4;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_7_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		control.add(btnNewButton_7_4);

	}
}
