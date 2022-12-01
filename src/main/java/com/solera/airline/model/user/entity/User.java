package com.solera.airline.model.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String name;
	private String surname;
	private String nationality;
	private int identification;
	private int age;

	public User() {
	}

	public User(int userId, String name, String surname, String nationality, int identification, int age) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.identification = identification;
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surame) {
		this.surname = surame;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surame=" + surname + ", nationality=" + nationality
				+ ", identification=" + identification + ", age=" + age + "]";
	}

}
