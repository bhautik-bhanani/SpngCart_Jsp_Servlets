package com.shopping.doe;

import java.io.Serializable;

/**
 * @author patel
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable {
	private int productId;
	private String productName;
	private String productType;
	private String productDesc;
	private String productImg;
	private double productPrice;

	/**
	 * @param productId
	 * @param productName
	 * @param productType
	 * @param productDesc
	 * @param productImg
	 * @param productPrice
	 */
	public Product(int productId, String productName, String productType, String productDesc, String productImg,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productDesc = productDesc;
		this.productImg = productImg;
		this.productPrice = productPrice;
	}

	/**
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return image
	 */
	public String getProductImg() {
		return productImg;
	}

	/**
	 * @param productImg
	 */
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	/**
	 * @return price
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productDesc=" + productDesc + "]";
	}

}
