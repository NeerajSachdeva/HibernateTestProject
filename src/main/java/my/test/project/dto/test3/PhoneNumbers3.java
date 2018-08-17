package my.test.project.dto.test3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "PHONE_NUMBER_THREE")
public class PhoneNumbers3 {

	@Id
	@GeneratedValue
	private int phoneId;

	@Column(length = 10)
	private int phoneNumber;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "User_ID")
	private UserDetailsThree userDetailsThree;

	public PhoneNumbers3() {
		// Mandatory to define default constructor when parameterized exists.
	}

	public PhoneNumbers3(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserDetailsThree getUserDetailsThree() {
		return userDetailsThree;
	}

	public void setUserDetailsThree(UserDetailsThree userDetailsThree) {
		this.userDetailsThree = userDetailsThree;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

}
