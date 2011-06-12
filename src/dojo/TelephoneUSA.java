package dojo;

public class TelephoneUSA implements ITelephone {
	private String number;

	public TelephoneUSA(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "(1)" + number;
	}
}
