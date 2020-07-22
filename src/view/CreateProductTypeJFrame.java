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
import controller.ProductTypeController;
import entity.EquipmentType;
import entity.ProductType;
import utils.Tool;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 新建产品类别JFrame
 */
public class CreateProductTypeJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public CreateProductTypeJFrame() {
		setBounds(100, 100, 400, 500);
		setTitle("新增产品类别");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("产品类别名称：");
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
				String productType = textField.getText();
				if (Tool.isProductTypeExisted(productType)) {
					JOptionPane.showMessageDialog(null, "已存在同名产品类别！");
					textField.setText("");
				} else {
					ProductType pt = new ProductType(productType);
					ProductTypeController productTypeController = new ProductTypeController("ProductType");
					productTypeController.addProductType(pt);
					JOptionPane.showMessageDialog(null, "新增产品类别成功！");
					ProductTypeManagePanel.initTable();
					dispose();
				}
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
