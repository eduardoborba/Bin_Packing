package model;

import java.util.ArrayList;

/**
 * 
 * @author Dani & Duda
 * 
 * Bin é um conjunto de Packages (ou itens)
 * Possui um tamanho preenchido 'totalSize' 
 * e um limite máximo 'maxWeight'
 */
public class Bin {
	private ArrayList<Package> items;
	private double totalSize;
	private double maxWeight;

	public Bin() {
		this.items = new ArrayList<Package>();
		this.totalSize = 0;
	}
		
	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public boolean addItem(Package p) {
		if (this.totalSize + p.getSize() <= getMaxWeight()) {
			this.items.add(p);
			this.totalSize += p.getSize();
			return true;
		}
		return false;
	}
	
	public Package getItem(int pos) {
		return this.items.get(pos);
	}
	
	public ArrayList<Package> getItems(){
		return this.items;
	}
	
	public double getTotalSize(){
		return this.totalSize;
	}
	
	
}
