package Iterators;

class RLEIterator {

    int index;
    int [] A;
    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        while(index < A.length && n > A[index]){
            n = n - A[index];
            index += 2;
        }

        if(index >= A.length){
            return -1;
        }

        A[index] = A[index] - n;
        return A[index + 1];
    }

    public static void main(String[] args) {
        RLEIterator rle =  new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rle.next(2)); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
        System.out.println(rle.next(1)); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
        System.out.println(rle.next(1)); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
        System.out.println(rle.next(2)); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5,
        }
}