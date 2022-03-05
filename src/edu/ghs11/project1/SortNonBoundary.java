package edu.ghs11.project1;

import java.util.Scanner;

//feat-3 no sides are open
public class SortNonBoundary {

	int m=0;
	int A[][]=null;  // size to be determised
	
	SortNonBoundary(){
		
	}
	
	
	//input square matrix 
	void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter row or column count of the square matrix");
		m = in.nextInt();
		
		if( m < 4 || m > 10) {
			System.out.println("Enter row count must be between 4 and 10");
			System.exit(0);
		}
			
			
		System.out.println("Enter Matrix of integers ..");
		A = new int[m][m];
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<m;j++) {
					System.out.println("Enter element in row "+(i+1)+" and column "+(j+1));
					A[i][j]= in.nextInt();
			}
		}
		
		
		in.close();
	}
	
	
	// sort matrix 
	void sortArray() {
		
		int countNonBoundaryElement = (m-2)*(m-2);
		int[] oneDimArray = new int[countNonBoundaryElement];
		
		// copy non boundary elements of matrix  to one dimensional array
		int k=0;
        for(int i=1;i< m-1;i++)
        {
            for(int j=1;j< m-1;j++)
            {
            	oneDimArray[k]=A[i][j];
                k++;
            }
        }
		
        
        // sorting one-dimensional array 
        int temp = 0;
        for(int i=0;i< oneDimArray.length;i++)
        {
            for(int j=0;j< oneDimArray.length;j++)
            {
                if(oneDimArray[i] < oneDimArray[j])
                {
                    temp=oneDimArray[i];
                    oneDimArray[i]=oneDimArray[j];
                    oneDimArray[j]=temp;
                }
            }
        }
        
        // put sorted non boundary elements into matrix
        k=0;
        for(int i=1;i< m-1;i++)
        {
            for(int j=1;j< m-1;j++)
            {
                A[i][j]=oneDimArray[k];
                k++;
            }
        }

        
        
	}
	
	// print matrix
	void printArray() {
		
		System.out.println("SORTED MATRIX:");
        for(int i=0;i< m;i++)
        {
            for(int j=0;j< m;j++)
            {
                System.out.print(A[i][j]+" ");

            }
            System.out.println();
        }
	}
	
	
	//print matrix with only diagonal elements
	void printDiagonal() {

		System.out.println("PRINT DIAGONAL MATRIX:");
        for(int i=0;i< m;i++)
        {
            for(int j=0;j< m;j++)
            {
            	if (i==j)
            		System.out.print(A[i][j]+" ");
            	else
            		System.out.print("  ");	
            }
            System.out.println();
        }

		
	}
	
	
	
	
	public static void main(String[] args) {
		
		SortNonBoundary snb = new SortNonBoundary();
		
		snb.input();
		
		snb.sortArray();
		
		snb.printArray();
		
		snb.printDiagonal();
		
	}

}
