package entities.concretes;

import entities.abstracts.Entity;

public class Discount implements Entity {
	private int discountRate;
	private String info;

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(int discountRate, String info) {
		super();
		this.discountRate = discountRate;
		this.info = info;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
