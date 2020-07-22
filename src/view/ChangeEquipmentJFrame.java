package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EquipmentController;
import controller.ProductController;
import entity.Equipment;
import entity.EquipmentType;
import entity.Product;
import entity.ProductType;
import utils.FileUtils;
import utils.Tool;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ChangeEquipmentJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private Vector<EquipmentType> vName;
	/**
	 * Create the frame.
	 */
	public ChangeEquipmentJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要修改的设备ID：");
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
				String equipmentID = textField.getText();
				if(Tool.isEquipmentIDExisted(equipmentID)) {
					dispose();
					ChangeEquipmentJFrame frame = new ChangeEquipmentJFrame(equipmentID);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "无此设备ID");
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
	public ChangeEquipmentJFrame(String equipmentID) {
		EquipmentController equipmentController = new EquipmentController("Equipment");
		Equipment E = equipmentController.getEquipmentByID(equipmentID);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		vName = new Vector<EquipmentType>();
		List<Object> list = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		for(Object o : list) {
			EquipmentType e = (EquipmentType)o;
			vName.add(e);
		}
		
		JComboBox<EquipmentType> comboBox = new JComboBox<EquipmentType>(vName);
		comboBox.setBounds(315, 87, 170, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("设备名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 30, 87, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("设备类型：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(215, 80, 87, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("设备规格：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(215, 130, 87, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("设备描述：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(215, 180, 87, 37);
		contentPane.add(lblNewLabel_3);	
		
		textField = new JTextField();
		textField.setBounds(315, 38, 170, 23);
		contentPane.add(textField);
		textField.setColumns(10);
			
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(315, 136, 170, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(315, 185, 170, 23);
		contentPane.add(textField_3);
		
		textField.setText(E.getEquipmentName());
		textField_2.setText(E.getEquipmentSpecification());
		textField_3.setText(E.getEquipmentDescription());
		
		JButton btnNewButton = new JButton("修改");
	    btnNewButton.setBounds(148, 396, 120, 37);
	    btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String equipmentName = textField.getText();
				String equipmentSpecification = textField_2.getText();
				String equipmentDescription = textField_3.getText();
				EquipmentController equipmentController = new EquipmentController("Equipment");
				EquipmentType et = (EquipmentType) comboBox.getSelectedItem();
				Equipment eq = new Equipment(equipmentID, equipmentName, et, equipmentSpecification, E.getEquipmentOwnedFactory(), E.getEquipmentDescription(), E.getEquipmentState(), E.getRentState());
				if(equipmentController.changeEquipment(eq)) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					EquipmentManagePanel.initTable();
				}else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
				dispose();
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
