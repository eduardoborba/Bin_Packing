package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Init_Set {
	private ArrayList<Package> packages;
	private int numberOfBins;
	
	public Init_Set() {
		this.packages = new ArrayList<Package>();
		this.numberOfBins = 0;
	}
	
	public void setNumberOfBins(int pnumberOfBins) {
		this.numberOfBins = pnumberOfBins;
	}
	
	public int getNumberOfBins() {
		return this.numberOfBins;
	}
	
	public void setPackages(ArrayList<Package> ppackages){
		this.packages = ppackages;
	}
	
	public ArrayList<Package> getPackages() {
		return this.packages;
	}
	
	public Package getPackage(int pos) {
		return this.packages.get(pos);
	}
	
	public void addItem(Package p) {
		this.packages.add(p);
	}
	
	public void orderPackages() {
		Collections.sort(packages, new Comparator<Package>() {
		    @Override
		    public int compare(Package p1, Package p2) {
		    	if (p1.getSize() > p2.getSize()) return 1;
		        if (p1.getSize() < p2.getSize()) return -1;
		        return 0;
		    }
		});
	}
	
}
