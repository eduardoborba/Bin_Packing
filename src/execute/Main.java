package execute;

import java.io.File;

import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import solution.Heuristic;

public class Main {

	public static void main(String[] args) {
		File file = Helper.openFile();
		Init_Set packages = Helper.readFile(file);
		Bin_Set bins = new Bin_Set(packages.getNumberOfBins());
		
		System.out.print("\nNumero de itens:"+packages.getPackages().size());
		System.out.print("\nNumero de itens:"+packages.getSize());
		
		System.out.print("\nFFD:");
		Heuristic.BFD(packages, bins);
		Helper.printBin_Set(bins);
		
		System.out.print("\nFFD:\n");
		file = Helper.openFile();
		packages = Helper.readFile(file);
		bins = new Bin_Set(packages.getNumberOfBins());
		
		Heuristic.FFD(packages, bins);
		Helper.printBin_Set(bins);
	}

}
