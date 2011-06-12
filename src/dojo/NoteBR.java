package dojo;

public class NoteBR implements AbstractFactory{

	public ITelephone createTelephone(String number){
		return new TelephoneBR(number);	
	}
	public IAddress createAddress(String street, String city, String zip){
		return new AddressBR(street, city, zip);		
	}
}
