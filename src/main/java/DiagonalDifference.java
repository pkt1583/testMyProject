import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int matrixSize=scanner.nextInt();
        int[][] matrix=new int[matrixSize][matrixSize];
        for(int i=0;i<matrixSize;i++){
            for(int j=0;j<matrixSize;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        int primaryDiagonal=0;
        for(int i=0;i<matrixSize;i++){
            primaryDiagonal=primaryDiagonal+matrix[i][i];
        }
        int secondaryDiagonal=0;
        int tempMatrixSize=matrixSize;
        for(int i=0;i<matrixSize;i++ ){
            secondaryDiagonal=secondaryDiagonal+matrix[tempMatrixSize-1][i];
            tempMatrixSize=tempMatrixSize-1;
        }
        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));

    }
}
