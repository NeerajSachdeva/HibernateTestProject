package my.test.project.dto.test1;

public class AddressTest {

	Address address = new Address();

	public void test1() {
		address.setCity("delhi");
//		Assert.assertEquals("delhi", address.getCity());
	}

	public void test2() {
		address.setPincode("110034");
//		Assert.assertEquals("110034", address.getPincode());
	}
}
