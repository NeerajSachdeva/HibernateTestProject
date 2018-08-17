package my.test.project.dto.test6;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @DynamicUpdate
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;

	private String name;

	private String lastName;

	@ElementCollection
	private Set<Address6> addresses = new HashSet<>();

	@Embedded
	private Address6 address6 = new Address6();

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastName) {
		this.name = name;
		this.setLastName(lastName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address6 getAddress6() {
		return address6;
	}

	public void setAddress6(Address6 address6) {
		this.address6 = address6;
	}

	public Set<Address6> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address6> addresses) {
		this.addresses = addresses;
	}

}
