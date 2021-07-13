package BackTracking;

import java.util.ArrayList;
import java.util.List;

//o(2^n) | o(1)
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // there are 2 ^ n numbers in the Gray code sequence.
        int sequenceLength = 1 << n;
        for (int i = 0; i < sequenceLength; i++) {
            int num = i ^ i >> 1;
            result.add(num);
        }
        return result;
    }
}
