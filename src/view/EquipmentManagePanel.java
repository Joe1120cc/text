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

public class EquipmentManagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scollPane;
	private static JTable table;
	private static Vector vName;//表头
	private static Vector vData;// 数据

	/**
	 * Create the panel.
	 */
	public EquipmentManagePanel() {
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
				
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("设备信息列表");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(444, 25, 94, 31);
		add(lblNewLabel);

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
		List<Object> data = FileUtils.getData("Equipments.txt", Equipment.class);
		vName.add("序号");
		vName.add("设备编号");
		vName.add("设备名称");
		vName.add("设备类型");
		vName.add("设备规格");
		vName.add("设备描述");
		vName.add("设备状态");
		vName.add("租用状态");
		vName.add("所属工厂");
		int  i =1;
		for(Object o : data) {
			Equipment e = (Equipment)o;
			e.setEquipmentNumber(i);
			Vector<String> vRow = new Vector<String>();
			e.setEquipmentNumber(i);
			vRow.add(e.getEquipmentNumber()+"");
			vRow.add(e.getEquipmentID());
			vRow.add(e.getEquipmentName());
			vRow.add(e.getEuipmentType().getEquipmentType());
			vRow.add(e.getEquipmentSpecification());
			vRow.add(e.getEquipmentDescription());
			vRow.add(e.getEquipmentState());
			vRow.add(e.getRentState());
			vRow.add(e.getEquipmentOwnedFactory().getName());
			vData.add(vRow.clone());
			i++;
		}
		table.setModel(new DefaultTableModel(vData, vName));
		FitTableColumns(table);
	}

}