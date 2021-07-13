package BackTracking;

import java.util.ArrayList;
import java.util.List;

//o(4^n)/(n)^1/2
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        calc(n ,0, 0, "", result);
        return result;
    }

    private void calc(int n, int start, int end, String curr, List<String> result)
    {
        if (curr.length() == 2*n)
        {
            result.add(curr);
        }

        if (start < n)
        {
            calc(n, start+1, end, curr+ "(", result);
        }
        if (end < start)
        {
            calc(n, start, end+1, curr+ ")", result);
        }
    }
}
