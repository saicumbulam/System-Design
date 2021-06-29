package Design;

import java.util.ArrayList;
import java.util.List;

/*

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value)
Inserts the pair (idKey, value) into the stream,
then returns the largest possible chunk of currently
inserted values that appear next in the order.

* */
public class OrderedStream {
    private String[] values;
    private int ptr;

    public OrderedStream(int n) {
        values = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        values[id - 1] = value;

        List<String> result = new ArrayList();
        while (ptr < values.length && values[ptr] != null) {
            result.add(values[ptr++]);
        }

        return result;
    }
}
