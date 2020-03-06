package Top100;

public class rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;

            }
        }
    }
}
