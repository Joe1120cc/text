package entity;

public class Product {
	private int productNumber;
	private String productID;
	private String productName;
	private ProductType productType;
	private String productSpecification;
	private String productDescription;
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Product(String productID, String productName, ProductType productType,
			String productSpecification, String productDescription) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
		this.productSpecification = productSpecification;
		this.productDescription = productDescription;
	}

}
