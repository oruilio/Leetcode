//Rui Li
//Pro 167 Easy

/*
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 
 Note:
 
 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:
 
 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
*/


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
         //sol1:粗暴法
         for(int i=0; i<numbers.length; i++){
         for(int j=i+1; j<numbers.length&&numbers[j]<=target-numbers[i]; j++){。  //如果两数之和大于target以后就没必要继续
         if(numbers[j]==target-numbers[i]){
         return new int[]{i+1,j+1};
         }
         }
         }
         return new int[0];
         */
        
        //sol2:双指针
        int[] result=new int[2];
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                result[0]=i+1;
                result[1]=j+1;
                break;
            }
            else{
                if(numbers[i]+numbers[j]<target){  //左指针右移得到更大的数字
                    i++;
                }
                else{                              //右指针左移得到更小的数字
                    j--;
                }
            }
        }
        return result;
    }
}
