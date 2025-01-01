package model.dao;

import java.sql.Timestamp;

public class Expense {
	String id, title, description, image="xyz", u_id;
	int category_id;
	double amount;
	Timestamp date;
	
	public Expense() {
	
	}

	public Expense(String id, String title, String description, String image, String u_id, int category_id,
			double amount, Timestamp date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		
		if(image!=null)
		this.image = image;
	
		this.u_id = u_id;
		this.category_id = category_id;
		this.amount = amount;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
