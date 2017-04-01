//------------------------------------------------------
//Assignment 2
//Questions: Part 2
//Written by: Polina Anis'kina ID:26991092
//For Comp249 Section: S
//------------------------------------------------------
import java.util.Scanner;
import java.io.*;
public class PublicationListingProcess2 {

public static Publication[] PublicationArray;
private static Scanner kb = new Scanner(System.in);
//enum
public enum PublicationTypes { PUBLICATIONCODE, PUBLICATIONNAME, PUBLICATIONYEAR,
	                                      PUBLICATIONAUTHORNAME, PUBLICATIONCOST,PUBLICATIONNBPAGE }

public static void main(String[] args) {
  BufferedReader read=null;
  PrintWriter outputStream=null;
  ObjectOutputStream dat=null;
  try{
    //Welcome message
    System.out.println("*******************************************************");
    System.out.println("          Welcome to Polina's inc Corporation          ");
    System.out.println("*******************************************************");

    File file = new File("PublicationData_Output.txt");

    //adding rows and printing the file items
       
    outputStream = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
    insertRowsToFile(outputStream);


    read = new BufferedReader(new FileReader(file));
    System.out.println("Program now printing the file items: ");
    printFileItems(read);

    PublicationArray = new Publication[numberOfRecords(file)];
    setArray(file);

    //asking for information
    System.out.println("Write the start and the end index,");
    System.out.println("Type the code ");
    long code = kb.nextLong();
    System.out.println("Type the start index");
    int start = kb.nextInt();
    System.out.println("Type the end index");
    int end = kb.nextInt();

    if (start<0 || end<start || end>=PublicationArray.length || code<0){
      System.out.println("You entered either the code, the start index, or the end index wrong,");
      System.out.println("Program is terminating");
      System.exit(0);
    }

    //Binary search
    System.out.println("\nUsing the Binary Search:");
    binaryPublicationSearch(PublicationArray, start, end, code);
    //Sequential search
    System.out.println("Using the Sequential Search:");
    sequentialPublicationSearch(PublicationArray, start, end, code);

    dat = new ObjectOutputStream(new FileOutputStream("Publication.dat"));
    System.out.println("Program is now writing the array to a binary file named Publication.dat");
    writeToBinary(dat);

    //Goodbye message
    System.out.println("End of Program");
    System.out.println("Good bye :) ");
  }
  catch(NullPointerException e){
    System.out.println("File not found in the pathname");
    System.out.println("Exiting Program");
    System.exit(0);
  }
  catch(FileNotFoundException e){
    System.out.println("File wasn't found...program ends now!!!");
    System.exit(0);
  }
  catch(IOException e){
    System.out.println("There looks like there is an error with the file");
    System.out.println("Exiting Program");
    System.exit(0);
  }
  catch (Exception e) {
    e.printStackTrace();
  } //Closing the streams, if not already closed
  finally{
    try {
      if (read!=null)
        read.close();
      if (dat!=null)
        dat.close();
      if (kb!=null)
        kb.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

//User can insert a new record
public static void insertRowsToFile(PrintWriter out){
  boolean choice=true;
  int count=0;
  do{
    System.out.println((count>0?"Insert another row?":"Insert row?")+" (yes/no)");
    String response = kb.next();
    if (response.equalsIgnoreCase("no"))
      choice=false;
    else{
      System.out.println("Enter the publication code: ");
      out.print(kb.nextLong()+" ");
      System.out.println("Enter the publication name: ");
      out.print(kb.next()+" ");
      System.out.println("Enter the publication year: ");
      out.print(kb.nextInt()+" ");
      System.out.println("Enter the publication author name: ");
      out.print(kb.next()+" ");
      System.out.println("Enter the publication cost: ");
      out.print(kb.nextDouble()+" ");
      System.out.println("Enter the publication number of pages: ");
      out.println(kb.nextLong());
    }
    count++;
  }
  while (choice==true);
  out.close();
}


//accepts four parameters, uses binary search to search an array
public static void binaryPublicationSearch(Publication[] array, int startIndex, int endIndex, long code){
  int Ocomplex=0;
  int middle=0;
  long difference=0;
  boolean yay = false;

  while(startIndex<=endIndex && !yay){
    Ocomplex++;
    middle = (startIndex+endIndex)/2;
    difference = array[middle].getPublication_code() - code;
    if (difference<0)
      startIndex = middle + 1;
    else if (difference>0)
      endIndex = middle - 1;
    else
      yay=true;
  }

  if (yay) {
    System.out.println("Code found!");
    System.out.println(PublicationArray[indexOfCode(code)]);
  }
  else
    System.out.println("Code not found!");
  System.out.println(Ocomplex+" iterations was used in the search process.\n");
}

//Searches for the code going one index at a time sequentially until finds the code
public static void sequentialPublicationSearch(Publication[] array, int startIndex, int endIndex, long code){
  int Ocomplex=0;
  boolean yay = false;

  for(int i=startIndex; i<=endIndex; i++){
    Ocomplex++;
    if(array[i].getPublication_code() == code){
      yay = true;
      i = endIndex;
    }
  }

  if (yay){
    System.out.println("Code found!");
    System.out.println(PublicationArray[indexOfCode(code)]);
  }
  else
    System.out.println("Code not found!");
  System.out.println(Ocomplex+" iterations was used in the search process.\n");
}

//Checks how many line of records there is
private static int numberOfRecords(File in) throws FileNotFoundException{
  Scanner read = new Scanner(new FileReader(in));
  int record=0;

  while (read.hasNextLine() && read.hasNextLong()){
    record++;
    read.nextLine();
  }
  if (record<2){
    System.out.println("Sorry, the file "+ (record==0?"is empty.":"contains only 1 record.") + "\n program will terminate");
    read.close();
    System.exit(0);
  }
  read.close();
  return record;
}

//Sets the array from the file to an array of type Publication
private static void setArray(File in) throws FileNotFoundException{
  Scanner line = new Scanner(new FileReader(in));

  for(int i=0; i<PublicationArray.length; i++){
    PublicationArray[i] = new Publication(line.nextLong(),line.next(),line.nextInt(),line.next(),line.nextDouble(),line.nextInt());
  }
  line.close();
}

private static void writeToBinary(ObjectOutputStream dat) throws IOException{
  for(int i=0; i<PublicationArray.length; i++){
    dat.writeLong(PublicationArray[i].getPublication_code());
    dat.writeBytes(PublicationArray[i].getPublication_name());
    dat.writeInt(PublicationArray[i].getPublication_year());
    dat.writeBytes(PublicationArray[i].getPublication_authorname());
    dat.writeDouble(PublicationArray[i].getPublication_cost());
    dat.writeInt(PublicationArray[i].getPublication_nbpages());
  }
}
//using buffer
public static void printFileItems(BufferedReader bf) throws IOException{
  String nextLine;
  while ((nextLine=bf.readLine()) != null) {
    System.out.println(nextLine);
  }
}

//returns an index of a code
private static int indexOfCode(long code){
  int index=0;
  for (int i=0; i<PublicationArray.length; i++){
    if (PublicationArray[i].getPublication_code()==code)
      index=i;
  }
  return index;
}

}