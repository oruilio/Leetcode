//Rui Li
//Pro 41 Hard

/*
 Given an unsorted integer array, find the smallest missing positive integer.
 
 Example 1:
 
 Input: [1,2,0]
 Output: 3
 Example 2:
 
 Input: [3,4,-1,1]
 Output: 2
 Example 3:
 
 Input: [7,8,9,11,12]
 Output: 1
 Note:
 
 Your algorithm should run in O(n) time and uses constant extra space.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int tmp=1;
        if(nums.length==0){return 1;}
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                if(nums[i]==tmp){
                    tmp++;
                }
                else if(nums[i]!=tmp&&nums[i]!=tmp-1){
                    return tmp;
                }
            }
        }
        if(nums[nums.length-1]>=0){
            return nums[nums.length-1]+1;
        }
        else{
            return 1;
        }        
    }
}
