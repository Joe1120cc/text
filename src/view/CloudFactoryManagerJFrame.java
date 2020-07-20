package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CloudFactoryManagerJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menubar1;

	/**
	 * Create the frame.
	 */
	public CloudFactoryManagerJFrame(String userID) {
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
		
	}
	public void changeContentPane(JPanel contentPane) {
		setContentPane(contentPane);
		revalidate();
	}
}
