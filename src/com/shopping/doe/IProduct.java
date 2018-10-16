package com.shopping.doe;

import java.util.List;

/**
 * @author patel
 *
 */
public interface IProduct {

	/**
	 * @param product
	 */
	public abstract void setProduct(final Product product);

	/**
	 * @param productId
	 * @return product
	 */
	public abstract Product getProduct(final int productId);

	/**
	 * @return all products
	 */
	public abstract List<Product> getProducts();
}
