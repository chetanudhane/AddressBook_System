package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements AddressBookInterface {

	public static final int ADDRESS_BOOK_EXIT = 6;
	Map<String, PersonDetails> contactList = new HashMap<String, PersonDetails>();
	public static String addressBookName;
	public static HashMap<String, ArrayList<PersonDetails>> personByCity;
	public static HashMap<String, ArrayList<PersonDetails>> personByState;
	boolean conditionForDuplicateCheck = false;

	public static String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		AddressBook.addressBookName = addressBookName;
	}

	public ArrayList<PersonDetails> getContact() {
		return new ArrayList<PersonDetails>(contactList.values());
	}

	@Override
	public void displayContents() {
		System.out.println("----- Contents of the Address Book " + AddressBook.getAddressBookName() + " -----");
		for (String eachContact : contactList.keySet()) {
			PersonDetails person = contactList.get(eachContact);
			System.out.println(person);
		}
		System.out.println("-----------------------------------------");
	}

	@Override
	public void operation() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("\nSelect any option which you want to perform on selected AddressBook\n");
			System.out.println("1. Add To Address Book\n2. Edit Existing Entry\n3. Display Address book\n"
					+ "4. Delete Contact\n5. Sort the Address Book\n" + ADDRESS_BOOK_EXIT + ". Exit");
			switch (scanner.nextInt()) {
			case 1:
				addContact();
				break;
			case 2:
				editPerson();
				break;
			case 3:
				displayContents();
				break;
			case 4:
				deletePerson();
				break;
			case 5:
				sortAddressBook();
				break;
			case ADDRESS_BOOK_EXIT:
				condition = false;
				System.out.println("Terminated and redirected to main menu...");
				break;
			default:
				System.out.println("Kindly enter a valid input...");
				operation();
				break;
			}

		} while (condition);
	}

	@Override
	public void addContact() {

		PersonDetails contactPerson = new PersonDetails();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();
		contactPerson.setFirstName(firstName);

		contactList.entrySet().stream().forEach(p -> {
			if (p.getKey().equals(firstName)) {
				System.out.println("Contact Already Exists");
				conditionForDuplicateCheck = true;
				return;
			}
		});
		contactPerson.setFirstName(firstName);
		if (conditionForDuplicateCheck == false) {

			System.out.println("Enter Last Name : ");
			contactPerson.setLastName(scanner.next());

			System.out.println("Enter ph.no : ");
			contactPerson.setMobileNumber(scanner.nextLong());

			System.out.println("Enter City : ");
			contactPerson.setCity(scanner.next());

			System.out.println("Enter State : ");
			contactPerson.setState(scanner.next());

			System.out.println("Enter Zipcode : ");
			contactPerson.setZipCode(scanner.nextInt());

			System.out.println("Enter EmailID : ");
			contactPerson.setEmailId(scanner.next());

			contactList.put(contactPerson.getFirstName(), contactPerson);
		}
	}

	@Override
	public void editPerson() {
		PersonDetails person = new PersonDetails();

		System.out.println("Enter the first name on which you would like to make changes : ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String fname = scanner.next();
		if (contactList.containsKey(fname)) {
			person = contactList.get(fname);
			System.out.println("\nSelect which one you want to update : ");
			System.out.println(
					"1. Firstname\n2. Last Name\n3. Phone Number\n4. Email\n5. City\n6. State\n7. ZipCode\n8. Back");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the correct First Name :");
				person.setFirstName(scanner.next());
				System.out.println("Updated!");
				break;
			case 2:
				System.out.println("Enter the correct Last Name :");
				person.setLastName(scanner.next());
				System.out.println("Updated!");

				break;
			case 3:
				System.out.println("Enter the correct Phone Number :");
				person.setMobileNumber(scanner.nextLong());
				System.out.println("Updated!");
				break;
			case 4:
				System.out.println("Enter the correct Email Address :");
				person.setEmailId(scanner.next());
				System.out.println("Updated!");
				break;
			case 5:
				System.out.println("Enter the correct City :");
				person.setCity(scanner.next());
				System.out.println("Updated!");
				break;
			case 6:
				System.out.println("Enter the correct State :");
				person.setState(scanner.next());
				System.out.println("Updated!");
				break;
			case 7:
				System.out.println("Enter the correct ZipCode :");
				person.setZipCode(scanner.nextInt());
				System.out.println("Updated!");
				break;
			case 8:
				System.out.println("Edit Section got terminated");
				operation();
			default:
				System.out.println("Kindly enter a valid input");
				break;
			}

		} else {
			System.out.println("Contact not found...");
		}
	}

	@Override
	public void deletePerson() {
		System.out.println("Enter the first name of the person to be deleted");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();

		if (contactList.containsKey(firstName)) {
			contactList.remove(firstName);
			System.out.println("Done, contact removed!");
		} else {
			System.out.println("Contact not found...");
		}
	}

	public void printSortedList(List<PersonDetails> sortedContactList) {
		System.out.println("*** Sorted Address Book " + AddressBook.getAddressBookName() + "***");
		Iterator<PersonDetails> iterator = sortedContactList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println();
		}
		System.out.println("-----------------------------------------");
	}

	@Override
	public void sortAddressBook() {
		List<PersonDetails> sortedContactList;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bookw to be sorted in : ");
		System.out.println("1. FirstName\n2. City\n3. State\n4. Zip Code");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			sortedContactList = contactList.values().stream().sorted(
					(firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
					.collect(Collectors.toList());
			printSortedList(sortedContactList);
			break;
		case 2:
			sortedContactList = contactList.values().stream()
					.sorted((firstperson, secondperson) -> firstperson.getCity().compareTo(secondperson.getCity()))
					.collect(Collectors.toList());
			printSortedList(sortedContactList);
			break;
		case 3:
			sortedContactList = contactList.values().stream()
					.sorted((firstperson, secondperson) -> firstperson.getState().compareTo(secondperson.getState()))
					.collect(Collectors.toList());
			printSortedList(sortedContactList);
			break;
		case 4:
			sortedContactList = contactList.values().stream()
					.sorted((firstperson, secondperson) -> Long.valueOf(firstperson.getZipCode())
							.compareTo(Long.valueOf(secondperson.getZipCode())))
					.collect(Collectors.toList());
			printSortedList(sortedContactList);
			break;
		default:
			System.out.println("Kindly enter a valid input...");
			break;
		}
	}
}
