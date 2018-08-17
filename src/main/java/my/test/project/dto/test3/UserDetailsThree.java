package my.test.project.dto.test3;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author neerajsachdeva
 *
 */
@Entity(name = "USER_DETAILS_THREE")
public class UserDetailsThree {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userName;

	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle3 vehicle;

	@OneToMany
	@JoinTable(name = "User3_Address3_1_to_N", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Collection<Address3> address = new ArrayList<>();

	@OneToMany(mappedBy = "userDetailsThree")
	private Collection<PhoneNumbers3> phoneNumbers = new ArrayList<>();

	@ManyToMany
	private Collection<Parents> parents = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Collection<BodyParts> bodyParts = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Vehicle3 getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle3 vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Address3> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address3> address) {
		this.address = address;
	}

	public Collection<PhoneNumbers3> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Collection<PhoneNumbers3> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Collection<Parents> getParents() {
		return parents;
	}

	public void setParents(Collection<Parents> parents) {
		this.parents = parents;
	}

	public Collection<BodyParts> getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(Collection<BodyParts> bodyParts) {
		this.bodyParts = bodyParts;
	}

}
