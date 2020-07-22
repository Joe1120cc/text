package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductController;
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

public class ChangeProductJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private Vector<ProductType> vName;
	/**
	 * Create the frame.
	 */
	public ChangeProductJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要修改的产品ID：");
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
				String productID = textField.getText();
				if(Tool.isProductIDExisted(productID)) {
					dispose();
					ChangeProductJFrame frame = new ChangeProductJFrame(productID);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "无此产品类别");
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
	public ChangeProductJFrame(String productID) {
		ProductController productController = new ProductController("Product");
		Product p = productController.getProductByID(productID);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		vName = new Vector<ProductType>();
		List<Object> list = FileUtils.getData("ProductTypes.txt", ProductType.class);
		for(Object o : list) {
			ProductType P = (ProductType)o;
			vName.add(P);
		}
		
		JComboBox<ProductType> comboBox = new JComboBox<ProductType>(vName);
		comboBox.setBounds(315, 87, 170, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("产品名称：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 30, 87, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("产品类别：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(215, 80, 87, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("产品规格：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(215, 130, 87, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("产品描述：");
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
		
		textField.setText(p.getProductName());
		textField_2.setText(p.getProductSpecification());
		textField_3.setText(p.getProductDescription());
		
		JButton btnNewButton = new JButton("修改");
	    btnNewButton.setBounds(148, 396, 120, 37);
	    btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productName = textField.getText();
				String productSpecification = textField_2.getText();
				String productDescription = textField_3.getText();
				ProductType pt = (ProductType) comboBox.getSelectedItem();
				productController.changeProduct(new Product(productID, productName, pt, productSpecification, productDescription));
				ProductManagePanel.initTable();
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
