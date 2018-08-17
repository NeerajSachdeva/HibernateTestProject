package my.test.project.dto.test3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_THREE")
public class Address3 {

	@Id
	@GeneratedValue
	private int addressID;

	private String street;
	private String city;
	private String state;
	private String pincode;

	public Address3() {
		// mandatory when we are declaring parameterised constructor
	}

	public Address3(String street, String city, String state, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
