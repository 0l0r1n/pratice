/*
    Given an NxN matrix, where each pixel in the image is four bytes, write am ethod to rotate the image by 90 degrees.
    Circulaton rotation = top goes to right; right goes to bottom; bottom goes to left and left goes to top;
*/
public class RotateMatrix {

    public static boolean rotate(int[][] matrix) {
        // first check that this is a valid matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;

            }
        }
        return true;
    }
}