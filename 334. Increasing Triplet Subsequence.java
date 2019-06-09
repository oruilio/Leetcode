//Rui Li
//Pro 334 Medium

/*
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 
 Formally the function should:
 
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 
 Example 1:
 
 Input: [1,2,3,4,5]
 Output: true
 Example 2:
 
 Input: [5,4,3,2,1]
 Output: false

*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        //无法理解为啥两种方法一个意思。第一个就是不对！！！！？？？WTF？？？
        //if(nums.length<3){return false;}
        int one=Integer.MAX_VALUE;
        int two=Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=one){
                one=nums[i];
            }
            else if(nums[i]<=two){
                two=nums[i];
            }
            else{
                return true;
            }
        }
        return false;
        
        /*
         int one = Integer.MAX_VALUE;            //the main idea is:
         int two = Integer.MAX_VALUE;            //           从左边来看，首先选取最小值，作为第一个起点，随后选取中间值(>最小值），如果一直到最后都没有选到中间值，则返回值必然为false
                                                 //           如果中间值选到了的话，就开始选取最大值，如果最大值存在，即存在三个值完成题述条件。
         for (int n : nums) {
         if (n <= one) {
         one = n;
         } else if (n <= two) {
         two = n;
         } else {
         return true;
         }
         }
         
         return false;
         */
    }
}

