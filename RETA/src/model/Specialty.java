package model;

public class Specialty {
	
	private String name;
	private int radius;
	
	public Specialty(String val1, int val2){
		this.name = val1;
		this.radius = val2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int val2) {
		this.radius = val2;
	}
	
	
}
