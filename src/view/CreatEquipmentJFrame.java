package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EquipmentController;
import entity.CloudFactory;
import entity.Equipment;
import entity.EquipmentType;
import utils.FileUtils;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;

public class CreatEquipmentJFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private Vector<EquipmentType> vData;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public CreatEquipmentJFrame(String userID) {
		setBounds(100, 100, 400, 500);
		setTitle("新增设备");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("设备名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 77, 89, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("设备类型：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 148, 89, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("设备规格：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(61, 219, 89, 38);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(157, 82, 168, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 224, 168, 29);
		contentPane.add(textField_2);
		
		vData = new Vector<EquipmentType>();
		List<Object> v = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		for(Object o : v) {
			EquipmentType e = (EquipmentType)o;
			vData.add(e);
		}
		
		JComboBox<EquipmentType> comboBox = new JComboBox<EquipmentType>(vData);
		comboBox.setBounds(157, 153, 168, 29);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(50, 351, 105, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String equipmentID = "EMT"+(new Random().nextInt(899999999) + 100000000);
				String equipmentName = textField.getText();
				String equipmentSpecification = textField_2.getText();
				String equipmentDescription = textField_1.getText();
				EquipmentType et = (EquipmentType)comboBox.getSelectedItem();
				CloudFactory cf = Tool.getCloudFactoryByID(userID);
				Equipment ep = new Equipment(equipmentID, equipmentName, et, equipmentSpecification, cf, equipmentDescription,"已关闭","工厂设备");
				EquipmentController equipmentController = new EquipmentController("Equipment");
				equipmentController.addEquipment(ep);
				MyEquipmentsJPanel.initTable(userID);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(235, 351, 105, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("设备描述：");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(61, 290, 89, 38);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 295, 168, 29);
		contentPane.add(textField_1);
	}

}
