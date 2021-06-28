package Design;

/*

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message)
Returns true if the message should be printed
in the given timestamp, otherwise returns false.
*/

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message))
        {
            map.put(message, timestamp);
            return true;
        }
        else
        {
            int oldtimeStamp = map.get(message);
            if (timestamp - oldtimeStamp >= 10)
            {
                map.put(message, timestamp);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
