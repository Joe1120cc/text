package entity;

public class ProductType {
	private String productType;

	public ProductType(String productType) {
		super();
		this.productType = productType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	} 
	
	public String toString() {
		return productType;
	}

}
