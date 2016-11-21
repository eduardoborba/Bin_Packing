package model;

public class Init_Set {
	private Bin packages;
	private int numberOfBins;
	
	public Init_Set() {
		this.packages = null;
		this.numberOfBins = 0;
	}
	
	public void setNumberOfBins(int pnumberOfBins) {
		this.numberOfBins = pnumberOfBins;
	}
	
	public int getNumberOfBins() {
		return this.numberOfBins;
	}
	
	public void setPackages(Bin ppackages){
		this.packages = ppackages;
	}
	
	public Bin getPackages() {
		return this.packages;
	}
	
}
