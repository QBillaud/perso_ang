package application;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ex_gram_choice {

	String filePath;

	public ex_gram_choice(String fp){
		this.filePath = fp;
	}

	public void startEx(){
		int nn;
		csv_reader vocab;

		Scanner reader = new Scanner(System.in);
		try{
			vocab = new csv_reader(filePath);
			int num;
			Random rdmz = new Random();
			for (int k=0;k<10;k++){
				num = rdmz.nextInt(25);
				System.out.print(vocab.gramChoiceFetcher(num,0) + "\n");
				System.out.print(vocab.gramChoiceFetcher(num,1));
				System.out.print("Proposed answers : 1) " + vocab.gramChoiceFetcher(num,2) + " 2) " + vocab.gramChoiceFetcher(num,3) + " 3) " + vocab.gramChoiceFetcher(num,4) + " 4) " + vocab.gramChoiceFetcher(num,5));

				reader = new Scanner(System.in);
				reader.useDelimiter("");
				System.out.println("\nEnter the correct answer number\n");
				nn = reader.nextInt();

				if (vocab.gramChoiceFetcher(num,nn).equals(vocab.gramChoiceFetcher(num, 6))){
					System.out.print("Correct !\n\n");
				}
				else {
					System.out.print("Wrooong ! The answer was :\n");
					System.out.print(vocab.gramChoiceFetcher(num, 6));
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
