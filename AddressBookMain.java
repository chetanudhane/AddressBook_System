package addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PersonDetails personDetails = new PersonDetails();
		AddressBook addressBook = new AddressBook();

		System.out.println("Enter First Name");
		personDetails.setFirstName(sc.next());

		System.out.println("Enter Last Name");
		personDetails.setLastName(sc.next());

		System.out.println("Enter City Name");
		personDetails.setCity(sc.next());

		System.out.println("Enter State Name");
		personDetails.setState(sc.next());

		System.out.println("Enter Zip-Code");
		personDetails.setZipCode(sc.nextInt());

		System.out.println("Enter Email Id");
		personDetails.setEmailId(sc.next());

		System.out.println("Enter Mobile Number");
		personDetails.setMobileNumber(sc.nextInt());

		addressBook.addPersonDetails(personDetails);
		addressBook.showDetails();
		sc.close();
	}

}
