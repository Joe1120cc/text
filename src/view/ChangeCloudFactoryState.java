package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EquipmentController;
import controller.ProductController;
import controller.ProductTypeController;
import entity.Equipment;
import entity.Product;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ChangeCloudFactoryState extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public ChangeCloudFactoryState(String message) {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要"+message+"的工厂名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 69, 178, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(70, 134, 138, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(30, 223, 96, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText();
				if(Tool.isCloudFactoryNameExisted(name)) {
					if(message.equals("关停")&&Tool.getCloudFactoryStateByName(name).equals("正常")) {
						Tool.updateCloudFactoryState(name, message);
						JOptionPane.showMessageDialog(null, message+"成功！");
						CloudFactoryManagePanel.initTable();
					}else if(message.equals("开启")&&Tool.getCloudFactoryStateByName(name).equals("关停")) {
						Tool.updateCloudFactoryState(name, message);
						JOptionPane.showMessageDialog(null, message+"成功！");
						CloudFactoryManagePanel.initTable();
					}else {
						JOptionPane.showMessageDialog(null, "当前工厂已经处于"+message+"状态！");
					}
				}else {
					JOptionPane.showMessageDialog(null, "无此工厂！");
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

}
