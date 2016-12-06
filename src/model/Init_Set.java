package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Init_Set {
	private ArrayList<Package> packages;
	private ArrayList<Double> weight_ald;
	private double weight_d;
	private int numberOfBins;
	private double somaTotal;
	
	public Init_Set() {
		this.packages = new ArrayList<Package>();
		this.numberOfBins = 0;
	}

	public Package getPackage(int pos) {
		return this.packages.get(pos);
	}
	
	/*Getters and Setters*/
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
	
	public double getSomaTotal(){
		return this.somaTotal;
	}
	
	public void setSomaTotal(double soma){
		this.somaTotal = soma;
	}

	public ArrayList<Double> getWeight_ald() {
		return weight_ald;
	}

	public void setWeight_ald(ArrayList<Double> weight_ald) {
		//Quando temos um vetor, configurar o maxWeight com a média do vetor
		setWeight_d(weight_ald.stream().mapToDouble(i -> i). average().orElse(0.0));
		this.weight_ald = weight_ald;
	}

	public double getWeight_d() {
		return weight_d;
	}

	public void setWeight_d(double weight_d) {
		this.weight_d = weight_d;
	}
	
	public void addItem(Package p) {
		this.packages.add(p);
	}
	
	public void ascOrderPackages() { //ascending order
		Collections.sort(packages, new Comparator<Package>() {
		    @Override
		    public int compare(Package p1, Package p2) {
		    	if (p1.getSize() > p2.getSize()) return 1;
		        if (p1.getSize() < p2.getSize()) return -1;
		        return 0;
		    }
		});
	}
	
	// decreasing order. Collections.sort(list, Collections.reverseOrder());
	public void decOrderPackages() { //ascending order
		Collections.sort(packages, new Comparator<Package>() {
		    @Override
		    public int compare(Package p1, Package p2) {
		    	if (p1.getSize() > p2.getSize()) return -1;
		        if (p1.getSize() < p2.getSize()) return 1;
		        return 0;
		    }
		});
	}
}
