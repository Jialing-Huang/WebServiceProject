package myWebServiceProject.Jialing.Entity;

public class Address {
	private int number;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public Address(){}

	public Address(int Number, String StreetAddress, String City, String State, String Country, String Zipcode) {
		this.number = Number;
		this.streetAddress = StreetAddress;
		this.city = City;
		this.state = State;
		this.country = Country;
		this.zipcode = Zipcode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
		
}
