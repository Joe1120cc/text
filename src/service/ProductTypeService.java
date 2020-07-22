package service;

import java.util.ArrayList;

import entity.ProductType;

public interface ProductTypeService extends BaseService{
	public boolean addProductType(ProductType pt);
	
	public ArrayList<String> getContainedProductType(String data);
	
	public boolean changeProductType(String productType,String newProductType);
	
	public boolean deleteProductType(String productType);

}
