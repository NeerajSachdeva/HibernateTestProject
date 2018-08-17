package my.test.project.dto.test3;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Parents {

	@Id
	@GeneratedValue
	private int parentId;

	private String name;

	@ManyToMany(mappedBy = "parents")
	private Collection<UserDetailsThree> users = new ArrayList<>();

	public Parents() {
		// TODO Auto-generated constructor stub
	}

	public Parents(String name) {
		this.name = name;
	}

	public Collection<UserDetailsThree> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetailsThree> users) {
		this.users = users;
	}

}
