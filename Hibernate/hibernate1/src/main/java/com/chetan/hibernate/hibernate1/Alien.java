package com.chetan.hibernate.hibernate1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name ="Student" )
public class Alien {
	
	@Id
	private String id;
	private String name;
	private String color;

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
	
	
}
