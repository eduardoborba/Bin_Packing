package model;

import java.util.ArrayList;

public class Bin {
	private ArrayList<Package> items;
	private double totalSize;
	
	public Bin() {
		this.items = new ArrayList<Package>();
		this.totalSize = 0;
	}
	
	public void addItem(Package p) {
		this.items.add(p);
		this.totalSize += p.getSize();
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
