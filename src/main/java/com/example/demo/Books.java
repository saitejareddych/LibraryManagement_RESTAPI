package com.example.demo;
import javax.persistence.*;
@Entity
@Table(name ="Books")
public class Books {
	@Id
	int Book_ID;
	String Book_Name;
	int Count;
	public int getBook_ID() {
		return Book_ID;
	}
	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
}
