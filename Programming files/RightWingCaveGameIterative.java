//*************************************************
//POlINA ANIS'KINA
//ID:26991092
//EDOUARD LAROUCHE
//ID:27826907
//COMP-352-F
// Programming part A - Linear Version
//*************************************************

import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;

public class RightWingCaveGameIterative {

    // ARRAYLIST ALGORITHM
	public static boolean RightWingCaveArrayList(int A[]) {
		// converting the array to an ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>(A.length);
		for (int i=0; i<A.length; i++) {
			list.add(A[i]);
		}

		// variables
		int i = 0;
  		int j;
		int counter = 0;

		while(true){
			if(list.get(i) == 0) // win
				return true;
			if(list.size() - i > list.get(i)) // can go right
				j = i + list.get(i); // going right
			else if(list.get(i) < i) // can go left
				j = i - list.get(i); // going left
			else // else no where to go (lose)
				return false;
			if(counter > list.size()) // current and future position are same number (lose)
				return false;
			counter++;
			i = j;
		}
	}

	
	public static void main(String[] Args){
		// 20 test cases
		int[] A={5,7,8,5,3,3,6,8,8,0};
		int[] B={4,8,5,2,3,5,1,6,4,0};
		int[] C={0};
		int[] D={3,6,5,0};
		int[] E={0,1};
		int[] F={3,4,5,2,1,0};
		int[] G={1,2,3,2,0};
		int[] H={1,2};
		int[] I={2,5,3,2,1,5,0};
		int[] J={1,2,1,1,2,0};
		int[] K={2,1,0};
		int[] L={1,3,2,0};
		int[] M={0,4,4,0};
		int[] N={7,4,5,3,2,1,3,1,0};
		int[] O={3,5,6,2,4,4,4,5,0};
		int[] P={2,0};
		int[] Q={5};
		int[] R={6,3,4,5,2,1,4,2,1,0};
		int[] S={4,3,2,1,5,0};
		int[] T={1,2,1,3,0};
		
		// running tests for array list algorithm
		System.out.println("ArrayList algorithm: ");
		System.out.println(RightWingCaveArrayList(A) + " : " + Arrays.toString(A));
		System.out.println(RightWingCaveArrayList(B) + " : " + Arrays.toString(B));
		System.out.println(RightWingCaveArrayList(C) + " : " + Arrays.toString(C));
		System.out.println(RightWingCaveArrayList(D) + " : " + Arrays.toString(D));
		System.out.println(RightWingCaveArrayList(E) + " : " + Arrays.toString(E));
		System.out.println(RightWingCaveArrayList(F) + " : " + Arrays.toString(F));
		System.out.println(RightWingCaveArrayList(G) + " : " + Arrays.toString(G));
		System.out.println(RightWingCaveArrayList(H) + " : " + Arrays.toString(H));
		System.out.println(RightWingCaveArrayList(I) + " : " + Arrays.toString(I));
		System.out.println(RightWingCaveArrayList(J) + " : " + Arrays.toString(J));
		System.out.println(RightWingCaveArrayList(K) + " : " + Arrays.toString(K));
		System.out.println(RightWingCaveArrayList(L) + " : " + Arrays.toString(L));
		System.out.println(RightWingCaveArrayList(M) + " : " + Arrays.toString(M));
		System.out.println(RightWingCaveArrayList(N) + " : " + Arrays.toString(N));
		System.out.println(RightWingCaveArrayList(O) + " : " + Arrays.toString(O));
		System.out.println(RightWingCaveArrayList(P) + " : " + Arrays.toString(P));
		System.out.println(RightWingCaveArrayList(Q) + " : " + Arrays.toString(Q));
		System.out.println(RightWingCaveArrayList(R) + " : " + Arrays.toString(R));
		System.out.println(RightWingCaveArrayList(S) + " : " + Arrays.toString(S));
		System.out.println(RightWingCaveArrayList(T) + " : " + Arrays.toString(T));
	}
}
