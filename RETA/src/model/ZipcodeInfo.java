package model;

public class ZipcodeInfo
{
	private String zipcode;
	private String city;
	private String state;
	private String latitude;
	private String longitude;
	private String timezone;
	private String dst;
	
	public ZipcodeInfo(String zipcode, String city, String state, String latitude, String longitude,
			String timezone, String dst) 
	{
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timezone = timezone;
		this.dst = dst;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getDst() {
		return dst;
	}

	@Override
	public String toString() {
		return "ZipcodeInfo [zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", timezone=" + timezone + ", dst=" + dst + "]";
	}
}