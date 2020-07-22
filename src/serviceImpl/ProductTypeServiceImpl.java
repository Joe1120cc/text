package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.ProductType;
import service.ProductTypeService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品类型接口实现类
 */
public class ProductTypeServiceImpl implements ProductTypeService {

	@Override
	public boolean addProductType(ProductType pt) {// 添加产品类别
		String data = GsonUtils.toJson(pt);// 将产品类别对象转成Json数据
		try {
			FileUtils.writeData(data, "ProductTypes.txt", true);// 写入文件
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	@Override
	public ArrayList<String> getContainedProductType(String data) {// 获取模糊检索结果
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);// 获取所有产品类别信息
		ArrayList<String> list = new ArrayList<String>();// 实例化产品类别的ArrayList对象
		for (Object o : pList) {// 遍历产品类别信息
			ProductType pt = (ProductType) o;
			if (pt.getProductType().contains(data)) {// 只要名称含有传进数据就添加
				list.add(pt.getProductType());
			}
		}
		return list;
	}

	@Override
	public boolean changeProductType(String productType, String newProductType) {// 修改产品类别
		int i = 1;
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);// 获取所有产品类别信息
		List<ProductType> pts = new ArrayList<ProductType>();// 实例化产品类别的ArrayList对象
		for (Object o : pList) {// 遍历产品类别信息
			ProductType pt = (ProductType) o;
			if (pt.getProductType().equals(productType)) {// 是否是需要修改的产品类别
				pt.setProductType(newProductType);
				pts.add(pt);
				continue;
			}
			pts.add(pt);
		}
		for (ProductType pt : pts) {
			String data = GsonUtils.toJson(pt);
			try {// 写入文件
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "ProductTypes.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "ProductTypes.txt", true);
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean deleteProductType(String productType) {// 删除产品类别
		int i = 1;
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);// 获取所有产品类别信息
		List<ProductType> updatedPList = new ArrayList<ProductType>();// 实例化产品类别的ArrayList对象
		for (Object o : pList) {// 遍历产品类别信息
			ProductType pt = (ProductType) o;
			if (!pt.getProductType().equals(productType)) {// 是否是要删除的产品类别。不是才添加
				updatedPList.add(pt);
			}
		}
		if (updatedPList.isEmpty()) {// 若删除后为空，清空文件，防止下面的for循环进不去
			Tool.clearInfoForFile("ProductTypes.txt");
		}
		for (ProductType pt : updatedPList) {
			String data = GsonUtils.toJson(pt);
			try {
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "ProductTypes.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "ProductTypes.txt", true);
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

}
