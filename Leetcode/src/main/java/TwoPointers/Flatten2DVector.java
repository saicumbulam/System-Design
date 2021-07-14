package TwoPointers;

public class Flatten2DVector {
    class Vector2D {
        int i = 0;
        int j = 0;
        int[][] arr;

        public Vector2D(int[][] vec) {
            arr = vec;
        }

        public int next() {
            if(!hasNext()) return -1;
            return arr[i][j++];
        }

        public boolean hasNext() {
            while(i < arr.length && j >= arr[i].length)
            {
                i++;
                j = 0;
            }

            return i < arr.length;
        }
    }
}
