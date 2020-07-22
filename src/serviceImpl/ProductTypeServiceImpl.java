package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.ProductType;
import service.ProductTypeService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

public class ProductTypeServiceImpl implements ProductTypeService{

	@Override
	public boolean addProductType(ProductType pt) {
		String data = GsonUtils.toJson(pt);
		try {
			FileUtils.writeData(data, "ProductTypes.txt", true);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	@Override
	public ArrayList<String> getContainedProductType(String data) {
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);
		ArrayList<String> list = new ArrayList<String>();
		 for(Object o : pList) {
			 ProductType pt = (ProductType)o;
			 if(pt.getProductType().contains(data)) {
				 list.add(pt.getProductType());
			 }
		 }
		return list;
	}

	@Override
	public boolean changeProductType(String productType,String newProductType) {
		int i=1;
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);
		List<ProductType> pts = new ArrayList<ProductType>();
		for(Object o : pList) {
			ProductType pt = (ProductType)o;
			if(pt.getProductType().equals(productType)) {
				pt.setProductType(newProductType);
				pts.add(pt);
				continue;
			}
			pts.add(pt);
		}
		for(ProductType pt : pts) {
			String data = GsonUtils.toJson(pt);
			try {
				if(i==1) {
					FileUtils.writeData(data, "ProductTypes.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "ProductTypes.txt", true);
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean deleteProductType(String productType) {
		int i=1;
		List<Object> pList = FileUtils.getData("ProductTypes.txt", ProductType.class);
		List<ProductType> updatedPList = new ArrayList<ProductType>();
		for(Object o : pList) {
			ProductType pt = (ProductType)o;
			if(!pt.getProductType().equals(productType)) {
				updatedPList.add(pt);
			}
		}
		if(updatedPList.isEmpty()) {
			Tool.clearInfoForFile("ProductTypes.txt");
		}
		for(ProductType pt : updatedPList) {
			String data = GsonUtils.toJson(pt);
			try {
				if(i==1) {
					FileUtils.writeData(data, "ProductTypes.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "ProductTypes.txt", true);
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

}
