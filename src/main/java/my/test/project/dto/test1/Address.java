package my.test.project.dto.test1;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	// if we don't specify column name, it takes member variable name as column
	// name, string will make it varchar(255)
	private String street;
	private String city;
	private String state;
	private String pincode;

	public Address() {
		// mandatory when we are declaring parameterised constructor
	}

	public Address(String street, String city, String state, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
