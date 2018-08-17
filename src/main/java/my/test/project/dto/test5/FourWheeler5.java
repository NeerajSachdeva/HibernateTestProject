package my.test.project.dto.test5;

import javax.persistence.Entity;

@Entity
public class FourWheeler5 extends Vehicle5 {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
