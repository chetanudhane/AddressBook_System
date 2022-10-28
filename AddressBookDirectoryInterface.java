package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookDirectoryInterface {

	public void operationDirectory();

	public void addAddressBook();

	public void editAddressBook();

	public void displayDirectoryDetails();

	public void searchPersonByCity();

	public void searchPersonByState();

	public void displayPeopleByRegion(HashMap<String, ArrayList<PersonDetails>> listToDisplay);
}
