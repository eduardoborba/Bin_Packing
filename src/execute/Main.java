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
		Heuristic.PABFD(packages, bins);
		Helper.printBin_Set(bins);
	}

}
