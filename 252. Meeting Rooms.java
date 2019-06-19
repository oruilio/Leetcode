//Rui Li
//Pro 252 Easy

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/meeting-rooms
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //sol1: 粗暴法， 全部遍历看有没有重合
        for(int i=0; i<intervals.length; i++){
            for(int j=i+1; j<intervals.length; j++){
                if(!(intervals[j][0]>=intervals[i][1]||intervals[j][1]<=intervals[i][0])){
                    return false;
                }
            }
        }
        return true;
        
        //sol2: 根据每一场的开始时间排序，然后比较前一场的结束时间是否小于后一场的开始时间
        if(intervals == null || intervals.length==0)
           return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
        for(int i=0;i+1<intervals.length;i++){
                if(intervals[i][1]>intervals[i+1][0])
                    return false;
            }
        return true;
    }
}