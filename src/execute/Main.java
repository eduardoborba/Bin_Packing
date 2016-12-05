package execute;

import java.io.File;

//import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import solution.Heuristic;

public class Main {

	public static void main(String[] args) {
		Bin_Set bins;
		String fileName = "in.txt";
		File file = Helper.openFile(fileName);
		Init_Set packages = Helper.readFile(file);
		
		if(Helper.isTypeOfWheights())
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_d());
		else 
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_ald());
				
		System.out.print("Numero de itens:"+packages.getPackages().size());
		System.out.print(", Numero maximo de bins:"+packages.getNumberOfBins());
		System.out.println(", N# otimo de Bins (OPT): "+Helper.getOptimalNumberOfBins(packages));
		
		System.out.print("\nFFD:");
		Heuristic.FFD(packages, bins);
		Helper.printBin_Set(bins);
		
		System.out.print("\nFF:\n");
		file = Helper.openFile(fileName);
		packages = Helper.readFile(file);
		if(Helper.isTypeOfWheights())
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_d());
		else 
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_ald());
		
		Heuristic.FFD(packages, bins);
		Helper.printBin_Set(bins);
		
		System.out.print("\nNF:\n");
		file = Helper.openFile(fileName);
		packages = Helper.readFile(file);
		if(Helper.isTypeOfWheights())
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_d());
		else 
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_ald());
		
		Heuristic.NF(packages, bins);
		Helper.printBin_Set(bins);
	}

}
