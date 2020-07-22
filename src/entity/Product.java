package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品类
 */
public class Product {
	private int productNumber;
	private String productID;
	private String productName;
	private ProductType productType;
	private String productSpecification;
	private String productDescription;

	public int getProductNumber() {// 获取产品序号
		return productNumber;
	}

	public void setProductNumber(int productNumber) {// 设置产品序号
		this.productNumber = productNumber;
	}

	public String getProductID() {// 获取产品ID
		return productID;
	}

	public void setProductID(String productID) {// 设置产品ID
		this.productID = productID;
	}

	public String getProductName() {// 获取产品名称
		return productName;
	}

	public void setProductName(String productName) {// 设置产品名称
		this.productName = productName;
	}

	public ProductType getProductType() {// 获取产品类别
		return productType;
	}

	public void setProductType(ProductType productType) {// 设置产品类别
		this.productType = productType;
	}

	public String getProductSpecification() {// 获取产品规格
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {// 设置产品规格
		this.productSpecification = productSpecification;
	}

	public String getProductDescription() {// 获取产品描述
		return productDescription;
	}

	public void setProductDescription(String productDescription) {// 设置产品描述
		this.productDescription = productDescription;
	}

	public Product(String productID, String productName, ProductType productType, String productSpecification,
			String productDescription) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
		this.productSpecification = productSpecification;
		this.productDescription = productDescription;
	}

}
