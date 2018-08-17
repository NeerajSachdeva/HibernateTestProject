package my.test.project.dto.test7;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class One {

	@Id
	@GeneratedValue
	private int oneId;

	@Column
	private String name;

	@OneToMany(mappedBy = "one", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Two> twoList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Two> getTwoList() {
		return twoList;
	}

}
