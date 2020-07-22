package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EquipmentTypeController;
import controller.ProductTypeController;
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

public class ChangeEquipmentTypeJFrame extends JFrame {
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
	public ChangeEquipmentTypeJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要修改的类型名称：");
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
				String equipmentType = textField.getText();
				if(Tool.isEquipmentTypeExisted(equipmentType)) {
					dispose();
					ChangeEquipmentTypeJFrame frame = new ChangeEquipmentTypeJFrame(equipmentType);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "无此设备类型");
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
	public ChangeEquipmentTypeJFrame(String equipmentType) {
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_3 = new JLabel("修改后的类型名称：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(145, 180, 157, 37);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(300, 185, 170, 23);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("修改");
	    btnNewButton.setBounds(148, 396, 120, 37);
	    btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newEquipmentType = textField_3.getText();
				EquipmentTypeController equipmentTypeController = new EquipmentTypeController("EquipmentType");
				if(equipmentTypeController.changeEquipmentType(equipmentType, newEquipmentType)) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					EquipmentTypeManageJPanel.initTable();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "修改失败！");
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
