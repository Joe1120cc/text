package service;

import java.util.ArrayList;

import entity.Product;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品接口
 */
public interface ProductService extends BaseService {
	public boolean addProduct(Product p);// 添加产品

	public boolean deleteProduct(String ID);// 删除产品

	public boolean changeProduct(Product p);// 修改产品

	public Product getProductByID(String productID);// 通过ID获取产品

	public ArrayList<Product> getContainedProduct(String data);// 获取模糊检索结果

}
