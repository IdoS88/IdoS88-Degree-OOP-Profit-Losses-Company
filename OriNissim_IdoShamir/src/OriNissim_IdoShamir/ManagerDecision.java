package OriNissim_IdoShamir;

import java.io.Serializable;

public class ManagerDecision implements Serializable {
	private String workType;
	private int startHour;

	public ManagerDecision() {
		this.workType = "Normal";
		this.startHour = 8;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
}
