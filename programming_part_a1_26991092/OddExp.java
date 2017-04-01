import java.io.*;

//*************************************************************
//Student: Polina Anis'kina
// ID: 26991092
//Class: COMP-352-F
//QUESTION 4
//PART1: EXPONENTIAL ODDONACCI SEQUENCE
//SEPTEMBER 30, 2016
//*************************************************************
public class OddExp {//method that calculates the exponential oddonacci
	public static long OddonacciExp(long n) {
		if (n<=3)
			return 1;
		else 
			return OddonacciExp(n-1)+OddonacciExp(n-2)+OddonacciExp(n-3);
	}//adding recursive calls


	public static void main(String args[]) {//main
		for (long i = 0; i <= 100; i+=5) {
			long sTime, runT;
			String result;
			sTime=System.currentTimeMillis();//start time
			result = "Oddonacci " + i + ": " + OddonacciExp(i);
			runT=System.currentTimeMillis()-sTime;//calculating the time it takes to execute
			result = result.concat("  And it takes "+runT+" milliseconds");
			System.out.println(result);//printing result
			print(result);//printing result in a text file
		}
	}

	public static void print(String result){//printing result in a text file method
		File file = new File("Exponential.txt");
		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(file, true));
			out.println(result);
			out.close();
		} catch (IOException e) {//catching exception
			e.printStackTrace();
		}

	}
}
