package com.trial.lambda;

import com.trial.lambda.Gender;
import com.trial.lambda.Person;
import com.trial.lambda.RoboContactLambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExample {
	public static List<Person> createShortList() {
		ArrayList<Person> people = new ArrayList<Person>();
		people.add((new Person.Builder()).givenName("Bob").surName("Baker").age(21).gender(Gender.MALE)
				.email("bob.baker@example.com").phoneNumber("201-121-4678").address("44 4th St, Smallville, KS 12333")
				.build());
		people.add((new Person.Builder()).givenName("Jane").surName("Doe").age(25).gender(Gender.FEMALE)
				.email("jane.doe@example.com").phoneNumber("202-123-4678").address("33 3rd St, Smallville, KS 12333")
				.build());
		people.add((new Person.Builder()).givenName("John").surName("Doe").age(25).gender(Gender.MALE)
				.email("john.doe@example.com").phoneNumber("202-123-4678").address("33 3rd St, Smallville, KS 12333")
				.build());
		return people;
	}

	public static void main(String[] args) {
		List<Person> people = createShortList();
		RoboContactLambda robo = new RoboContactLambda();
		Predicate<Person> allDrivers = (p) -> {
			return p.getAge() >= 16;
		};
		Predicate<Person> allDraftees = (p) -> {
			return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		};
		Predicate<Person> allPilots = (p) -> {
			return p.getAge() >= 23 && p.getAge() <= 65;
		};
		System.out.println("\n==== Test 04 ====");
		System.out.println("\n=== Calling all Drivers ===");
		robo.phoneContacts(people, allDrivers);
		System.out.println("\n=== Emailing all Draftees ===");
		robo.emailContacts(people, allDraftees);
		System.out.println("\n=== Mail all Pilots ===");
		robo.mailContacts(people, allPilots);
		System.out.println("\n=== Mail all Draftees who are Pilots ===");
		robo.mailContacts(people, allDraftees.and(allPilots));
		Consumer<Person> printPersonName = (p) -> {
			System.out.println(p.getGivenName() + " " + p.getSurName());
		};
		System.out.println("\n=== Print all non Pilots using consumer ===");
		people.stream().filter(allPilots.negate()).forEach(printPersonName);
		Function<Person, String> personName = (p) -> {
			return p.getGivenName() + " " + p.getSurName();
		};
		Consumer<String> print = (s) -> {
			System.out.println(s);
		};
		System.out.println("\n=== Print all non Pilots using Function and Consumer ===");
		people.stream().filter(allPilots.negate()).map(personName).forEach(print);
		System.out.println("\n=== Mail all non Pilots ===");
		robo.mailContacts(people, allPilots.negate());
		System.out.println("\n=== Mail all Draftees ===");
		robo.mailContacts(people, allDraftees);
		System.out.println("\n=== Call all Pilots ===");
		robo.phoneContacts(people, allPilots);
	}
}