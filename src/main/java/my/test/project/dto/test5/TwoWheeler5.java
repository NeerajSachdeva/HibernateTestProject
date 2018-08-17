package my.test.project.dto.test5;

import javax.persistence.Entity;

@Entity
public class TwoWheeler5 extends Vehicle5 {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
