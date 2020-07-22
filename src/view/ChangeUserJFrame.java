package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserContoller;
import entity.CloudFactory;
import entity.CloudFactoryManager;
import entity.Dealer;
import entity.User;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangeUserJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Create the frame.
	 */
	public ChangeUserJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要修改的UserID：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 69, 178, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(74, 137, 138, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(30, 223, 96, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userID = textField.getText();
				if(Tool.isIDExisted(userID)) {
					dispose();
					ChangeUserJFrame frame = new ChangeUserJFrame(userID);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "无此ID用户");
				}
				dispose();
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(159, 223, 96, 29);
        btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		contentPane.add(btnNewButton_1);
	}
	public ChangeUserJFrame(String userID) {
		UserContoller userContoller = new UserContoller("User");
		User user = userContoller.getUserById(userID);
		
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		JLabel lblNewLabel_3_1 = new JLabel("工厂名称：");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(215, 230, 87, 37);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("工厂简介：");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(215, 280, 87, 37);
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
		textField_2.setBounds(315, 136, 170, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(315, 185, 170, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(315, 234, 170, 23);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(315, 283, 170, 23);
		contentPane.add(textField_5);
        if(user instanceof CloudFactoryManager) {
        	textField.setText(user.getUserID());
        	textField.setEditable(false);
        	textField_1.setText(user.getUserPassword());
        	textField_2.setText(user.getUserName());
        	textField_3.setText(user.getUserPhoneNumber());
        	textField_4.setText(((CloudFactoryManager) user).getMyCloudFactory().getName());
        	textField_5.setText(((CloudFactoryManager) user).getMyCloudFactory().getIntroduction());
		}else if(user instanceof Dealer) {
			textField.setText(user.getUserID());
			textField.setEditable(false);
        	textField_1.setText(user.getUserPassword());
        	textField_2.setText(user.getUserName());
        	textField_3.setText(user.getUserPhoneNumber());
        	textField_4.setVisible(false);
        	textField_5.setVisible(false);
        	lblNewLabel_3_1.setVisible(false);
        	lblNewLabel_3_2.setVisible(false);
		}
        
        JButton btnNewButton = new JButton("修改");
		btnNewButton.setBounds(148, 396, 120, 37);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				UserContoller userContoller = new UserContoller("User");
				if(user instanceof CloudFactoryManager) {
					String userID = textField.getText();
					String userPassword = textField_1.getText();
					String userName = textField_2.getText();
					String userPhoneNumber = textField_3.getText();
					String name = textField_4.getText();
					String introduction = textField_5.getText();
					CloudFactory myCloudFactory = new CloudFactory(name, introduction, userID, "正常");
					if(userContoller.changeCloudFactoryManager(new CloudFactoryManager(userName, userID, userPassword, userPhoneNumber, myCloudFactory))) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					}else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
					UserManagePanel.initTable();
					dispose();
				}else if(user instanceof Dealer) {
					String userID = textField.getText();
					String userPassword = textField_1.getText();
					String userName = textField_2.getText();
					String userPhoneNumber = textField_3.getText();
					if(userContoller.changeDealer(new Dealer(userName, userID, userPassword, userPhoneNumber))) {
						JOptionPane.showMessageDialog(null, "修改成功！");
					}else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
					UserManagePanel.initTable();
					dispose();
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
        JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(416, 396, 120, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
	}

}
