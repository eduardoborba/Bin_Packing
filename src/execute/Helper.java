package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import model.Init_Set;
import model.Bin;
import model.Bin_Set;
import model.Package;

public class Helper {
	private static double weight_d;
	private static ArrayList<Double> weight_ald; 
	private static boolean typeOfWheights;

	public static Bin_Set setBinsByType(Init_Set packages){
		Bin_Set bins;
		if(Helper.isTypeOfWheights())
			bins = new Bin_Set(packages.getNumberOfBins(), packages.getWeight_d());
		else 
			bins = new Bin_Set(packages.getNumberOfBins(),packages.getWeight_ald());
		return bins;
	}
	
	public static void printBin(Bin bin) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		System.out.println("\n==============================");
		System.out.println("Total size: " + df.format(bin.getTotalSize()));
		System.out.print("[");
		for(Package p: bin.getItems())
		{
			System.out.print(p.getSize()+", ");
		}
		System.out.println("]");
	}
	
	public static void printInit_Set(Init_Set init) {
		System.out.println("==============================");
		System.out.println("Number of bins: " + init.getNumberOfBins());
		for(Package p: init.getPackages())
		{
			System.out.println(p.getSize());
		}
	}
	
	public static void printBin_Set(Bin_Set bins) {
		int count = 0;
		for(Bin b: bins.getBins()) {
			if(b.getTotalSize() > 0.000) {
				Helper.printBin(b);
				count++;
			}
		}
		System.out.println("Number of Bins: " + count);
	}
	
	public static File openFile(String fl) {
		File file = new File(fl);
		return file;
	}
	
	public static Init_Set readFile(File file) {
		Init_Set init = new Init_Set();
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null, typeS = null, weightS = null, numberOf = null;
		    
		    typeS = reader.readLine();
		    weightS = reader.readLine();
		    numberOf = reader.readLine();
		    
		    boolean t = typeOfBins(typeS, weightS);
		    setTypeOfWheights(t);
		    init.setNumberOfBins(Integer.parseInt(numberOf));
		    Double val, soma = 0.0;
		    while ((text = reader.readLine()) != null) {
		    	val = Double.parseDouble(text);
		    	soma += val;
		    	Package item = new Package(val);
		        init.addItem(item);
		    }
		    init.setSomaTotal(soma);
		    
		    
		    if (t) 
		    	init.setWeight_d(getWeight_d());
		    else 
		    	init.setWeight_ald(getWeight_ald());
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    	
		    }
		}
		return init;
	}
	
	public static boolean typeOfBins(String key, String weight){
		if (key.equalsIgnoreCase("homo")){
			setWeight_d(Double.parseDouble(weight));
			return true;
		} else if (key.equalsIgnoreCase("hetero")){
			ArrayList<Double> w = new ArrayList<Double>();
			String[] strs = weight.split("; *(?![^\\[\\]]*\\])");
			for (int i = 0; i < strs.length; i++) {
				//System.out.print(" val:"+strs[i]);
				w.add(Double.parseDouble(strs[i]));
			}
			setWeight_ald(w);
		}
		return false;
	}

	public static long getOptimalNumberOfBins(Init_Set is){
		return Math.round(is.getSomaTotal()/is.getWeight_d());
	}

	public static double getWeight_d() {
		return weight_d;
	}

	public static void setWeight_d(double weight) {
		Helper.weight_d = weight;
	}

	public static ArrayList<Double> getWeight_ald() {
		return weight_ald;
	}

	public static void setWeight_ald(ArrayList<Double> weight) {
		Helper.weight_ald = weight;
	}

	public static boolean isTypeOfWheights() {
		return typeOfWheights;
	}

	public static void setTypeOfWheights(boolean _typeOfWheights) {
		Helper.typeOfWheights = _typeOfWheights;
	}
}
