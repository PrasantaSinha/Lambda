package com.trial.lambda;

import com.trial.lambda.Person;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class RoboContactLambda {
	public void phoneContacts(List<Person> pl, Predicate<Person> pred) {
		Iterator<Person> arg3 = pl.iterator();

		while (arg3.hasNext()) {
			Person p = (Person) arg3.next();
			if (pred.test(p)) {
				this.roboCall(p);
			}
		}

	}

	public void emailContacts(List<Person> pl, Predicate<Person> pred) {
		Iterator<Person> arg3 = pl.iterator();

		while (arg3.hasNext()) {
			Person p = (Person) arg3.next();
			if (pred.test(p)) {
				this.roboEmail(p);
			}
		}

	}

	public void mailContacts(List<Person> pl, Predicate<Person> pred) {
		Iterator<Person> arg3 = pl.iterator();

		while (arg3.hasNext()) {
			Person p = (Person) arg3.next();
			if (pred.test(p)) {
				this.roboMail(p);
			}
		}

	}

	public void roboCall(Person p) {
		System.out.println(
				"Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
	}

	public void roboEmail(Person p) {
		System.out.println(
				"EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
	}

	public void roboMail(Person p) {
		System.out.println(
				"Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
	}
}