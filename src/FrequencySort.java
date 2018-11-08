import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {


        //method 1
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c: s.toCharArray()){
            if (hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else{
                hashMap.put(c,1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!hashMap.isEmpty()){
            int max = 0;
            Character tmp = 'a';
            for (char c: hashMap.keySet()){
                if (hashMap.get(c)>max){
                    max = hashMap.get(c);
                    tmp = c;
                }
            }
            for (int i = 0; i<max;i++){
                stringBuilder.append(tmp);
            }
            hashMap.remove(tmp);
        }
        return stringBuilder.toString();


    }
    //method2
    //use bucket sort and hashmap
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < map.get(c); i++)
                        sb.append(c);

        return sb.toString();
    }

    //method3
    //priorityQueue
    public String frequencySort3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
