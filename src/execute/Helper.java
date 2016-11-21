package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Init_Set;
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
	
	
	public static File openFile() {
		File file = new File("in.txt");
		return file;
	}
	
	public static Init_Set readFile(File file) {
		int numberOfBins = 0;
		Bin packages = new Bin();
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    text = reader.readLine();
		    numberOfBins = Integer.parseInt(text);
		    
		    while ((text = reader.readLine()) != null) {
		    	Package item = new Package(Double.parseDouble(text));
		        packages.addItem(item);
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
		
		Init_Set all = new Init_Set();
		all.setPackages(packages);
		all.setNumberOfBins(numberOfBins);
		return all;
	}
}
