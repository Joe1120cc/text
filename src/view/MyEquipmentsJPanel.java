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

import entity.Equipment;
import utils.FileUtils;

public class MyEquipmentsJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scollPane;
	private static JTable table;
	private static Vector vName;//表头
	private static Vector vData;// 数据
	/**
	 * Create the panel.
	 */
	public MyEquipmentsJPanel(String userID) {
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
		
		initTable(userID);
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
				CreatEquipmentJFrame frame = new CreatEquipmentJFrame(userID);
				frame.setVisible(true);
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_2_1_1 = new JButton("返回登录界面");
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBackground(new Color(255, 255, 0));
		btnNewButton_2_1_1.setBounds(750, 60, 200, 30);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CloudFactoryManagerJFrame frame = CloudFactoryManagerJFrame.getInstance(userID);
				frame.set();
				frame.dispose();
				LogInJFrame frame_1 = new LogInJFrame();
				frame_1.setVisible(true);
				
			}
		});
		add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel = new JLabel("我的设备");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(444, 25, 94, 31);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("租用设备");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setBounds(175, 60, 129, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RentEquipmentJFrame frame = new RentEquipmentJFrame(userID);
				frame.setVisible(true);
			}
		});
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("远程开机");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1_1.setBounds(358, 60, 129, 30);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeEquipmentStateJFrame frame = new ChangeEquipmentStateJFrame("远程开机",userID);
				frame.setVisible(true);
			}
		});
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("远程关机");
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("STFangsong", Font.PLAIN, 20));
		btnNewButton_1_2.setBackground(new Color(255, 0, 0));
		btnNewButton_1_2.setBounds(541, 60, 129, 30);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeEquipmentStateJFrame frame = new ChangeEquipmentStateJFrame("远程关机",userID);
				frame.setVisible(true);
			}
		});
		add(btnNewButton_1_2);

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
	
	public static void initTable(String userID) {
		vName = new Vector<String>();
		vData = new Vector<String>();
		List<Object> data = FileUtils.getData("Equipments.txt", Equipment.class);
		vName.add("序号");
		vName.add("设备编号");
		vName.add("设备名称");
		vName.add("设备类型");
		vName.add("设备规格");
		vName.add("设备描述");
		vName.add("设备状态");
		vName.add("设备来源");
		vName.add("所属工厂");
		int  i =1;
		for(Object o : data) {
			Equipment e = (Equipment)o;
			e.setEquipmentNumber(i);
			Vector<String> vRow = new Vector<String>();
			if(e.getEquipmentOwnedFactory()!=null) {
				if(e.getEquipmentOwnedFactory().getMyManagerID().equals(userID)) {
					e.setEquipmentNumber(i);
					vRow.add(e.getEquipmentNumber()+"");
					vRow.add(e.getEquipmentID());
					vRow.add(e.getEquipmentName());
					vRow.add(e.getEuipmentType().getEquipmentType());
					vRow.add(e.getEquipmentSpecification());
					vRow.add(e.getEquipmentDescription());
					vRow.add(e.getEquipmentState());
					vRow.add("自有设备");
					vRow.add(e.getEquipmentOwnedFactory().getName());
					vData.add(vRow.clone());
					i++;
				}
			}
			if(e.getRentState().equals(userID)) {
				e.setEquipmentNumber(i);
				vRow.add(e.getEquipmentNumber()+"");
				vRow.add(e.getEquipmentID());
				vRow.add(e.getEquipmentName());
				vRow.add(e.getEuipmentType().getEquipmentType());
				vRow.add(e.getEquipmentSpecification());
				vRow.add(e.getEquipmentDescription());
				vRow.add(e.getEquipmentState());
				vRow.add("租用设备");
				vRow.add("系统所有");
				vData.add(vRow.clone());
				i++;
			}
		}
		table.setModel(new DefaultTableModel(vData, vName));
		FitTableColumns(table);
	}

}
