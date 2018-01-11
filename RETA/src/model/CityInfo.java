package model;

public class CityInfo {
	private String VARO;
	private String State;
	private boolean IsQtcAssignedSlot;

	public CityInfo(String varo, String state, boolean isQtcAssignedSlot) {
		super();
		VARO = varo;
		State = state;
		IsQtcAssignedSlot = isQtcAssignedSlot;
	}

	public void setIsQtcAssignedSlot(boolean isQtcAssignedSlot) {
		IsQtcAssignedSlot = isQtcAssignedSlot;
	}

	public String getVARO() {
		return VARO;
	}

	public String getState() {
		return State;
	}

	public boolean isIsQtcAssignedSlot() {
		return IsQtcAssignedSlot;
	}
}