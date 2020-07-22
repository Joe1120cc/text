package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 云工厂管理员JFrame
 */
public class CloudFactoryManagerJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menubar1;
	private ImageIcon im;
	private static CloudFactoryManagerJFrame instance = null;

	/**
	 * Create the frame.
	 */
	private CloudFactoryManagerJFrame(String userID) {
		menubar1 = new JMenuBar();

		JMenu menu1 = new JMenu("我的工厂");

		JMenu menu2 = new JMenu("订单管理");

		menubar1.add(menu1);

		menubar1.add(menu2);

		JMenuItem item1 = new JMenuItem("我的设备");

		JMenuItem item2 = new JMenuItem("订单接单");

		JMenuItem item3 = new JMenuItem("订单排产");

		menu1.add(item1);

		menu2.add(item2);
		menu2.addSeparator();

		menu2.add(item3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setTitle("云制造平台");
		setJMenuBar(menubar1);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(new MyEquipmentsJPanel(userID));
			}
		});

		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		im = new ImageIcon("material/CloudManager.jpg");// 设置背景图
		JLabel lblNewLabel_3 = new JLabel(im);
		lblNewLabel_3.setBackground(new Color(255, 204, 153));
		lblNewLabel_3.setBounds(0, 0, 1000, 700);
		contentPane.add(lblNewLabel_3);

	}

	public void changeContentPane(JPanel contentPane) {
		setContentPane(contentPane);
		revalidate();
	}

	public static CloudFactoryManagerJFrame getInstance(String userID) {
		if (instance == null) {
			instance = new CloudFactoryManagerJFrame(userID);
		}
		return instance;
	}

	public void set() {
		setContentPane(contentPane);
	}
}
