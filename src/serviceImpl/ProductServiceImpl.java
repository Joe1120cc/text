package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import service.ProductService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品接口实现类
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public boolean addProduct(Product p) {// 添加产品
		try {
			String data = GsonUtils.toJson(p);// 转成Json数据
			FileUtils.writeData(data, "Products.txt", true);// 写入文件
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProduct(String ID) {// 删除设备
		int i = 1;
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);// 获取所有产品信息
		ArrayList<Product> ps = new ArrayList<Product>();// 实例化产品的ArrayList对象
		for (Object o : pList) {// 遍历产品信息
			Product p = (Product) o;
			if (!p.getProductID().equals(ID)) {// 和需要删除的ID不一致就添加进list
				ps.add(p);
			}
		}
		if (ps.isEmpty()) {// 若删除后为空，清空文件，防止下面的for循环进不去
			Tool.clearInfoForFile("Products.txt");
		}
		for (Product p : ps) {// 遍历写入文件
			String data = GsonUtils.toJson(p);
			try {// 控制文件写入方式追加or覆盖
				if (i == 1) {
					FileUtils.writeData(data, "Products.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "Products.txt", true);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean changeProduct(Product p) {// 修改产品
		int i = 1;
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);// 获取所有产品信息
		ArrayList<Product> ps = new ArrayList<Product>();// 实例化产品的ArrayList对象
		for (Object o : pList) {// 遍历产品信息
			Product P = (Product) o;
			if (P.getProductID().equals(p.getProductID())) {// 若找到与需要修改的同ID的，添加修改后的进list
				ps.add(p);
				continue;// 防止重复添加
			}
			ps.add(P);// 添加不符合ID的
		}
		for (Product P : ps) {// 遍历写入文件
			String data = GsonUtils.toJson(P);
			try {
				if (i == 1) {// 控制文件写入方式追加or覆盖
					FileUtils.writeData(data, "Products.txt", false);
					i++;
				} else {
					FileUtils.writeData(data, "Products.txt", true);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return true;
	}

	@Override
	public Product getProductByID(String productID) {// 通过ID获得产品对象
		// TODO Auto-generated method stub
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		for (Object o : pList) {// 获取所有产品信息
			Product P = (Product) o;
			if (P.getProductID().equals(productID)) {// 找到相同ID，返回该产品对象
				return P;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> getContainedProduct(String data) {// 获取模糊检索结果
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);// 获取所有产品信息
		ArrayList<Product> ps = new ArrayList<Product>();// 实例化产品的ArrayList对象
		for (Object o : pList) {// 遍历产品信息
			Product p = (Product) o;
			if (p.getProductID().contains(data) || p.getProductName().contains(data)) {// 只要ID或名称含有传进数据就添加进List
				ps.add(p);
			}
		}
		return ps;
	}

}
