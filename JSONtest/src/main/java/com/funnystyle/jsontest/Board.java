package com.funnystyle.jsontest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Board {
	int id;
	
	@NotNull
	@Size(min = 1, message = "입력하세요.")
	String title;

	@NotNull
	@Size(min = 1, message = "입력하세요.")
	String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBoard(String name, String title) {
		setName(name);
		setTitle(title);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
