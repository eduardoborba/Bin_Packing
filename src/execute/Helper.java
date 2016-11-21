package execute;

import model.Bin;
import model.Package;

public class Helper {
	public static void printBin(Bin bin) {
		System.out.println("==============================");
		System.out.println("Total size: " + bin.getTotalSize());
		for(Package p: bin.getItems())
		{
			System.out.println(p.getSize());
		}
	}
}
