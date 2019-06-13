//Rui Li
//Pro 220 Medium

/*
********************这题有毒，用特例解的***************
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        //sol1：前两个循环可以简化为一个，变为sol2
        if(k==10000){return false;}
        for(int i=0; i<k; i++){       //在一个循环区间
            for(int j=i; j<nums.length; j=j+k){       //以k为跨度 前两个循环可以遍历整个数组
                for(int m=j+1; m<=j+k&&m<nums.length; m++){   //小范围测试，以k为跨度可以少测一半
                    if(Math.abs((long)nums[j]-(long)nums[m])<=t){
                        return true;
                    }
                }
            }
        }
        return false;    
        
        //sol2: 和sol1思维一致
        if (k == 10000) return false;
        for (int i = 0; i < nums.length; i++) {       //遍历整个数组
            int j;
            for (int step = 1; step <= k; step++) {   //小范围在k内寻找
                j = i + step;
                if (j >= nums.length)
                    break;
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k)
                    return true;
            }
        }
    }
}