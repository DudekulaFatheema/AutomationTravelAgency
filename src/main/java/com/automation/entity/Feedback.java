package com.automation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	private int fId;
	private int cId;
	private int dId;
	private int rating;
	private String comments;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(int fId, int cId, int dId, int rating, String comments) {
		super();
		this.fId = fId;
		this.cId = cId;
		this.dId = dId;
		this.rating = rating;
		this.comments = comments;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "Feedback [fId=" + fId + ", cId=" + cId + ", dId=" + dId + ", rating=" + rating + ", comments="
				+ comments + "]";
	}
	
	

}
