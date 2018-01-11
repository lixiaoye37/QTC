package model;

public class Claimant
{
	private String State;
	private String ZipCode;
	private String Date;
	private String SpecialtyGroup;
	private int NumOfAppointment;
	
	public Claimant(){}
	
	public Claimant(String state, String zipCode, String date, String specialtyGroup, int numOfAppointment) {
		State = state;
		ZipCode = zipCode;
		Date = date;
		SpecialtyGroup = specialtyGroup;
		NumOfAppointment = numOfAppointment;
	}

	public String toString()
	{
		return State + "\t" + ZipCode + "\t" + Date + "\t" + SpecialtyGroup + "\t" + NumOfAppointment;
	}

	public void setState(String state) {
		State = state;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public void setDate(String date) {
		Date = date;
	}

	public void setSpecialtyGroup(String specialtyGroup) {
		SpecialtyGroup = specialtyGroup;
	}

	public void setNumOfAppointment(int numOfAppointment) {
		NumOfAppointment = numOfAppointment;
	}

	public String getState() {
		return State;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public String getDate() {
		return Date;
	}

	public String getSpecialtyGroup() {
		return SpecialtyGroup;
	}

	public int getNumOfAppointment() {
		return NumOfAppointment;
	}
	
	
}