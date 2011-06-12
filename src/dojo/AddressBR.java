package dojo;

public class AddressBR implements IAddress{
	private String street, city, zip;

	public AddressBR(String street, String city, String zip) {
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean validateZip() {
		if (this.zip.length() == 9) {
			if (this.zip.charAt(5) == '-') {
				String aux = zip.replace("-", "");
				try {
					Integer.parseInt(aux);
				} catch (Exception e) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
}
