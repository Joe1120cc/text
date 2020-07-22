package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import entity.Equipment;
import utils.FileUtils;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RentEquipmentJFrame extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JScrollPane scollPane;
	private static JTable table;
	private static Vector vName;//表头
	private static Vector vData;// 数据
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	
	public RentEquipmentJFrame(String userID) {
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
        getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(41, 114, 900, 500);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// 设置table内容居中 //
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		initTable();
		
		scollPane = new JScrollPane();
		scollPane.setOpaque(false);
		scollPane.getViewport().setOpaque(false);
		scollPane.setViewportView(table);
		scollPane.setBounds(41,114,900,500);
		contentPane.add(scollPane);
		
		lblNewLabel = new JLabel(" 输入需要租用的设备ID：");
		lblNewLabel.setBounds(65, 36, 161, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(223, 40, 191, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("租用");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(463, 36, 108, 32);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = textField.getText();
				if(Tool.isEquipmentIDExisted(ID)) {
					if(Tool.rentEquipment(ID, userID)) {
						JOptionPane.showMessageDialog(null, "租用成功！");
						MyEquipmentsJPanel.initTable(userID);
					}else {
						JOptionPane.showMessageDialog(null, "租用失败！");
					}
				}else {
					JOptionPane.showMessageDialog(null, "无此ID设备！");
					textField.setText("");
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton);
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
		vName.add("设备来源");
		vName.add("所属工厂");
		int  i =1;
		for(Object o : data) {
			Equipment e = (Equipment)o;
			e.setEquipmentNumber(i);
			Vector<String> vRow = new Vector<String>();
			if(e.getEquipmentOwnedFactory()==null) {
				if(e.getRentState().equals("未被租用")) {
					vRow.add(i+"");
					vRow.add(e.getEquipmentID());
					vRow.add(e.getEquipmentName());
					vRow.add(e.getEuipmentType().getEquipmentType());
					vRow.add(e.getEquipmentSpecification());
					vRow.add(e.getEquipmentDescription());
					vRow.add(e.getEquipmentState());
					vRow.add("系统设备");
					vRow.add("系统所有");
					i++;
					vData.add(vRow.clone());
				}
			}
		}
		table.setModel(new DefaultTableModel(vData, vName));
		FitTableColumns(table);
	}

}
