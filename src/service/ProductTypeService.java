package service;

import java.util.ArrayList;

import entity.ProductType;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品类型接口
 */
public interface ProductTypeService extends BaseService {
	public boolean addProductType(ProductType pt);// 添加产品类型

	public ArrayList<String> getContainedProductType(String data);// 获取模糊检索结果

	public boolean changeProductType(String productType, String newProductType);// 修改产品类型

	public boolean deleteProductType(String productType);// 删除产品类型

}
