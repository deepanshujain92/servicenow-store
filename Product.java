package com.servicenow.pojo;

public class Product {
private final String code;
private final String name;
private final double price; 

/**
 * @param code
 * @param name
 * @param price
 */
public Product(String code,String name,double price) {
this.name = name;
this.code = code;
this.price = price;
}

/**
 * @return equals
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	return true;
}

/**
 * @return code
 */
public String getCode() {
	return code;
}

public String getName() {
	return name;
}
public double getPrice() {
	return price;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	return result;
}

}
