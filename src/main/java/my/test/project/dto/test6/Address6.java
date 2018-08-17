package my.test.project.dto.test6;

import javax.persistence.Embeddable;

@Embeddable
public class Address6 {

	private String addrName;

	public Address6() {
		// TODO Auto-generated constructor stub
	}

	public Address6(String addrName) {
		this.setAddrName(addrName);
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

}
