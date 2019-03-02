import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindRestaurant {
    //Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
    //
    //You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
    //
    //Example 1:
    //Input:
    //["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    //Output: ["Shogun"]
    //Explanation: The only restaurant they both like is "Shogun".
    //Example 2:
    //Input:
    //["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //["KFC", "Shogun", "Burger King"]
    //Output: ["Shogun"]
    //Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
    //Note:
    //The length of both lists will be in the range of [1, 1000].
    //The length of strings in both lists will be in the range of [1, 30].
    //The index is starting from 0 to the list length minus 1.
    //No duplicates in both lists.

    //METHOD1
    //TIME COMPLEXITY: O(L1*L2)*X X is string comparison
    //SPACE COMPLEXITY: O(L1*L2*X)
    public String[] findRestaurant1(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> hashmap = new HashMap<>();
        for (int i = 0; i< list1.length; i++){
            for (int j =0; j< list2.length;j++){
                if (list1[i].equals(list2[j])){
                    if (!hashmap.containsKey(i+j)){
                        hashmap.put(i+j,new ArrayList<String>());
                    }
                    hashmap.get(i+j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: hashmap.keySet()){
            min_index_sum = Math.min(min_index_sum,key);
        }
        String[] res = new String[hashmap.get(min_index_sum).size()];
        return hashmap.get(min_index_sum).toArray(res);
    }


    //METHOD 2
    //TIME COMPLEXITY: O(L1+L2)*(L1+L2)*X X is string comparison
    //SPACE COMPLEXITY: O(A*X)
    public String[] findRestaurant2(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i< list1.length+list2.length-1;i++){
            for (int j = 0; j<= i;j++){
                if (j<list1.length && (i-j) < list2.length && list1[j].equals(list2[i-j])){
                    ans.add(list1[j]);
                }
            }

            if (ans.size()>0){
                break;
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    //METHOD 3
    //TIME COMPLEXITY: O(L1+L2)
    //SPACE COMPLEXITY: O(L1*X) X IS AVERAGE STRING LENGTH
    //NO NEED TO DO STRING COMPARISON

    public String[] findRestaurant3(String[] list1, String[] list2) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i<list1.length;i++){
            hashmap.put(list1[i],i);
        }

        List<String> ans = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE;
        for (int j = 0;j< list2.length && j<=min_sum;j++){
            if (hashmap.containsKey(list2[j])){
                int sum = j+ hashmap.get(list2[j]);
                if (sum < min_sum){
                    ans.clear();
                    ans.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum){
                    ans.add(list2[j]);
                }

            }

        }
        return ans.toArray(new String[ans.size()]);
    }
}
