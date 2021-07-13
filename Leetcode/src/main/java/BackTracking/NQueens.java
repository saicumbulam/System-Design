package BackTracking;

import java.util.ArrayList;
import java.util.List;

//O(N!) | O(N)
public class NQueens {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = '.';
            }
        }

        solve(arr, 0);
        return result;
    }

    private void solve(char[][] arr, int index)
    {
        if (index == arr.length)
        {
            result.add(convert(arr));
            return;
        }


        for(int i = 0; i < arr[0].length; i++)
        {
            if (valid(arr, index, i))
            {
                arr[index][i] = 'Q';
                solve(arr, index+1);
                arr[index][i] = '.';
            }
        }
    }


    private boolean valid(char[][] arr, int r, int c)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i][c] == 'Q') return false;
        }


        int i = r-1;
        int j = c+1;

        while(i >= 0 && j < arr[0].length)
        {
            if (arr[i][j] == 'Q') return false;
            i--;
            j++;
        }

        i = r-1;
        j = c-1;

        while(i >= 0 && j >= 0)
        {
            if (arr[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }


    private List<String> convert(char[][] arr)
    {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
        {
            result.add(String.valueOf(arr[i]));
        }

        return result;
    }
}
