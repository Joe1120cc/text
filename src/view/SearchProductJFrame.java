package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductController;
import controller.ProductTypeController;
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

public class SearchProductJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public SearchProductJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("请输入需要检索产品ID或名称：");
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
				String data = textField.getText();
				if(Tool.isProductDataContained(data)) {
					ProductController productController = new ProductController("Product");
					ArrayList<Product> list = productController.getContainedProduct(data);
					ProductManagePanel.initTable(list);
				}else {
					JOptionPane.showMessageDialog(null, "无与此相关产品！");
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
