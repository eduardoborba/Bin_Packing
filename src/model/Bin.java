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
	private double currentSize;

	public Bin() {
		this.items = new ArrayList<Package>();
		this.totalSize = 0;
	}
    
	/*Getters and Setters*/
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
	
	public double numberOfItems(){
		return this.items.size();
	}
	
	/*Usados pelo Forca Bruta*/
    public Bin deepCopy() {
        Bin copy = new Bin();
        copy.items = new ArrayList<Package>(items);
        copy.currentSize = currentSize;
        copy.maxWeight = maxWeight;
        System.out.println("CS"+currentSize+"MW:"+maxWeight);
        return copy;
    }
	
    public boolean put(Double val) {
    	Package item = new Package(val);
        if (currentSize + val <= maxWeight) {
            items.add(item);
            currentSize += val;
            return true;
        } else {
            return false; // item didn't fit
        }
    }
	
    public void remove(Double item) {
        items.remove(item);
        currentSize -= item;
    }
	
}
