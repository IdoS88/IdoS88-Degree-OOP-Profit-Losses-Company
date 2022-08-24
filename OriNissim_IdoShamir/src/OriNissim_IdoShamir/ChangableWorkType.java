package OriNissim_IdoShamir;

public interface ChangableWorkType {
	public void changeWorkType(String type,int startingHour);
	public void setChangeable(boolean choice);
	public boolean isChangeable();
	public void changeStartingHour(int startingHour);
}
