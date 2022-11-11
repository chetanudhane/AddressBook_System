package addressbooksystem;

import com.opencsv.bean.CsvBindByName;

public class PersonDetails {

	@CsvBindByName(column = "First Name")
	private String firstName;
	@CsvBindByName(column = "Last Name")
	private String lastName;
	@CsvBindByName(column = "email")
	private String email;
	@CsvBindByName(column = "phoneNumber")
	private long phoneNumber;
	@CsvBindByName(column = "city")
	private String city; 
	@CsvBindByName(column = "state")
	private String state; 
	@CsvBindByName(column = "zip")
	private long zip;

	public PersonDetails() {
		super();
	}

	public PersonDetails(String firstName, String lastName, String city, String state, int zipCode, long mobileNumber,
			String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "PersonDetails [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}

}
