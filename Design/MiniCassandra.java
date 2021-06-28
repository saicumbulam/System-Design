package Design;

import java.util.*;

/**

Cassandra is a NoSQL database (a.k.a key-value storage).
One individual data entry in cassandra constructed by 3 parts:

row_key. (a.k.a hash_key, partition key or sharding_key.)
column_key.
value

row_key is used to hash and can not support range query.
 Let's simplify this to a string.
column_key is sorted and support range query. Let's simplify this to integer.
value is a string. You can serialize any data into a string and store it in value.
Implement the following methods:

insert(row_key, column_key, value)
query(row_key, column_start, column_end) return a list of entries

 Input:
 insert("google", 1, "haha")
 insert("lintcode", 1, "Good")
 insert("google", 2, "hehe")
 query("google", 0, 1)
 query("google", 0, 2)
 query("go", 0, 1)
 query("lintcode", 0, 10)
 Output:
 [(1, "haha")]
 [(1, "haha"),(2, "hehe")]
 []
 [(1, "Good")]

 */


public class MiniCassandra {
    public class Column {
      public int key;
      public String value;
      public Column(int key, String value) {
          this.key = key;
          this.value = value;
     }
  }

    Map<String, TreeMap<Integer, Column>> rowMap;
    public MiniCassandra() {
        // do intialization if necessary
        rowMap = new HashMap<>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */

    public void insert(String row_key, int column_key, String value) {
        // write your code here
        TreeMap<Integer, Column> columnMap =
                rowMap.getOrDefault(row_key, new TreeMap<>());
        Column column = new Column(column_key, value);
        columnMap.put(column_key, column);
        rowMap.put(row_key, columnMap);
    }

    /*
     * @param row_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        if (!rowMap.containsKey(row_key)) {
            return new ArrayList<>();
        }

        TreeMap<Integer, Column> columnMap = rowMap.get(row_key);
        NavigableMap<Integer, Column> rangeMap =
                columnMap.subMap(column_start, true,
                        column_end, true);
        List<Column> ans = new ArrayList<>();
        for (Integer key : rangeMap.keySet()) {
            ans.add(rangeMap.get(key));
        }

        return ans;
    }
}