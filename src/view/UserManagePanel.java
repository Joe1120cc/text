package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import entity.CloudFactoryManager;
import entity.Dealer;
import utils.FileUtils;

public class UserManagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scollPane;
	private static JTable table;
	private static Vector vName;//表头
	private static Vector vData;// 数据
	/**
	 * Create the panel.
	 */
	public UserManagePanel() {
		JButton btnNewButton_2_1_1 = new JButton("返回登录界面");
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBackground(new Color(255, 255, 0));
		btnNewButton_2_1_1.setBounds(750, 60, 200, 30);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SuperAdministratorJFrame frame = SuperAdministratorJFrame.getInstance();
				frame.set();
				frame.dispose();
				LogInJFrame frame_1 = new LogInJFrame();
				frame_1.setVisible(true);
				
			}
		});
		add(btnNewButton_2_1_1);
        setLayout(null);
		
		table = new JTable();
		table.setBounds(41, 114, 900, 500);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// 设置table内容居中 //
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		scollPane = new JScrollPane();
		scollPane.setOpaque(false);
		scollPane.getViewport().setOpaque(false);
		scollPane.setViewportView(table);
		scollPane.setBounds(41,114,900,500);
		add(scollPane);
		
		initTable();
		JLabel label = new JLabel("");
		label.setBounds(20, 20, 942, 610);
		label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		add(label);
		
		JButton btnNewButton = new JButton("新建");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton.setBounds(41, 60, 80, 30);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CreateUserJFrame frame = new CreateUserJFrame();
				frame.setVisible(true);
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("用户信息列表");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(444, 25, 94, 31);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("检索");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setBounds(166, 60, 80, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SearchUserJFrame frame = new SearchUserJFrame();
				frame.setVisible(true);
				
			}
		});
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setBounds(283, 60, 80, 30);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeUserJFrame frame = new ChangeUserJFrame();
				frame.setVisible(true);
				
			}
		});
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("删除");
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(new Color(255, 0, 0));
		btnNewButton_2_1.setBounds(403, 60, 80, 30);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteUserJFrame frame = new DeleteUserJFrame();
				frame.setVisible(true);
				
			}
		});
		add(btnNewButton_2_1);

	}
	public static void FitTableColumns(JTable myTable) {// 设置table边框自适应
		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();

		Enumeration columns = myTable.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int) myTable.getTableHeader().getDefaultRenderer()
					.getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();
			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) myTable.getCellRenderer(row, col)
						.getTableCellRendererComponent(myTable, myTable.getValueAt(row, col), false, false, row, col)
						.getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column);
			column.setWidth(width + myTable.getIntercellSpacing().width);
		}
	}
	
	public static void initTable() {
		vName = new Vector<String>();
		vData = new Vector<String>();
		List<Object> mData = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dData = FileUtils.getData("Dealers.txt", Dealer.class);
		vName.add("序号");
		vName.add("登录账号");
		vName.add("姓名");
		vName.add("联系方式");
		vName.add("角色名称");
		int  i =1;
		if(!mData.isEmpty()) {
			for(Object o : mData) {
				CloudFactoryManager cfm = (CloudFactoryManager)o;
				Vector<String> vRow = new Vector<String>();
				vRow.add(i+"");
				vRow.add(cfm.getUserID());
				vRow.add(cfm.getUserName());
				vRow.add(cfm.getUserPhoneNumber());
				vRow.add("云工厂");
				vData.add(vRow.clone());
				i++;
			}
		}
		if(!dData.isEmpty()) {
			for(Object o : dData) {
				Dealer d = (Dealer)o;
				Vector<String> vRow = new Vector<String>();
				vRow.add(i+"");
				vRow.add(d.getUserID());
				vRow.add(d.getUserName());
				vRow.add(d.getUserPhoneNumber());
				vRow.add("经销商");
				vData.add(vRow.clone());
				i++;
			}
		}
			table.setModel(new DefaultTableModel(vData, vName));
			FitTableColumns(table);
	}
	public static void initTable(String userID) {
		vName = new Vector<String>();
		vData = new Vector<String>();
		List<Object> mData = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dData = FileUtils.getData("Dealers.txt", Dealer.class);
		vName.add("序号");
		vName.add("登录账号");
		vName.add("姓名");
		vName.add("联系方式");
		vName.add("角色名称");
		int  i =1;
		for(Object o : mData) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			Vector<String> vRow = new Vector<String>();
			if(cfm.getUserID().equals(userID)) {
				vRow.add(i+"");
				vRow.add(cfm.getUserID());
				vRow.add(cfm.getUserName());
				vRow.add(cfm.getUserPhoneNumber());
				vRow.add("云工厂");
				vData.add(vRow.clone());
				i++;
			}
		}
		for(Object o : dData) {
			Dealer d = (Dealer)o;
			Vector<String> vRow = new Vector<String>();
			if(d.getUserID().equals(userID)) {
				vRow.add(i+"");
				vRow.add(d.getUserID());
				vRow.add(d.getUserName());
				vRow.add(d.getUserPhoneNumber());
				vRow.add("经销商");
				vData.add(vRow.clone());
				i++;
			}
		}
			table.setModel(new DefaultTableModel(vData, vName));
			FitTableColumns(table);
	}

}
