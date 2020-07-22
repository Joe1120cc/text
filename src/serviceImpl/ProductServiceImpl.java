package serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.ProductType;
import service.ProductService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

public class ProductServiceImpl implements ProductService{

	@Override
	public boolean addProduct(Product p) {
		try {
			String data = GsonUtils.toJson(p);
			FileUtils.writeData(data, "Products.txt", true);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProduct(String ID) {
		int i=1;
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		ArrayList<Product> ps = new ArrayList<Product>();
		for(Object o : pList) {
			Product p = (Product)o;
			if(!p.getProductID().equals(ID)) {
				ps.add(p);
			}
		}
		if(ps.isEmpty()) {
			Tool.clearInfoForFile("Products.txt");
		}
		for(Product p : ps) {
			String data = GsonUtils.toJson(p);
				try {
					if(i==1) {
						FileUtils.writeData(data, "Products.txt", false);
						i++;
					}else {
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
	public boolean changeProduct(Product p) {
		int i=1;
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		ArrayList<Product> ps = new ArrayList<Product>();
		for(Object o : pList) {
			Product P = (Product)o;
			if(P.getProductID().equals(p.getProductID())) {
				ps.add(p);
				continue;
			}
			ps.add(P);
		}
		for(Product P : ps) {
			String data = GsonUtils.toJson(P);
			try {
				if(i==1) {
					FileUtils.writeData(data, "Products.txt", false);
					i++;
				}else {
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
	public Product getProductByID(String productID) {
		// TODO Auto-generated method stub
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		for(Object o : pList) {
			Product P = (Product)o;
			if(P.getProductID().equals(productID)) {
				return P;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> getContainedProduct(String data) {
		List<Object> pList = FileUtils.getData("Products.txt", Product.class);
		ArrayList<Product> ps = new ArrayList<Product>();
		for(Object o : pList) {
			Product p = (Product)o;
			if(p.getProductID().contains(data)||p.getProductName().contains(data)) {
				ps.add(p);
			}
		}
		return ps;
	}

}
