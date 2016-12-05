package model;

import java.util.ArrayList;

/**
 * @author Dani & Duda
 * Bin_Set é um conjunto de bins
 */

public class Bin_Set {
	private ArrayList<Bin> bins;
	private int numberOfBins;
	
	/*
	 * Bins homogeneos, ie, todos com o mesmo peso
	 */
	public Bin_Set(int numberOfBins, double maxWeight) {
		bins = new ArrayList<Bin>();
		setNumberOfBins(numberOfBins);
		for(int i = 0; i < numberOfBins; i++) {
			Bin b = new Bin();
			b.setMaxWeight(maxWeight); 
			bins.add(b);
		}
	}
	
	/*
	 * Bins heterogeneos, ie, com pesos diferentes  
	 */
	public Bin_Set(int numberOfBins, ArrayList<Double> maxWeight) {
		bins = new ArrayList<Bin>();
		setNumberOfBins(numberOfBins);
		for(int i = 0; i < numberOfBins; i++) {
			Bin b = new Bin();
			b.setMaxWeight(maxWeight.get(i)); 
			bins.add(b);
		}
	}
	
	public ArrayList<Bin> getBins() {
		return this.bins;
	}
	
	public Bin getNextBin(int pos) {
		return getBins().get(pos);
	}

	public int getNumberOfBins() {
		return numberOfBins;
	}

	public void setNumberOfBins(int numberOfBins) {
		this.numberOfBins = numberOfBins;
	}
}
