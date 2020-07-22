package service;

import java.util.ArrayList;

import entity.Product;

public interface ProductService extends BaseService{
	public boolean addProduct(Product p);
	
	public boolean deleteProduct(String ID);
	
	public boolean changeProduct(Product p);
	
	public Product getProductByID(String productID);
	
	public ArrayList<Product> getContainedProduct(String data);

}
