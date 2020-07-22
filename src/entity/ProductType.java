package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 产品类型类
 */
public class ProductType {
	private String productType;

	public ProductType(String productType) {
		super();
		this.productType = productType;
	}

	public String getProductType() {// 获取产品类型名
		return productType;
	}

	public void setProductType(String productType) {// 设置产品类型名
		this.productType = productType;
	}

	public String toString() {// 重载toString方法，以便于在下拉框中显示类型名
		return productType;
	}

}
