//*************************************************
//POlINA ANIS'KINA
//ID:26991092
//EDOUARD LAROUCHE
//ID:27826907
//COMP-352-F
// Programming part A - Recursive Version
//*************************************************

import java.util.Arrays;

public class RightWingCaveGameRecursive {

    // RECURSIVE ALGORITHM
	public static boolean RightWingCaveRecursive(int A[], int i, int counter) { //defining a method
		if ((i < 0 || i >= A.length)||(counter > A.length)) //checking where the game does not get until the end
			return false;
	
		else if (A[i] == 0) // when the game arrives at zero
			return true;
		else 
			return RightWingCaveRecursive(A, i + A[i], ++counter) || RightWingCaveRecursive(A, i - A[i], ++counter); //recursive call

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
		
		// running test for recursive algorithm
		System.out.println("Recursive algorithm: ");
		System.out.println(RightWingCaveRecursive(A,0,0) + " : " + Arrays.toString(A));
		System.out.println(RightWingCaveRecursive(B,0,0) + " : " + Arrays.toString(B));
		System.out.println(RightWingCaveRecursive(C,0,0) + " : " + Arrays.toString(C));
		System.out.println(RightWingCaveRecursive(D,0,0) + " : " + Arrays.toString(D));
		System.out.println(RightWingCaveRecursive(E,0,0) + " : " + Arrays.toString(E));
		System.out.println(RightWingCaveRecursive(F,0,0) + " : " + Arrays.toString(F));
		System.out.println(RightWingCaveRecursive(G,0,0) + " : " + Arrays.toString(G));
		System.out.println(RightWingCaveRecursive(H,0,0) + " : " + Arrays.toString(H));
		System.out.println(RightWingCaveRecursive(I,0,0) + " : " + Arrays.toString(I));
		System.out.println(RightWingCaveRecursive(J,0,0) + " : " + Arrays.toString(J));
		System.out.println(RightWingCaveRecursive(K,0,0) + " : " + Arrays.toString(K));
		System.out.println(RightWingCaveRecursive(L,0,0) + " : " + Arrays.toString(L));
		System.out.println(RightWingCaveRecursive(M,0,0) + " : " + Arrays.toString(M));
		System.out.println(RightWingCaveRecursive(N,0,0) + " : " + Arrays.toString(N));
		System.out.println(RightWingCaveRecursive(O,0,0) + " : " + Arrays.toString(O));
		System.out.println(RightWingCaveRecursive(P,0,0) + " : " + Arrays.toString(P));
		System.out.println(RightWingCaveRecursive(Q,0,0) + " : " + Arrays.toString(Q));
		System.out.println(RightWingCaveRecursive(R,0,0) + " : " + Arrays.toString(R));
		System.out.println(RightWingCaveRecursive(S,0,0) + " : " + Arrays.toString(S));
		System.out.println(RightWingCaveRecursive(T,0,0) + " : " + Arrays.toString(T));
	}
}
