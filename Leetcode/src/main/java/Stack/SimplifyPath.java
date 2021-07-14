package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for(String item: components)
        {
            if (item.equals(".") || item.equals(" ") || item.isEmpty())
            {
                continue;
            }

            if (item.equals(".."))
            {
                if (!deque.isEmpty())
                {
                    deque.removeLast();
                }
            }
            else
            {
                deque.addLast(item);
            }
        }


        StringBuilder str = new StringBuilder();
        while(!deque.isEmpty())
        {
            str.append("/");
            str.append(deque.removeFirst());
        }

        return str.length() == 0 ? "/" : str.toString();
    }
}
