package Design;

import org.antlr.v4.runtime.tree.Tree;

import java.util.*;

public class InvertedIndex {
    class Document
    {
        public int id;
        public String content;
    }

    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        for(Document doc : docs) {
            String[] strs = doc.content.split(" ");
            for(String str : strs) {
                if ("".equals(str)) continue;
                update(str, doc.id, map);
            }
        }
        Map<String, List<Integer>> results = new HashMap<>();
        for(Map.Entry<String, TreeSet<Integer>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue());
            results.put(entry.getKey(), list);
        }
        return results;
    }
    private void update(String str, int id, Map<String, TreeSet<Integer>> results) {
        TreeSet<Integer> set = results.get(str);
        if (set == null) {
            set = new TreeSet<>();
            results.put(str, set);
        }
        set.add(id);
    }
}
