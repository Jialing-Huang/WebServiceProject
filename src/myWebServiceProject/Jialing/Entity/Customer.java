package myWebServiceProject.Jialing.Entity;

public class Customer {
	private String name;
	private String family;
	private String birthdate;
	private String email;
	private String phone;
	
	private Gender gender;
	public enum Gender{
		F,M
	}
	
	private Address address;
	private Payment payment;

	public Customer() {}

	public Customer(String Name, String Family, String Birthdate, String Email, String Phone, Gender gender, Payment payment ,Address address) {
		this.name = Name;
		this.family = Family;
		this.birthdate = Birthdate;
		this.email = Email;
		this.phone = Phone;
		this.gender = gender;
		this.address = address;
		this.payment = payment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
}
