package utils;

//From Nicholas DiPiazza: https://stackoverflow.com/questions/12463346/get-zipcodes-within-n-miles-java-client
public class RadiusBox 
{
	private double bottomLine;
	private double topLine;
	private double leftLine;
	private double rightLine;
	private double radius;

	public double getBottomLine() {
		return bottomLine;
	}

	public void setBottomLine(double bottomLine) {
		this.bottomLine = bottomLine;
	}

	public double getTopLine() {
		return topLine;
	}

	public void setTopLine(double topLine) {
		this.topLine = topLine;
	}

	public double getLeftLine() {
		return leftLine;
	}

	public void setLeftLine(double leftLine) {
		this.leftLine = leftLine;
	}

	public double getRightLine() {
		return rightLine;
	}

	public void setRightLine(double rightLine) {
		this.rightLine = rightLine;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "RadiusBox [bottomLine=" + bottomLine + ", leftLine=" + leftLine + ", radius=" + radius + ", rightLine="
				+ rightLine + ", topLine=" + topLine + "]";
	}
	
	//From Nicholas DiPiazza: https://stackoverflow.com/questions/12463346/get-zipcodes-within-n-miles-java-client
	public static RadiusBox create(Double latitude, Double longitude, Double radiusInUnit, Double EarthRadiusInUnit) 
	{
		double lat;
		double dlon;
		double dLatInRads = latitude * (Math.PI / 180.0);
		double dLongInRads = longitude * (Math.PI / 180.0);
		double dDistInRad = radiusInUnit / EarthRadiusInUnit;
		RadiusBox box = new RadiusBox();
		box.setRadius(radiusInUnit);

		box.setTopLine((dLatInRads + dDistInRad) * (180.0 / Math.PI));
		box.setBottomLine((dLatInRads - dDistInRad) * (180.0 / Math.PI));

		lat = Math.asin(Math.sin(dLatInRads) * Math.cos(dDistInRad));
		
		dlon = Math.atan2(Math.sin(Math.PI / 2.0) * Math.sin(dDistInRad) * Math.cos(dLatInRads),
				Math.cos(dDistInRad) - Math.sin(dLatInRads) * Math.sin(lat));
		box.setRightLine((((dLongInRads + dlon + Math.PI) % (2.0 * Math.PI)) - Math.PI) * (180.0 / Math.PI));

		dlon = Math.atan2(Math.sin(3.0 * Math.PI / 2.0) * Math.sin(dDistInRad) * Math.cos(dLatInRads),
				Math.cos(dDistInRad) - Math.sin(dLatInRads) * Math.sin(lat));
		box.setLeftLine((((dLongInRads + dlon + Math.PI) % (2.0 * Math.PI)) - Math.PI) * (180.0 / Math.PI));

		return box;
	}
}
