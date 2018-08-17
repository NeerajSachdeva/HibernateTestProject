package my.test.project.dto.test4;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_FOUR")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // default strategy, so its optional
@DiscriminatorColumn(name = "Tarah_Tarah_ke_vaahan", discriminatorType = DiscriminatorType.STRING) // to have name other than "dtype"
@DiscriminatorValue("Koi bhi vaahan") // if you want to pass string as dType then no need to mention DiscriminatorType annotation
public class Vehicle4 {

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
