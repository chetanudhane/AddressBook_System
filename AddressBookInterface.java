package addressbooksystem;

import java.util.List;

import addressbooksystem.AddressBook.IOService;

public interface AddressBookInterface {

	public void operation();

	public void addContact();

	public void displayContents();

	public void editPerson();

	public void deletePerson();

	public void sortAddressBook();

	public void printSortedList(List<PersonDetails> sortedContactList);

	public void writeToAddressBookFile(IOService ioService);

	public void printData(IOService fileIo);

	public long countEntries(IOService fileIo);

	public List<String> readDataFromFile(IOService fileIo);
}
