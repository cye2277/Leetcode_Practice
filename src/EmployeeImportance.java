import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    //Time complexity: O(N)
    //Space complexity: O(N)
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hashMap = new HashMap<>();
        for (Employee employee:employees){
            hashMap.put(employee.id,employee);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int ans = 0;
        while (!queue.isEmpty()){
            Employee target  = new Employee();
            int i = queue.poll();
            for (Employee e: employees){
                target = hashMap.get(i);
            }
            ans += target.importance;
            for (int suborId :target.subordinates){
                queue.add(suborId);
            }
        }
        return ans;
    }
}
