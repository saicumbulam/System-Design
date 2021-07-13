package BackTracking;

import java.util.ArrayList;
import java.util.List;

//o(27) | o(19)
public class RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(res,new StringBuilder(),s,0,0);
        return res;
    }

    //start: starting index, count: numbers added into string builder
    public void helper(List<String> res, StringBuilder temp, String s,int start, int count){
        if (start==s.length() && count==4)
        {
            res.add(temp.toString());
        }
        else if (count==4)
        {
            return;
        }

        for(int i=start; i < s.length(); i++){
            String curr = s.substring(start,i+1);
            int value = Integer.parseInt(curr);

            if (curr.length()>1 && curr.charAt(0)=='0') return;
            // out of range
            if (value>255) return;

            // less or equal to 255
            if (value>=0){
                // Backtracking
                StringBuilder rollback = new StringBuilder(temp);
                temp.append(curr);
                if (count<3) temp.append(".");

                helper(res,temp,s,i+1,count+1);
                // Rollback to previous state
                temp = rollback;
            }
        }
    }
}
