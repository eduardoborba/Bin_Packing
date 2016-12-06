package execute;

import java.io.File;

//import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import solution.Heuristic;

public class Main {

	public static void main(String[] args) {
		Bin_Set binsFFD, binsFF;
		String fileName = "in.txt";
		File file = Helper.openFile(fileName);
		Init_Set packagesFFD, packagesFF;
		
		
		packagesFFD = Helper.readFile(file);
		binsFFD = Helper.setBinsByType(packagesFFD);

		System.out.println("Numero de itens:"+packagesFFD.getPackages().size());
		System.out.println("Numero maximo de bins:"+packagesFFD.getNumberOfBins());
		System.out.println("N# otimo de Bins (OPT): "+Helper.getOptimalNumberOfBins(packagesFFD)+
				", Sum:"+packagesFFD.getSomaTotal());
		
		System.out.print("\nFFD:");
		Heuristic.FFD(packagesFFD, binsFFD);
		Helper.printBin_Set(binsFFD);
		
		/*
		System.out.print("\nFF:\n");
		file = Helper.openFile(fileName);
		packagesFF = Helper.readFile(file);
		binsFF = Helper.setBinsByType(packagesFF);;
		
		Heuristic.FF(packagesFF, binsFF);
		Helper.printBin_Set(binsFF);
*/
	}

}
