package application;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ex_vocab {

	String filePath;

	public ex_vocab(String fp){
		this.filePath = fp;
	}

	public void startEx(){
		String n = "";
		csv_reader vocab;

		Scanner reader = new Scanner(System.in);
		try{
			vocab = new csv_reader(filePath);
			int num;
			Random rdmz = new Random();
			for (int k=0;k<10;k++){
				num = rdmz.nextInt(25);
				System.out.print(vocab.vocFetcher(num,0));

				reader = new Scanner(System.in);
				reader.useDelimiter("");
				System.out.println("\nEnter the following letter:\n");
				n = reader.nextLine();

				if (n.equals(vocab.vocFetcher(num, 1))){
					System.out.print("Correct !\n\n");
				}
				else {
					System.out.print("Wrooong ! The answer was :\n");
					System.out.print(vocab.vocFetcher(num, 1));
					System.out.print("\n\n");
				}

			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
}
