package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class csv_reader {

	private String filePath;
	private ArrayList<String> fileMatrice ;
	private String test;

	public csv_reader(String fp) throws FileNotFoundException{
		this.filePath = fp;
		fileMatrice = new ArrayList<String>();
		Scanner scannerF = new Scanner(new File(filePath));
		scannerF.useDelimiter("\n|,");
        while(scannerF.hasNext()){
        	test = scannerF.next();
        	fileMatrice.add(test);
        }
        scannerF.close();

	}

	public String vocFetcher(int i, int j){
		return fileMatrice.get(2*i+j);
	}

	public String fourFetcher(int i, int j){
		return fileMatrice.get(5*i+j);
	}

	public String gramChoiceFetcher(int i, int j){
		return fileMatrice.get(7*i+j);
	}
}
