//*************************************************************
//Student: Polina Anis'kina
// ID: 26991092
//Class: COMP-352-F
//QUESTION 4
//PART2: LINEAR ODDONACCI SEQUENCE
//DATE: SEPTEMBER 30, 2016
//*************************************************************
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
public class Odd {
	public static long OddonacciLinear(long n, long a, long b, long c, long i){
		if(n<=3)
			return 1;
		else if (i==n-2)
			return c;
		else
			return OddonacciLinear(n,b,c,a+b+c,i+1);//recursive call
	}//method that calculates oddonacci sequence
	public static void main(String args[]){
		
		for (long i = 0; i <= 100; i+=5){
			long sTime, runT;
			String result;
			sTime=System.currentTimeMillis();//calculate starting time
			result = "Oddonacci " + i + ": " + OddonacciLinear(i,1,1,1,1);
			runT=System.currentTimeMillis()-sTime;//calculating time it takes to execute
			result = result.concat("  And it takes "+runT+" milliseconds");
			System.out.println(result);//print result
			print(result);//print result in a text file
		}
		
	}
	public static void print(String result){//method to output the result to a text file
		File file = new File("Linear.txt");
		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(file, true));
			out.println(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
