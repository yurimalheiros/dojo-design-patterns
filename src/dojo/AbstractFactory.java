package dojo;

public interface AbstractFactory {
	public ITelephone createTelephone(String number);
	public IAddress createAddress(String street, String city, String zip);
}
