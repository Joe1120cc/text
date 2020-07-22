package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import entity.Equipment;
import service.EquipmentService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备接口实现类
 */
public class EquipmentServiceImpl implements EquipmentService {

	public boolean addEquipment(Equipment e) {// 添加设备
		try {
			String data = GsonUtils.toJson(e);// 转成Json数据
			FileUtils.writeData(data, "Equipments.txt", true);// 写入文件
			return true;
		} catch (Exception E) {
			return false;
		}

	}

	@Override
	public boolean changeEquipment(Equipment e) {// 修改设备
		int i = 1;// 计数控制
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);// 获取所有设备信息
		ArrayList<Equipment> list = new ArrayList<Equipment>();// 实例化设备的ArrayList对象
		for (Object o : eList) {// 遍历设备信息
			Equipment E = (Equipment) o;
			if (E.getEquipmentID().equals(e.getEquipmentID())) {// 若找到与需要修改的同ID的，添加修改后的进list
				list.add(e);
				continue;// 防止重复添加
			}
			list.add(E);// 添加不符合ID的
		}
		for (Equipment E : list) {// 遍历写入文件
			String data = GsonUtils.toJson(E);
			try {
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "Equipments.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "Equipments.txt", true);
				}
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean deleteEquipment(String euipmentID) {// 删除设备
		int i = 1;
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);// 获取所有设备信息
		ArrayList<Equipment> list = new ArrayList<Equipment>();// 实例化设备的ArrayList对象
		for (Object o : eList) {// 遍历设备信息
			Equipment E = (Equipment) o;
			if (!E.getEquipmentID().equals(euipmentID)) {// 和需要删除的ID不一致就添加进list
				list.add(E);
			}
		}
		if (list.isEmpty()) {// 若删除后为空，清空文件，防止下面的for循环进不去
			Tool.clearInfoForFile("Equipments.txt");
		}
		for (Equipment E : list) {// 遍历写入文件
			String data = GsonUtils.toJson(E);
			try {
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "Equipments.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "Equipments.txt", true);
				}
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<Equipment> getContainedEquipments(String data) {// 获取模糊检索结果
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);// 获取所有设备信息
		ArrayList<Equipment> list = new ArrayList<Equipment>();// 实例化设备的ArrayList对象
		for (Object o : eList) {// 遍历设备信息
			Equipment e = (Equipment) o;
			if (e.getEquipmentID().contains(data) || e.getEquipmentName().contains(data)) {// 只要ID或名字含有传进的信息就添加
				list.add(e);
			}
		}
		return list;
	}

	@Override
	public Equipment getEquipmentByID(String equipmentID) {// 通过ID获取设备
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);// 获取所有设备信息
		for (Object o : eList) {// 遍历设备信息
			Equipment e = (Equipment) o;
			if (e.getEquipmentID().equals(equipmentID)) {// 找到相同ID，返回该设备对象
				return e;
			}
		}
		return null;
	}

}
