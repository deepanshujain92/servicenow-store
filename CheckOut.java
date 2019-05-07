import java.util.HashMap;
import java.util.Map;

import com.servicenow.pojo.Offers;
import com.servicenow.pojo.Product;

public class CheckOut {
	public static void main(String[] args) {
		CheckOut c = new CheckOut();
		c.scan("TSHIRT").scan("TSHIRT").scan("MUG").scan("TSHIRT").scan("TSHIRT");
		System.out.println(c.total());
	}

	private Map<Product, Integer> cart = new HashMap<>();
	private Map<String, Product> products = new HashMap<String, Product>();
	private Map<String, Offers> rules = new HashMap<>();
	private double total;

	public CheckOut() {
		loadProducts();
		loadRules();
	}

	public void calculate() {
		total = 0;
		for (Product product : cart.keySet()) {
			final String code = product.getCode();
			Offers offer = rules.get(code);
			if (offer == null) {
				total += product.getPrice() * cart.get(product);
			} else if (offer.equals(Offers.BUY2GET1)) {
				if (product.getCode() == "VOUCHER") {
				total += cart.get(product) * product.getPrice();
				int discountedItem = cart.get(product) / 3;
				total -= discountedItem * product.getPrice();
				}else
					total += cart.get(product) * product.getPrice();
				
			} else if (offer.equals(Offers.BUY3DISCOUNT)) {
				if (product.getCode() == "TSHIRT"&&cart.get(product)>=3) {
						total += cart.get(product) * 19.00;
				} else
					total += cart.get(product) * product.getPrice();

			}
		}
	}

	public void loadProducts() {
		products.put("VOUCHER", new Product("VOUCHER", "SNOW Voucher", 7.00));
		products.put("TSHIRT", new Product("TSHIRT", "SNOW Tshirt", 21.00));
		products.put("MUG", new Product("MUG", "SNOW Mug", 9.50));
	}

	public void loadRules() {
		rules.put("VOUCHER", Offers.BUY2GET1);
		rules.put("TSHIRT", Offers.BUY3DISCOUNT);
	}

	public CheckOut scan(String item) {
		Product product = products.get(item);
		if (cart.get(product) == null) {
			cart.put(product, 1);
		} else {
			cart.put(product, cart.get(product) + 1);
		}
		calculate();
		return this;
	}

	double total() {
		return total;
	}
}
