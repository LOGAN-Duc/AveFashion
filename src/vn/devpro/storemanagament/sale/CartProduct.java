package vn.devpro.storemanagament.sale;

import vn.devpro.storemanagament.update.product.Product;
import vn.devpro.storemanagament.update.product.ProductManagenment;

public class CartProduct {//hang trong gio
	private int productId;
	private double amount;
	//hien thi hang trong gio
	public void display() {
		Product product = ProductManagenment.getProductById(productId);
		System.out.printf("%-30s %,15.2f %,12.2f %,15.2f\n",
				product.getName(),product.getPrice(),this.amount,this.amount*product.getPrice());
	}
	public double tatal() {
		Product product = ProductManagenment.getProductById(productId);
		return this.amount*product.getPrice();
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartProduct(int productId, double amount) {
		super();
		this.productId = productId;
		this.amount = amount;
	}
}
