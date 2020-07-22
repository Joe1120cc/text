package controller;

import java.util.ArrayList;

import entity.ProductType;
import factory.ServiceFactory;
import service.ProductTypeService;

public class ProductTypeController extends BaseController{
	private ProductTypeService productTypeService;

	public ProductTypeController(String message) {
		super(message);
		productTypeService = (ProductTypeService) ServiceFactory.createService(message);
	}
	public boolean addProductType(ProductType pt) {
		return productTypeService.addProductType(pt);
	}
	
	public ArrayList<String> getContainedProductType(String data){
		return productTypeService.getContainedProductType(data);
	}
	
	public boolean changeProductType(String productType,String newProductType) {
		return productTypeService.changeProductType(productType, newProductType);
	}
	
	public boolean deleteProductType(String productType) {
		return productTypeService.deleteProductType(productType);
	}

}
