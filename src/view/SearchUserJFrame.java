package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
 * @Description 检索用户Jframe
 */
public class SearchUserJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public SearchUserJFrame() {
		setBounds(100, 100, 300, 350);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("请输入需要检索的UserID：");
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
				String userID = textField.getText();
				if (Tool.isIDExisted(userID)) {
					UserManagePanel.initTable(userID);
				} else {
					JOptionPane.showMessageDialog(null, "无此ID用户");
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
