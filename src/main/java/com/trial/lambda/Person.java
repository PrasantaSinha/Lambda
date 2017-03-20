package com.trial.lambda;

import com.trial.lambda.Gender;

public class Person {
	private String givenName;
	private String surName;
	private int age;
	private Gender gender;
	private String eMail;
	private String phone;
	private String address;

	public String getGivenName() {
		return this.givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return this.getGivenName() + " " + this.getSurName();
	}

	public static class Builder {
		private String givenName;
		private String surName;
		private int age;
		private Gender gender;
		private String eMail;
		private String phone;
		private String address;

		public Person.Builder givenName(String givenName) {
			this.givenName = givenName;
			return this;
		}

		public Person.Builder surName(String surName) {
			this.surName = surName;
			return this;
		}

		public Person.Builder age(int age) {
			this.age = age;
			return this;
		}

		public Person.Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Person.Builder email(String email) {
			this.eMail = email;
			return this;
		}

		public Person.Builder phoneNumber(String phone) {
			this.phone = phone;
			return this;
		}

		public Person.Builder address(String address) {
			this.address = address;
			return this;
		}

		public Person build() {
			Person p = new Person();
			p.setGivenName(this.givenName);
			p.setSurName(this.surName);
			p.setAge(this.age);
			p.setGender(this.gender);
			p.setEmail(this.eMail);
			p.setPhone(this.phone);
			p.setAddress(this.address);
			return p;
		}
	}
}