package model;
/**
 * 
 * @author Dani & Duda
 * Package é cada unidade da entrada
 * Possui apenas o seu tamanho
 */
public class Package {
	private double size;
	
	public Package(double pSize) {
		this.size = pSize;
	}
	
	public double getSize() {
		return this.size;
	}
	
	public void setSize(double pSize) {
		this.size = pSize;
	}
	
}
