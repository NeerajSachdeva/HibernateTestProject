package my.test.project.dto.test1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "TESTDBTABLE")
public class TestDB {

	@Id
	private int id;

	@Column(name = "DESCRIPTION", length = 30)
	private String description;

	@Column(name = "CREATE_DATE")
	private Date createdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	// @PrePersist
	// public void onPrePersist() {
	// System.out.println("ye lo onPrePersist chal gaya");
	// }

}
