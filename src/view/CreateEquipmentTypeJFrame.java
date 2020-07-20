package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.EquipmentTypeController;
import entity.EquipmentType;

public class CreateEquipmentTypeJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public CreateEquipmentTypeJFrame() {
		setBounds(100, 100, 400, 500);
		setTitle("新增设备类型");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("设备类型名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 77, 89, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 82, 168, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(50, 351, 105, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String equipmentType = textField.getText();
				EquipmentType et = new EquipmentType(equipmentType);
				EquipmentTypeController equipmentTypeController = new EquipmentTypeController("EquipmentType");
				equipmentTypeController.addEquipmentType(et);
				JOptionPane.showMessageDialog(null, "新增设备类型成功！");
				EquipmentTypeManageJPanel.initTable();
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
	}

}
