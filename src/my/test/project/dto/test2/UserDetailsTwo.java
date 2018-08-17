package my.test.project.dto.test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author neerajsachdeva
 *
 */
@Entity(name = "USER_DETAILS_TWO")
public class UserDetailsTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userName;

	@ElementCollection
	@JoinTable(name = "User_Address", joinColumns = @JoinColumn(referencedColumnName = "userId", name = "user_id"))
	private Set<Address2> address = new HashSet<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "User_Phone_Numbers", joinColumns = @JoinColumn(referencedColumnName = "userId", name = "user_id"))
	/* To have PK in UserPhoneNumber table write below annotation */
	@GenericGenerator(name = "my_generator", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "Phone_No_id") }, generator = "my_generator", type = @Type(type = "int"))
	private Collection<PhoneNumbers2> phoneNumbers = new ArrayList<>();

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

	public Set<Address2> getAddress() {
		return address;
	}

	public void setAddress(Set<Address2> address) {
		this.address = address;
	}

	public Collection<PhoneNumbers2> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Collection<PhoneNumbers2> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
