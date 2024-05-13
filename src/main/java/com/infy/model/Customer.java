package com.infy.model;

public class Customer {

	private String id;  //manually
	private String name; //letters only
	private int age;   //>18
	private String phone; //number 10 digit
	private String email; //alphabet and number
	private Gender gender; //
	private Status status;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String name, int age, String phone, String email, Gender gender, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", status=" + status + "]";
	}
}
