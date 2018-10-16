package com.shopping.doe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author patel
 *
 */
public class ProductImpl implements IProduct {

	List<Product> products;

	/**
	 * 
	 */
	public ProductImpl() {
		products = new ArrayList<Product>();
		Product p1 = new Product(1230, "Samsung S9+", "Cell Phone", "Product 1 description!!!", "./images/p1.jpg",
				700.00);
		Product p2 = new Product(1240, "iPhone X", "Cell Phone", "Product 2 description!!!", "./images/p2.jpg", 999.00);
		Product p3 = new Product(1250, "Sony Xperia XZ2 Premium", "Cell Phone", "Product 3 description!!!",
				"./images/p3.jpg", 999.00);
		Product p4 = new Product(1260, "Dell XPS 15", "Laptop", "Product 4 description!!!", "./images/p4.jpg", 1550.00);
		Product p5 = new Product(1270, "Asus", "Laptop", "Product 5 description!!!", "./images/p5.jpg", 1999.00);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
	}

	@Override
	public void setProduct(Product product) {
		// TODO Auto-generated method stub
	}

	@Override
	public Product getProduct(int productId) {
		for (Product product : this.products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}
}
