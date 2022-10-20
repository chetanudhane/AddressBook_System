package addressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook implements AddressBookInterface {

	List<PersonDetails> contactList = new ArrayList<PersonDetails>();
	Scanner sc = new Scanner(System.in);

	@Override
	public void selectOption() {

		boolean condition = true;
		do {
			System.out.println("\nChoose Which Operation You Want To Perform...");
			System.out.println("1.addPersonDetails 2.editDetails 3.showDetails 4.Exit");
			int operation = sc.nextInt();

			switch (operation) {
			case 1:
				addPersonDetails();
				break;
			case 2:
				editDetails();
				break;
			case 3:
				showDetails();
				break;
			case 4:
				condition = false;
				System.out.println("Exit...");
				break;
			default:
				System.out.println("Enter Valid Operation Type...");
				selectOption();
				break;
			}
		} while (condition);

	}

	@Override
	public void addPersonDetails() {
		PersonDetails personDetails = new PersonDetails();
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

		contactList.add(personDetails);
	}

	@Override
	public void showDetails() {
		Iterator<PersonDetails> iterator = contactList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Override
	public void editDetails() {

		if (contactList.size() > 0) {
			String newFirstName;
			System.out.println("Enter First name of contact to edit it ");
			newFirstName = sc.next();

			for (int i = 0; i < contactList.size(); i++) {
				if (contactList.get(i).getFirstName().equals(newFirstName)) {
					System.out.println("\nSelect which one you want to update : ");
					System.out.println("1.First Name 2.Last Name 3.city 4.State 5.Zip 6.Phone 7.Email 8.Exit");
					int op = sc.nextInt();

					switch (op) {
					case 1:
						System.out.println("Enter new first name");
						contactList.get(i).setFirstName(sc.next());
						break;
					case 2:
						System.out.println("Enter new last name");
						contactList.get(i).setLastName(sc.next());
						break;
					case 3:
						System.out.println("Enter new city");
						contactList.get(i).setCity(sc.next());
						break;
					case 4:
						System.out.println("Enter new state");
						contactList.get(i).setState(sc.next());
						break;
					case 5:
						System.out.println("Enter new zip");
						contactList.get(i).setZipCode(sc.nextInt());
						break;
					case 6:
						System.out.println("Enter new phone number");
						contactList.get(i).setMobileNumber(sc.nextLong());
						break;
					case 7:
						System.out.println("Enter new email");
						contactList.get(i).setEmailId(sc.next());
						break;
					case 8:
						System.out.println("Exit From Edit Mode...");
						break;
					default:
						System.out.println("Invalid Entry");
						editDetails();
						break;
					}
					System.out.println("Contact Edited Successfully");
				} else
					System.out.println("Contact doesn't exist");
			}
		} else
			System.out.println("ContactList Empty...");
	}
}
