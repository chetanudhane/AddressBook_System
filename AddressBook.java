package addressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook implements AddressBookInterface {

	List<PersonDetails> contactList = new ArrayList<PersonDetails>();

	@Override
	public void addPersonDetails(PersonDetails personDetails) {
		contactList.add(personDetails);
	}

	@Override
	public void showDetails() {
		Iterator<PersonDetails> iterator = contactList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
