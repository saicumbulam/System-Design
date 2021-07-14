package Matrix;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        int num = 1;

        while(rowStart <= rowEnd && colStart <= colEnd)
        {
            for(int c = colStart; c <= colEnd; c++)
            {
                matrix[rowStart][c] = num++;
            }

            rowStart++;

            for(int r = rowStart; r <= rowEnd; r++)
            {
                matrix[r][colEnd] = num++;
            }

            colEnd--;

            for(int c = colEnd; c >= colStart; c--)
            {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][c] = num++;
            }

            rowEnd--;

            for(int r = rowEnd; r >= rowStart; r--)
            {
                if (colStart <= colEnd)
                    matrix[r][colStart] = num++;
            }

            colStart++;

        }

        return matrix;
    }
}
