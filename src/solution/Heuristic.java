package solution;

import java.util.ArrayList;
import java.util.List;

import model.Bin;
import model.Bin_Set;
import model.Init_Set;
import model.Package;

public class Heuristic {
	
	/*Private for bruteForce() only*/
    private ArrayList<Bin> bins = new ArrayList<Bin>();
    private double currentBestSolution;
    private List<Bin> currentBestBins;
    /*END*/
    
    /* Fist Fit Decreasing */
	public static void FFD(Init_Set packages, Bin_Set bins) {
		packages.ascOrderPackages();
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}
	
	/* First Fit
	 * Algoritmo FF que processa na ordem do vetor inicial
	 * */
	public static void FF(Init_Set packages, Bin_Set bins) {
		for(Package p: packages.getPackages()) {
			for(Bin b: bins.getBins())
			{
				if(b.addItem(p))
					break;
			}
		}
	}

	/* Implementacao que apenas distribui o conjunto de itens nos bins*/
	/*Dessa forma a complexidade é O(n) | 1 < n < 2*OPT */
	public static void NF(Init_Set packages, Bin_Set bins) {
		int i = 0;
		Package p = packages.getPackage(i);
		for(Bin b: bins.getBins())
		{
			if(b.addItem(p))
				break;
			else 
				p = packages.getPackage(++i);
			if (i == packages.getPackages().size())
				return;
		}
	}
	
    /**
     * bruteforce solution to bin packing problem.
     *
     * @param in list of items to be packed
     * @param currentPosition position in input list
     */
    private void bruteforce(List<Double> in, int currentPosition) {
        if (currentPosition >= in.size()) { // reached last item, done with this iteration
            double filledBins = getFilledBinsCount();
            if (filledBins < currentBestSolution) { // is this solution better than the current best?
                currentBestSolution = filledBins; // then save it
                currentBestBins = deepCopy(bins);
            }
            return;
        }
        // iterate over bins
        double currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) {
                bruteforce(in, currentPosition + 1);
                bin.remove(currentItem);
            } // else: item did not fit in bin, ignore
        }
    }

    /**
     * returns how many bins currently have at least one item inside them.
     */
    private double getFilledBinsCount() {
        double filledBins = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                filledBins++;
            }
        }
        return filledBins;
    }
    
    public List<Bin> deepCopy(List<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<Bin>();
        for (int i = 0; i < bins.size(); i++) {
            copy.add(bins.get(i).deepCopy());
        }
        return copy;
    }
    
}


	
