package controller;

import java.util.ArrayList;

import entity.Product;
import factory.ServiceFactory;
import service.ProductService;

public class ProductController extends BaseController {
	private ProductService productService;

	public ProductController(String message) {
		super(message);
		productService = (ProductService) ServiceFactory.createService(message);
	}

	public boolean addProduct(Product p) {
		return productService.addProduct(p);
	}

	public boolean changeProduct(Product p) {
		return productService.changeProduct(p);
	}

	public boolean deleteProduct(String productID) {
		return productService.deleteProduct(productID);
	}
	
	public Product getProductByID(String productID) {
		return productService.getProductByID(productID);
	}
	
	public ArrayList<Product> getContainedProduct(String data){
		return productService.getContainedProduct(data);
	}

}
