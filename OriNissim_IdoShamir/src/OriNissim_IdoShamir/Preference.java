package OriNissim_IdoShamir;

import java.io.Serializable;

public class Preference implements Serializable {
	private String worktype;
	private int StartHour;
	public Preference(String worktype, int startHour) {
		this.worktype = worktype;
		this.StartHour = startHour;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public int getStartHour() {
		return StartHour;
	}
	public void setStartHour(int startHour) {
		StartHour = startHour;
	}
	
}
