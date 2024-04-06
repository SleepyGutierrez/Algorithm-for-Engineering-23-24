import java.util.Arrays;

public class MatrixSC_Sum {
	
	public static void main(String[] args) {
		
		
		int[][] A = {	{1, 2, 3, 4}, 
						{4, 1, 2, 3}, 
						{3, 4, 1, 2}, 
						{2, 3, 4, 1}	};
		
        int[][] B = {	{2, 3, 4, 1}, 
        				{1, 2, 3, 4}, 
        				{4, 1, 2, 3}, 
        				{3, 4, 1, 2}	};
        

        int[][] result = s_sum(A, B);

        System.out.println("Sum of super circulant matrices A and B:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
	
	
	// an algorithm D&C for super circular matrices only
	public static int[][] s_sum(int[][] A, int[][] B){
		
		int a_rows = A.length;
		int a_columns = A[0].length;
		int[][] C = new int[a_rows][a_columns];
		
		if(a_rows==1) {
			
			C[0][0] = A[0][0]+B[0][0];
			return C;
		
		} else {
			
			int[][] A1 = new int[a_rows/2][a_columns/2];
			int[][] A2 = new int[a_rows/2][a_columns/2];
			
			
			int[][] B1 = new int[a_rows/2][a_columns/2];
			int[][] B2 = new int[a_rows/2][a_columns/2];
			
			int[][] C1 = new int[a_rows/2][a_columns/2];
			int[][] C2 = new int[a_rows/2][a_columns/2];
			
			
			for (int i = 0; i < a_rows/2; i++) {
				
	            System.arraycopy(A[i], 0, A1[i], 0, a_rows/2);
	            System.arraycopy(A[i], a_rows/2, A2[i], 0, a_rows/2);
	            System.arraycopy(B[i], 0, B1[i], 0, a_rows/2);
	            System.arraycopy(B[i], a_rows/2, B2[i], 0, a_rows/2);
	            
	        }
			
			C1 = s_sum(A1, B1);
			C2 = s_sum(A2, B2);
			
			for (int i = 0; i < a_rows/2; i++) {
	            System.arraycopy(C1[i], 0, C[i], 0, a_rows/2);
	            System.arraycopy(C2[i], 0, C[i], a_rows/2, a_rows/2);
	            System.arraycopy(C2[i], 0, C[i + a_rows/2], 0, a_rows/2);
	            System.arraycopy(C1[i], 0, C[i + a_rows/2], a_rows/2, a_rows/2);
	        }
			return C;
		}
		
	}

}
