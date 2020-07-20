package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SuperAdministratorJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menubar1;
	/**
	 * Create the frame.
	 */
	public SuperAdministratorJFrame() {
        menubar1 = new JMenuBar();
		
		JMenu menu1 = new JMenu("系统设置");
		
		JMenu menu2 = new JMenu("云工厂");
		
		JMenu menu3 = new JMenu("产品管理");
		
		JMenu menu4 = new JMenu("产能中心");
		
		JMenu menu5 = new JMenu("订单中心");
		
		JMenuItem item1 = new JMenuItem("用户管理");
		
		JMenuItem item2 = new JMenuItem("云工厂信息");
		
		JMenuItem item31 = new JMenuItem("产品类别管理");
		
		JMenuItem item32 = new JMenuItem("产品信息管理");
		
		JMenuItem item41 = new JMenuItem("设备类型管理");
		
		JMenuItem item42 = new JMenuItem("设备管理");
		
		JMenuItem item5 = new JMenuItem("订单基本信息");
		
		menu1.add(item1);
		
		menu2.add(item2);
		
		menu3.add(item31);
		menu3.addSeparator();
		menu3.add(item32);
		
		menu4.add(item41);
		menu4.addSeparator();
		menu4.add(item42);
		
		menu5.add(item5);
		
		menubar1.add(menu1);

		menubar1.add(menu2);
		
		menubar1.add(menu3);

		menubar1.add(menu4);
		
		menubar1.add(menu5);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setTitle("欢迎超级管理员进入云制造平台");
		setJMenuBar(menubar1);
		this.setLocationRelativeTo(null);
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		item31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		item32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		item41.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(new EquipmentTypeManageJPanel());
			}
		});
		item42.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(new EquipmentManagePanel());
			}
		});
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	public void changeContentPane(JPanel contentPane) {
		setContentPane(contentPane);
		revalidate();
	}

}
