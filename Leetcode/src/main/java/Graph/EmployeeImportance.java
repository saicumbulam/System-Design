package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    static class Employee {
        public int importance;
        public Integer[] subordinates;
        public Integer id;
    }

    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

}
