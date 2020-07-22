package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import entity.EquipmentType;
import service.EquipmentTypeService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备类型接口实现类
 */
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

	public boolean addEquipmentType(EquipmentType et) {// 添加设备类型
		try {
			String data = GsonUtils.toJson(et);// 将设备类型对象转成Json数据
			FileUtils.writeData(data, "EquipmentTypes.txt", true);// 写入文件
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean changeEquipmentType(String equipmentType, String newEquipmentType) {// 修改设备类型
		int i = 1;
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);// 获取所有设备类型信息
		ArrayList<EquipmentType> ets = new ArrayList<EquipmentType>();// 实例化设备类型的ArrayList对象
		for (Object o : etList) {// 遍历设备类型信息
			EquipmentType et = (EquipmentType) o;
			if (et.getEquipmentType().equals(equipmentType)) {// 是否是需要修改的设备类型
				et.setEquipmentType(newEquipmentType);// 修改
			}
			ets.add(et);
		}
		try {// 写入文件
			for (EquipmentType et : ets) {
				String data = GsonUtils.toJson(et);
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "EquipmentTypes.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "EquipmentTypes.txt", true);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteEquipmentType(String equipmentType) {// 删除设备类型
		int i = 1;
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);// 获取所有设备类型信息
		ArrayList<EquipmentType> ets = new ArrayList<EquipmentType>();// 实例化设备类型的ArrayList对象
		for (Object o : etList) {// 遍历设备类型信息
			EquipmentType et = (EquipmentType) o;
			if (!et.getEquipmentType().equals(equipmentType)) {// 是否是要删除的设备类型。不是才添加
				ets.add(et);
			}
		}
		if (ets.isEmpty()) {// 若删除后为空，清空文件，防止下面的for循环进不去
			Tool.clearInfoForFile("EquipmentTypes.txt");
		}
		try {
			for (EquipmentType et : ets) {
				String data = GsonUtils.toJson(et);
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "EquipmentTypes.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "EquipmentTypes.txt", true);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<String> getContainedEquipmentType(String data) {// 获取模糊检索结果
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);// 获取所有设备类型信息
		ArrayList<String> ets = new ArrayList<String>();// 实例化设备类型的ArrayList对象
		for (Object o : etList) {// 遍历设备类型信息
			EquipmentType et = (EquipmentType) o;
			if (et.getEquipmentType().contains(data)) {// 只要名称含有传进数据就添加
				ets.add(et.getEquipmentType());
			}
		}
		return ets;
	}

}
