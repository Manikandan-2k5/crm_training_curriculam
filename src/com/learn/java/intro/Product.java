package com.learn.java.intro;

public class Product {
	
	public String productName = null;
	public double productPrice = 0.0;
	public String productBrand = null;
	public String productOrigin = null;
	public long productStock = 0;
	
	public static void main(String[] args) {
		Product product = new Product();
		product.setProductName("Trimmer");
		product.setProductPrice(1500);
		product.setProductBrand("Phillips");
		product.setProductOrigin("Japan");
		product.setProductStock(50);
		Product.Display display = product.new Display();
		display.displayProductDetails();
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductBrand() {
		return productBrand;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	public String getProductOrigin() {
		return productOrigin;
	}
	
	public void setProductOrigin(String productOrigin) {
		this.productOrigin = productOrigin;
	}
	
	public long getProductStock() {
		return productStock;
	}
	
	public void setProductStock(long productStock) {
		this.productStock = productStock;
	}
	
	class Display{
		public void displayProductDetails() {
			System.out.println("Product Name: "+productName);
			System.out.println("Product Price: "+productPrice);
			System.out.println("Product Brand: "+productBrand);
			System.out.println("Product Origin: "+productOrigin);
			System.out.println("Product Stock: "+productStock);
		}
	}
}
