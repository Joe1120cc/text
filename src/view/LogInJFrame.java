package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.UserContoller;
import entity.SuperAdministrator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class LogInJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInJFrame frame = new LogInJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		setTitle("云平台登录");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(79, 93, 135, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(79, 150, 135, 23);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 93, 50, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 152, 50, 23);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(82, 230, 70, 30);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UserContoller userContoller = new UserContoller("User");
				String userID = textField.getText();
				String password = new String(passwordField.getPassword());
				if(userID.equals(SuperAdministrator.ID)&&password.equals(SuperAdministrator.Password)) {
					SuperAdministratorJFrame frame = new SuperAdministratorJFrame();
					frame.setVisible(true);
					dispose();
					return;
				}
				if (userContoller.verify(userID, password) == 1) {
					CloudFactoryManagerJFrame frame = new CloudFactoryManagerJFrame(userID);
					frame.setVisible(true);
					dispose();
				} else if (userContoller.verify(userID, password) == 2) {
					
				} else {
					JOptionPane.showMessageDialog(null, "您输入的账号或密码不正确！");
					passwordField.setText("");
					passwordField.requestFocus();
				}
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("没有账号？点击注册");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(42, 300, 150, 15);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterJFrame frame = new RegisterJFrame();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
