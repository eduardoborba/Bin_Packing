package model;

import java.util.ArrayList;

public class Bin_Set {
	private ArrayList<Bin> bins;
	
	public Bin_Set(int numberOfBins) {
		bins = new ArrayList<Bin>();
		for(int i = 0; i < numberOfBins; i++) {
			Bin b = new Bin();
			bins.add(b);
		}
	}
	
	
	public ArrayList<Bin> getBins() {
		return this.bins;
	}
}
