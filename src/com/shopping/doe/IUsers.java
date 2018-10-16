package com.shopping.doe;

import java.util.List;

/**
 * @author Bhautik Bhanani
 *
 */
public interface IUsers {
	/**
	 * @param username
	 * @param password
	 * @return user
	 */
	public abstract boolean checkUser(String username, String password);

	/**
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public abstract boolean addUser(String username, String password);

	/**
	 * @param username
	 * @return wishlist
	 */
	public abstract List<Product> getWishlist(String username);

	/**
	 * @param username
	 * @return cartlist
	 */
	public abstract List<Product> getCartlist(String username);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean addWishlist(String username, Product product);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean addCartlist(String username, Product product);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean removeCartlist(String username, Product product);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean removeWishlist(String username, Product product);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean moveCarttoWishLlist(String username, Product product);

	/**
	 * @param username
	 * @param product
	 * @return boolean
	 */
	public abstract boolean moveWishLlisttoCart(String username, Product product);
}
