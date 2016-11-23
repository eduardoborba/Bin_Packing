package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Init_Set;
import model.Bin;
import model.Bin_Set;
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
			if(b.getTotalSize() > 0.0) {
				Helper.printBin(b);
				count++;
			}
		}
		System.out.println("Number of Bins: " + count);
	}
	
	public static File openFile() {
		File file = new File("in.txt");
		return file;
	}
	
	public static Init_Set readFile(File file) {
		Init_Set init = new Init_Set();
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    text = reader.readLine();
		    init.setNumberOfBins(Integer.parseInt(text));
		    
		    while ((text = reader.readLine()) != null) {
		    	Package item = new Package(Double.parseDouble(text));
		        init.addItem(item);
		    }
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
}
