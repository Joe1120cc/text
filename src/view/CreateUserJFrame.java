package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserContoller;
import entity.CloudFactory;
import entity.CloudFactoryManager;
import entity.Dealer;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 新建用户JFrame
 */
public class CreateUserJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Vector<String> vName;

	/**
	 * Create the frame.
	 */
	public CreateUserJFrame() {
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		setTitle("新建用户");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		vName = new Vector<String>();
		vName.add("云工厂管理员");
		vName.add("经销商");

		JLabel lblNewLabel = new JLabel("登陆账号：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 30, 87, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("登陆密码：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(215, 80, 87, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("真实姓名：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(215, 130, 87, 37);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("联系方式：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(215, 180, 87, 37);
		contentPane.add(lblNewLabel_3);

		JComboBox<String> comboBox = new JComboBox<String>(vName);
		comboBox.setBounds(315, 230, 170, 23);
		contentPane.add(comboBox);

		JLabel lblNewLabel_3_1 = new JLabel("工厂名称：");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(215, 280, 87, 37);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("工厂简介：");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(215, 330, 87, 37);
		contentPane.add(lblNewLabel_3_2);

		textField = new JTextField();
		textField.setBounds(315, 38, 170, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(315, 87, 170, 23);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(315, 137, 170, 23);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(315, 188, 170, 23);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(315, 288, 170, 23);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(315, 338, 170, 23);
		contentPane.add(textField_5);

		JButton btnNewButton = new JButton("新建");
		btnNewButton.setBounds(139, 396, 120, 37);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UserContoller userContoller = new UserContoller("User");
				String userID = textField.getText();
				String userPassword = textField_1.getText();
				String userName = textField_2.getText();
				String userPhoneNumber = textField_3.getText();
				String item = (String) comboBox.getSelectedItem();
				if (userID == null || userID.equals("")) {
					// 消息框
					JOptionPane.showMessageDialog(null, "ID不能为空");
					// 输入框获取焦点
					textField.requestFocus();
					return;
				}
				if (userID.indexOf(" ") >= 0) {
					// 消息框
					JOptionPane.showMessageDialog(null, "ID不能包含空格");
					// 输入框获取焦点
					textField.requestFocus();
					return;
				}

				if (userPassword == null || userPassword.equals("")) {
					// 消息框
					JOptionPane.showMessageDialog(null, "密码不能为空");
					// 输入框获取焦点
					textField_1.requestFocus();
					return;
				}
				if (userPassword.indexOf(" ") >= 0) {
					// 消息框
					JOptionPane.showMessageDialog(null, "密码不能包含空格");
					// 输入框获取焦点
					textField_1.requestFocus();
					return;
				}
				if (item.equals("云工厂管理员")) {
					String name = textField_4.getText();
					String introduction = textField_5.getText();
					if (Tool.isIDExisted(userID)) {
						JOptionPane.showMessageDialog(null, "该账号已被注册！");
						textField.setText("");
						textField.requestFocus();
					} else {
						CloudFactory cf = new CloudFactory(name, introduction, userID, "正常");
						CloudFactoryManager user = new CloudFactoryManager(userName, userID, userPassword,
								userPhoneNumber, cf);
						if (userContoller.addCloudFactoryManager(user)) {
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							JOptionPane.showMessageDialog(null, "新建成功！");
							UserManagePanel.initTable();
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "新建失败！");
							textField.setText("");
							textField.requestFocus();
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
						}
					}
				} else {
					if (Tool.isIDExisted(userID)) {
						JOptionPane.showMessageDialog(null, "该ID已被注册！");
						textField.setText("");
						textField.requestFocus();
					} else {
						Dealer d = new Dealer(userName, userID, userPassword, userPhoneNumber);
						if (userContoller.addDealer(d)) {
							JOptionPane.showMessageDialog(null, "新建成功！");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							UserManagePanel.initTable();
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "新建失败！");
							textField.setText("");
							textField.requestFocus();
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						}
					}
				}

			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(410, 396, 120, 37);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		contentPane.add(btnNewButton_1);

		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) comboBox.getSelectedItem();
					if (item.equals("云工厂管理员")) {
						lblNewLabel_3_1.setVisible(true);
						lblNewLabel_3_2.setVisible(true);
						textField_4.setVisible(true);
						textField_5.setVisible(true);
					} else if (item.equals("经销商")) {
						lblNewLabel_3_1.setVisible(false);
						lblNewLabel_3_2.setVisible(false);
						textField_4.setVisible(false);
						textField_5.setVisible(false);
					}
				}

			}
		});
	}
}
