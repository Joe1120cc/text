package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.EquipmentTypeController;
import controller.ProductController;
import controller.ProductTypeController;
import entity.EquipmentType;
import entity.Product;
import entity.ProductType;
import utils.FileUtils;

import javax.swing.JComboBox;

public class CreateProductJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Vector<ProductType> vName;
	/**
	 * Create the frame.
	 */
	public CreateProductJFrame() {
		setBounds(100, 100, 400, 500);
		setTitle("新增产品");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		vName = new Vector<ProductType>();
		List<Object> list = FileUtils.getData("ProductTypes.txt", ProductType.class);
		for(Object o : list) {
			ProductType p = (ProductType)o;
			vName.add(p);
		}
		
		JLabel lblNewLabel = new JLabel("产品名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 77, 89, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 82, 168, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<ProductType> comboBox = new JComboBox<ProductType>(vName);
		comboBox.setBounds(157, 135, 168, 29);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(50, 351, 105, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String productName = textField.getText();
				String productSpecification = textField_1.getText();
				String productDescription = textField_2.getText();
				ProductType pt = (ProductType)comboBox.getSelectedItem();
				String productID = "PDT"+(new Random().nextInt(899999999) + 100000000);
				Product p = new Product(productID, productName, pt, productSpecification, productDescription);
				ProductController productController = new ProductController("Product");
				if(productController.addProduct(p)) {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null, "新建产品成功！");
					ProductManagePanel.initTable();
				}else {
					JOptionPane.showMessageDialog(null, "新建产品失败！");
				}
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
		
		JLabel lblNewLabel_1 = new JLabel("产品类别：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 130, 89, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("产品规格：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(61, 183, 89, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("产品描述：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(61, 236, 89, 38);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 188, 168, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 241, 168, 29);
		contentPane.add(textField_2);
		
	}

}
