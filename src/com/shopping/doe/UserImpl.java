package com.shopping.doe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author patel
 *
 */
public class UserImpl implements IUsers {
	List<User> users;
	Map<String, List<Product>> wishList;
	Map<String, List<Product>> cartList;

	/**
	 * 
	 */
	public UserImpl() {
		users = new ArrayList<User>();
		users.add(new User("bhautik", "12345"));
		wishList = new HashMap<String, List<Product>>();
		cartList = new HashMap<String, List<Product>>();
	}

	@Override
	public boolean checkUser(String username, String password) {
		for (User user : this.users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addUser(String username, String password) {
		if (username.trim() != null && password.trim() != null) {
			if (!checkUser(username, password)) {
				users.add(new User(username, password));
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Product> getWishlist(String username) {
		return this.wishList.get(username);
	}

	@Override
	public List<Product> getCartlist(String username) {
		return this.cartList.get(username);
	}

	@Override
	public boolean addWishlist(String username, Product product) {
		if (!checkProductInWishlist(username, product)) {
			if (wishList.containsKey(username)) {
				return wishList.get(username).add(product);
			} else {
				List<Product> list = new ArrayList<Product>();
				list.add(product);
				wishList.put(username, list);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addCartlist(String username, Product product) {
		if (!checkProductInCartlist(username, product)) {
			if (cartList.containsKey(username)) {
				return cartList.get(username).add(product);
			} else {
				List<Product> list = new ArrayList<Product>();
				list.add(product);
				cartList.put(username, list);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean moveCarttoWishLlist(String username, Product product) {
		if (checkProductInCartlist(username, product)) {
			if (wishList.containsKey(username)) {
				wishList.get(username).add(product);
				cartList.get(username).remove(product);
			} else {
				List<Product> list = new ArrayList<Product>();
				list.add(product);
				wishList.put(username, list);
				cartList.get(username).remove(product);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean moveWishLlisttoCart(String username, Product product) {
		if (checkProductInWishlist(username, product)) {
			if (cartList.containsKey(username)) {
				cartList.get(username).add(product);
				wishList.get(username).remove(product);
			} else {
				List<Product> list = new ArrayList<Product>();
				list.add(product);
				cartList.put(username, list);
				wishList.get(username).remove(product);
			}
			return true;
		}
		return false;
	}

	private boolean checkProductInWishlist(String username, Product product) {
		if (wishList.containsKey(username)) {
			for (Product products : wishList.get(username)) {
				if (products.getProductId() == product.getProductId()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkProductInCartlist(String username, Product product) {
		if (cartList.containsKey(username)) {
			for (Product products : cartList.get(username)) {
				if (products.getProductId() == product.getProductId()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean removeCartlist(String username, Product product) {
		if (checkProductInCartlist(username, product)) {
			return cartList.get(username).remove(product);
		}
		return false;
	}

	@Override
	public boolean removeWishlist(String username, Product product) {
		if (checkProductInWishlist(username, product)) {
			return wishList.get(username).remove(product);
		}
		return false;
	}
}
