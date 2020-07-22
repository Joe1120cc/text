package controller;

import java.util.ArrayList;

import entity.ProductType;
import factory.ServiceFactory;
import service.ProductTypeService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品类型控制器
 */
public class ProductTypeController extends BaseController {
	private ProductTypeService productTypeService;

	public ProductTypeController(String message) {
		super(message);
		productTypeService = (ProductTypeService) ServiceFactory.createService(message);
	}

	public boolean addProductType(ProductType pt) {// 添加产品类型
		return productTypeService.addProductType(pt);
	}

	public ArrayList<String> getContainedProductType(String data) {// 获取模糊检索结果
		return productTypeService.getContainedProductType(data);
	}

	public boolean changeProductType(String productType, String newProductType) {// 修改产品类型
		return productTypeService.changeProductType(productType, newProductType);
	}

	public boolean deleteProductType(String productType) {// 删除产品类型
		return productTypeService.deleteProductType(productType);
	}

}
