package execute;

import java.io.File;

import model.Init_Set;

public class Main {

	public static void main(String[] args) {
		File file = Helper.openFile();
		Init_Set init = Helper.readFile(file);
		System.out.println(init.getNumberOfBins());
		Helper.printBin(init.getPackages());
	}

}
