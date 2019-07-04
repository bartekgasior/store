package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="purchase_item")
public class PurchaseItem implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id")
	private Purchase purchase;
	
	@Column(name = "number_of_items")
	private Integer number_of_items;
	
	@Column(name = "price")
	private double price;
	
	public PurchaseItem() {
		
	}
		
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Integer getNumber_of_items() {
		return number_of_items;
	}
	public void setNumber_of_items(Integer number_of_items) {
		this.number_of_items = number_of_items;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
