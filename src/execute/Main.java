package execute;

import model.Bin;
import model.Package;

public class Main {

	public static void main(String[] args) {
		Bin bin = new Bin();
		for(int i = 0; i < 10; i++)
		{
			Package p = new Package((double)i/10);
			bin.addItem(p);
		}
		for(Package p: bin.getItems())
		{
			System.out.println(p.getSize());
		}
	}

}
