package my.test.project.dto.test7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Two {

	@Id
	@GeneratedValue
	private int twoId;

	@Column
	private String name;

	@ManyToOne
	private One one;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public One getOne() {
		return one;
	}

	public void setOne(One one) {
		this.one = one;
	}

}
