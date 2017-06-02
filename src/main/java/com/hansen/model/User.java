package com.hansen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hansen.cnst.Sex;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "user")
public class User {
	
	@Id
	@ApiModelProperty(notes = "名字", required = true)
	private String name;
	
	@ApiModelProperty(notes = "性別", required = true)
	private Sex sex;
	
	@ApiModelProperty(notes = "年齡", required = true)
	private int age;

	public User(String name, Sex sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}
