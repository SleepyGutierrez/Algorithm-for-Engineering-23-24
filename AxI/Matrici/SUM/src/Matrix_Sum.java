
public class Matrix_Sum {
	
	public static void main(String[] args) {
		
		int[][] first = {	{0,1,2},
							{9,8,7},
							{2,9,0} };
		
		int[][] second = {	{2,3,5}, 
							{6,3,3},
							{1,1,1} };
		
		System.out.print("The sum of matrices:\n");
		Matrix_Sum.print_Matrix(first);
		Matrix_Sum.print_Matrix(second);
		
		int [][] C = Matrix_Sum.sum_CM(first, second);
		
		System.out.print("is\n");
		Matrix_Sum.print_Matrix(C);
		
		
	}
	

	    public static int[][] sum_CM(int[][] A, int[][] B){
	        
	        int a_rows = A.length;
	        int a_columns = A[0].length;
	        
	        int[][] C = new int[a_rows][a_columns];
	        
	        // A and B are matrices of same dimensions

	        for (int i = 0; i < a_rows; i++) {
	            
	            for(int j = 0; j  < a_columns; j++){
	            	
	            	C[i][j] = A[i][j] + B[i][j];

	            }
	        }
	        
	        return C;

	    }
	    
	    public static void print_Matrix(int[][] A) {
	    	for (int i = 0; i < A.length; i++) {
	    	    for (int j = 0; j < A[i].length; j++) {
	    	        System.out.print(A[i][j] + " ");
	    	    }
	    	    System.out.println();
	    	}
	    }
}
