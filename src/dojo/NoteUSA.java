package dojo;

public class NoteUSA implements AbstractFactory {
	public ITelephone createTelephone(String number){
		return new TelephoneUSA(number);	
	}
	public IAddress createAddress(String street, String city, String zip){
		return new AddressUSA(street, city, zip);		
	}
}
