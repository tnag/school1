package edu.ghs11.project1;

import java.util.Scanner;

public class Selection_sort {
  
	int s=0;
	int A[]=null;
	
	Selection_sort(int n){
		 s=n;
	}
	
	
	// input array 
	void accept() {
		System.out.println("Enter Array of integers ..");
		A = new int[s];
		Scanner in = new Scanner(System.in);
		for(int i=0; i<s;i++) {
			 		System.out.println("Enter element number "+(i+1));
					A[i]= in.nextInt();
		 }
		 in.close();
	}
	
	
	
	// sort array
	void selsort() {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < s-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < s; j++)
                if (A[j] < A[min_idx])
                    min_idx = j;
            // Swap the found minimum element with the first element
            int temp = A[min_idx];
            A[min_idx] = A[i];
            A[i] = temp;
        }	
	}

	
	// display sorted array 
	void display() {
		System.out.println("Displaying sorted array : \n ");
		for(int i=0; i<s;i++) {
	 		System.out.print(A[i]+"  ");
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n = in.nextInt();
		
		Selection_sort sorter =new Selection_sort(n);
		
		sorter.accept();
		sorter.selsort();
		sorter.display();
		
		in.close();
	}

}
