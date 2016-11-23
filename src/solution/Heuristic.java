package solution;

import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import model.Package;

public class Heuristic {
	
	public static void PABFD(Init_Set packages, Bin_Set bins) {
		packages.orderPackages();
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}
}
