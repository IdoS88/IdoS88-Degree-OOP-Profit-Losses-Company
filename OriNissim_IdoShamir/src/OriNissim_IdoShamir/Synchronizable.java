package OriNissim_IdoShamir;

public interface Synchronizable {

	void synchronizeStartingHour();
	
	public boolean isSynchronizable();
	
	public boolean setSynchronizable(boolean b);
	
	public void setStartingHour(int startingHour);
	
	public int getStartingHour();

}
