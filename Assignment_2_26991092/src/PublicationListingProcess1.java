//------------------------------------------------------
//Assignment 2
//Questions: Part 1
//Written by: Polina Anis'kina ID:26991092
//For Comp249 Section: S
//------------------------------------------------------

import java.util.Scanner;
import java.io.*;
public class PublicationListingProcess1 {
	private static Publication[] PublicationArray;
	public  enum PublicationTypes {PUBLICATIONCODE, PUBLICATIONNAME, PUBLICATIONYEAR, PUBLICATIONAUTHORNAME, PUBLICATIONCOST, PUBLICATIONNBPAGES};

	public static void mainputStream (String[] args){
		System.out.println("********************************************************************");
		System.out.println("                Welcome to Polina’s inc Corporation                 ");
		System.out.println("********************************************************************");
		Scanner kb=new Scanner(System.in);

		Scanner inputStream = null;
		String out = null;
		PrintWriter outputStream = null;
		boolean yay = false;
		
File file ;
		// prompt the user to enter the name of the outputStreamput file, and then to see if the file exists,
		//then the program rejects shows the name and the size, until we get a new file
		try{
			inputStream = new Scanner(new FileReader("PublicationData_inputStreamput.txt"));

			do{
				System.out.println("Please enter the name of your outputStreamput file: ");
				out = kb.next();

				file = new File(out);

				if(file.exists()){
					System.out.println("A file named " + out + " already exists, size: " + out.length() + " bytes");
					yay = false;
				}
				else{
					outputStream = new PrintWriter(out);
					yay = true;
				}

			}while(!yay);

			correctListOfItems(inputStream, outputStream);
			prinputStreamtFileItems(inputStream);
		}

		catch(FileNotFoundException e){
			System.out.println("Sorry the file doesn't exist... this program ends now!!!");
			System.exit(0);
		}

		finally{
			inputStream.close();
			outputStream.close();
			kb.close();
		}
	}

	// to check if the copy of the code exists
	private static void correctListOfItems(Scanner inputStreamput, PrintWriter outputStream){
		

		Scanner size = null;
		int line = 0;

		try{

			size = new Scanner(new FileReader("PublicationData_inputStreamput.txt"));

			while(size.hasNextLine() && size.hasNextLong()){
				line++;
				size.nextLine();
			}

			if(line <= 1){
				System.out.println("This file is empty...the program is endinputStreamg now!");
				System.exit(0);
			}
			else{
				PublicationArray = new Publication[line];
			}
		}
		catch(FileNotFoundException e){ //if the file is not found exception
			System.out.println("File not found.. the program is endinputStreamg now!");
			System.exit(0);
		}
		finally{
			size.close();	
		}
		long code= 0;
		boolean good = false;
		Scanner kb = new Scanner(System.in);
		for(int i = 0; i<PublicationArray.length; i++){

			PublicationArray[i] = new Publication(inputStreamput.nextLong(), inputStreamput.next(),
					inputStreamput.nextInt(), inputStreamput.next(), inputStreamput.nextDouble(), inputStreamput.nextInt());
		}

		for(int i = 0; i<PublicationArray.length; i++){
			Publication temp = PublicationArray[i];

			for(int j = i+1; j<PublicationArray.length; j++){
				try{
					if (temp.equals(PublicationArray[j])){
						throw new CopyCodeException();
					}

				}
//catch copy code exception to see if there are copies of the code
				catch (CopyCodeException e){
					System.out.println(e);

					do{
						System.out.println(PublicationArray[j].getPublication_code() + " was copied in the file");
						System.out.println("Enter a new code " + PublicationArray[j]);
						good = true;
						code = kb.nextLong();
						for ( i = j-1; i >= 0; i--){
							if(code == PublicationArray[i].getPublication_code()){
								good = false;
							}
						}
					}
					while(!good);
					PublicationArray[j].setPublication_code(code);
				}
			}
		}
		for (int i = 0; i<PublicationArray.length; i++){
			outputStream.println(PublicationArray[i]);
		}
		kb.close();
	}
	
//method that displays the inputStreamformation of both the PublicationData_inputStreamput.txt file as well as the created output file.
	private static void prinputStreamtFileItems(Scanner inputStreamput){

		for (int i = 0; i<PublicationArray.length; i++){
			System.out.println(PublicationArray[i]);
		}
	}

}
