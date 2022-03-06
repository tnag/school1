package edu.ghs11.project1;

import java.util.Arrays;
import java.util.Scanner;

public class SortMatrix {

	int rows = 0;
	int cols = 0;
	int[][] inputMatrix = null; 
	int min,max,mini,minj,maxi,maxj = 0;
	
	//feat-6
	SortMatrix(int m, int n){
	   this.rows = m;
	   this.cols = n;
	}
	
	// feature 1
	public void readInputMatrix() {
		
		System.out.println("Enter Matrix of integers ..");
		this.inputMatrix = new int[rows][cols];
		
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<rows;i++) {
			for(int j=0; j<cols;j++) {
					System.out.println("Enter element in row "+(i+1)+" and column "+(j+1));
					inputMatrix[i][j]= in.nextInt();
			}
		}
		
		in.close();
		
	}

    // feature 2	
	public void displayInputMatrix() {
		
		//Display Input Matrix 
		for(int i=0; i<rows;i++) {
			for(int j=0; j<cols;j++) {
					System.out.print(inputMatrix[i][j]+"  ");
			}
			System.out.println("\n");
		}
	}
	
	public void displaySortedMatrix() {
		
		this.min = inputMatrix[0][0];
		this.max = inputMatrix[0][0];
				
		// sort matrix		
		this.sortMatrix();
		//Display max 
		System.out.println("LARGEST NUMBER: "+max);
		System.out.println("ROW = "+maxi);
		System.out.println("COLUMN = "+maxj);
		
		//Display minimum
		System.out.println("SMALLEST NUMBER: "+min);
		System.out.println("ROW = "+mini);
		System.out.println("COLUMN = "+minj);
		
		//Display Sorted Matrix Matrix 
		System.out.println("REARRANGED MATRIX");
		this.displayInputMatrix();
		
	}
	
	
	private void sortMatrix() {
	
		int[] oneDimArray = new int[rows*cols];
		for(int i=0; i<rows;i++) {
			for(int j=0; j<cols;j++) {
				oneDimArray[i*cols+j]=inputMatrix[i][j];
				//check minimum
				if( inputMatrix[i][j] < min) {
					min = inputMatrix[i][j];
					mini = i+1;
					minj = j+1;
				}
				//check maximum
				if( inputMatrix[i][j] > max) {
					max = inputMatrix[i][j];
					maxi = i+1;
					maxj = j+1;
				}
			
			}
		}

		// Arrays.sort(oneDimArray);
		bubbleSort(oneDimArray);
		
		
		for(int i=0; i<rows;i++) {
			for(int j=0; j<cols;j++) {
				inputMatrix[i][j]=oneDimArray[i*cols+j];
			}
		}
		
		
	}
	
	void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }  	
	
    	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter M - number of rows");
		int m = in.nextInt();
		System.out.println("Enter N - number of cols");
		int n = in.nextInt();
		
		if(m>2 && n<20) {
			SortMatrix sm = new SortMatrix(m,n);
			sm.readInputMatrix();
			System.out.println("ORIGINAL MATRIX");
			sm.displayInputMatrix();
			
			System.out.println("\n\n\n");
			sm.displaySortedMatrix();
		} else {
			System.out.println(" Invalid input");
		}
		in.close();
	
		
	}
		

}
