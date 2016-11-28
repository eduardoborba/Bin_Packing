package solution;

import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import model.Package;

public class Heuristic {
	
	public static void BFD(Init_Set packages, Bin_Set bins) {
		packages.ascOrderPackages();
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}
	/* Fist Fit Decreasing
	 * Algoritmo offline que processa na ordem do vetor inicial
	 * */
	public static void FFD(Init_Set packages, Bin_Set bins) {
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}

	
   /* public static void bruteforce(Init_Set packages, Bin_Set bins, int currentPosition) {
        if (currentPosition >= packages.getNumberOfBins()) { // reached last item, done with this iteration
            int filledBins = getFilledBinsCount();
            if (filledBins < currentBestSolution) { // is this solution better than the current best?
                currentBestSolution = filledBins; // then save it
                currentBestBins = deepCopy(bins);
            }
            return;
        }
        // iterate over bins
        Integer currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) {
                bruteforce(in, bins, currentPosition + 1);
                bin.remove(currentItem);
            } // else: item did not fit in bin, ignore
        }
    }*/
}


	
