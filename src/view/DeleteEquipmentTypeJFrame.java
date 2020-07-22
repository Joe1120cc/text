package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EquipmentTypeController;
import controller.ProductTypeController;
import controller.UserContoller;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 删除设备类型JFrame
 */
public class DeleteEquipmentTypeJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public DeleteEquipmentTypeJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("请输入需要删除的类型名：");
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
				if (Tool.isEquipmentTypeExisted(equipmentType)) {
					EquipmentTypeController equipmentTypeController = new EquipmentTypeController("EquipmentType");
					if (equipmentTypeController.deleteEquipmentType(equipmentType)) {
						JOptionPane.showMessageDialog(null, "删除成功！");
						EquipmentTypeManageJPanel.initTable();
					} else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				} else {
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

}
