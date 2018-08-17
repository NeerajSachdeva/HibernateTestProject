package my.test.project.dto.test2;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumbers2 {

	@Column(length = 10)
	private int phoneNumber;

	public PhoneNumbers2() {
		// Mandatory to define default constructor when parameterized exists.
	}

	public PhoneNumbers2(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
