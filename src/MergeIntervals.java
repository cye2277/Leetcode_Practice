import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //Given a collection of intervals, merge all overlapping intervals.
    //
    //Example 1:
    //
    //Input: [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]
    //Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    //Example 2:
    //
    //Input: [[1,4],[4,5]]
    //Output: [[1,5]]
    //Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    //NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


    //Time Complexity:O(NlogN)
    //Space complexity:O(N) or O(1) depend on whether we sort integer in place
    public int[][] merge(int[][] intervals) {
        if (intervals.length <=1){
            return intervals;
        }
        Arrays.sort(intervals, (a1, a2) ->Integer.compare(a1[0],a2[0]));
        List<int[]> ans = new ArrayList();
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] intArr: intervals){
            if (intArr[0]<= newInterval[1]){
                newInterval[1] = Math.max(intArr[1], newInterval[1]);
            }else{
                ans.add(intArr);
                newInterval = intArr;

            }


        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
