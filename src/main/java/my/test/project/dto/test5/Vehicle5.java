package my.test.project.dto.test5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_FIVE")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle5 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;

	private String vehicleName;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
