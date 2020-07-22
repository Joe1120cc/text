package controller;

import java.util.ArrayList;

import entity.Product;
import factory.ServiceFactory;
import service.ProductService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品控制器
 */
public class ProductController extends BaseController {
	private ProductService productService;

	public ProductController(String message) {
		super(message);
		productService = (ProductService) ServiceFactory.createService(message);
	}

	public boolean addProduct(Product p) {// 添加产品
		return productService.addProduct(p);
	}

	public boolean changeProduct(Product p) {// 修改产品
		return productService.changeProduct(p);
	}

	public boolean deleteProduct(String productID) {// 删除产品
		return productService.deleteProduct(productID);
	}

	public Product getProductByID(String productID) {// 通过ID获取产品
		return productService.getProductByID(productID);
	}

	public ArrayList<Product> getContainedProduct(String data) {// 获取模糊检索结果
		return productService.getContainedProduct(data);
	}

}
