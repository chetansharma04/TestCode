package com.chetan.hibernate.hibernateOneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	private int id;
	private PersonName name;
	private String color;
	
	@OneToMany(mappedBy = "student") //"student" is the variable name in class "Laptop" = @ManyToOne	private Student student;
	private List<Laptop> laptopList;
	
	public List<Laptop> getLaptopList() {
		return laptopList;
	}
	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public PersonName getName() {
		return name;
	}
	public void setName(PersonName name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", color=" + color + ", laptopList=" + laptopList + "]";
	}
	
	
}
