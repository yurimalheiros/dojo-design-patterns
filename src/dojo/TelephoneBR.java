package dojo;

public class TelephoneBR implements ITelephone {
	private String number;

	public TelephoneBR(String number) {
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
		return "(55)" + number;
	}
}
