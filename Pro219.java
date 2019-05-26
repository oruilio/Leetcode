//Rui Li
//Pro 219 Easy

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         //sol1:
         for(int i=0; i<nums.length; i++){
         for(int j=i+1; j<=i+k&&j<nums.length; j++){
         if(nums[j]==nums[i]){
         return true;
         }
         }
         }
         return false;
         */
        
        //sol2:
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else{
                if(i-map.get(nums[i])<=k){
                    return true;
                }
                else{
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
