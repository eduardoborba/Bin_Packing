package solution;

import java.util.ArrayList;
import java.util.List;

import execute.Helper;
import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import model.Package;

public class Heuristic {
	
	/*Private for bruteForce()*/
    private static ArrayList<Bin> bins = new ArrayList<Bin>();
    private static double currentBestSolution;
    private static ArrayList<Bin> currentBestBins;
    /*END*/
    
    /* Fist Fit Decreasing */
	public static void FFD(Init_Set packages, Bin_Set bins) {
		long startTime = System.currentTimeMillis();
		packages.decOrderPackages();
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
		long stopTime = System.currentTimeMillis();
		System.out.println("Tempo: " + (stopTime - startTime));
	}
	
	/* First Fit
	 * Algoritmo FF que processa na ordem do vetor inicial
	 * */
	public static void FF(Init_Set packages, Bin_Set bins) {
		//packages.ascOrderPackages();
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}
	
    /**
     * bruteforce solution to bin packing problem.
     *
     * @param in list of items to be packed
     * @param currentPosition position in input list
     */
    public static void bruteforce(Init_Set in, int currentPosition, Bin_Set BSbins) {
        
    	if (currentPosition >= in.getPackages().size()) { // reached last item, done with this iteration
            double filledBins = getFilledBinsCount();
            if (filledBins < currentBestSolution) { // is this solution better than the current best?
                System.out.println(currentBestSolution);
            	currentBestSolution = filledBins; // then save it
                currentBestBins = deepCopy(BSbins);
            }
            return;
        }
        // iterate over bins
        double currentItem = in.getPackage(currentPosition).getSize();
        System.out.println(currentItem);
        for (Bin bin : BSbins.getBins()) {
            if (bin.put(currentItem)) {
                bruteforce(in, ++currentPosition, BSbins);
                bin.remove(currentItem);
            } // else: item did not fit in bin, ignore
        }
    }

    /**
     * returns how many bins currently have at least one item inside them.
     */
    private static double getFilledBinsCount() {
        double filledBins = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                filledBins++;
            }
        }
        return filledBins;
    }
    
    public static ArrayList<Bin> deepCopy(Bin_Set bins) {
        ArrayList<Bin> copy = new ArrayList<Bin>();
        for (int i = 0; i < bins.getBins().size(); i++) {
            copy.add(bins.getBins().get(i).deepCopy());
        }
        return copy;
    }
    
}


	
