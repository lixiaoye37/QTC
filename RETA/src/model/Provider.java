package model;

public class Provider
{
	private int ID;
	private String Specialty;
	private String State;
	private String ZipCode;
	
	public Provider(){}

	public Provider(int id, String specialty, String state, String zipCode) {
		super();
		ID = id;
		Specialty = specialty;
		State = state;
		ZipCode = zipCode;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public void setState(String state) {
		State = state;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public int getID() {
		return ID;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public String getState() {
		return State;
	}

	public String getZipCode() {
		return ZipCode;
	}

	@Override
	public String toString() {
		return "Provider [ID=" + ID + ", Specialty=" + Specialty + ", State=" + State + ", ZipCode=" + ZipCode + "]";
	}
	
}