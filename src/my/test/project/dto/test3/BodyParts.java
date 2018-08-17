package my.test.project.dto.test3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BodyParts {

	@Id
	@GeneratedValue
	private int bodyPartId;

	private String name;

	public BodyParts() {
		// TODO Auto-generated constructor stub
	}

	public BodyParts(String name) {
		this.name = name;
	}

}
