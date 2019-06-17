//Rui Li
//Pro 42 Hard

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


class Solution {
    public int trap(int[] height) {
        
        //main idea:
        //在一个位置能容下的雨水量等于它左右两边柱子高度最小值减去它的高度.      
        //如何找所有位置的左右两边的柱子的最大值?       


        //sol1: [粗暴法] 直接对于每个坑都计算左右两边最大值
        if(height.length<=2){return 0;}
        int res=0;
        //对每一个坑都算一遍左边右边的最大值，看这个坑能够蓄水多少
        //第一个和最后一个都不会蓄水，只能当作墙来用
        for(int i=1; i<height.length-1; i++){
            int maxLeft=0, maxRight=0;
            for(int j=i; j>=0; j--){
                maxLeft=Math.max(height[j],maxLeft);
            }
            for(int j=i; j<height.length; j++){
                maxRight=Math.max(height[j],maxRight);
            }
            res+=Math.min(maxRight,maxLeft)-height[i];
        }
        return res;
        
        
        //sol2: [动态编程] 和sol1算法基本一致，但是提前把左右两边的最大值都计算出来，不需要重复计算了，时间复杂度降低为O(n)
        int len = height.length;
        int[] left = new int[len];//left[i]表示i左边的最大值，right[i]表示i右边的最大值
        int[] right = new int[len];
      
        for(int i=1;i<len-1;i++){
            left[i]=Math.max(left[i-1],height[i-1]);//i左边的最大值等于= max（i-1左边的最大值 ， i-1的高度）；
        }
        for(int i=len-2;i>=1;i--){
            right[i]=Math.max(right[i+1],height[i+1]);
        }
        int sum=0;
        for(int i=1;i<len;i++){
            int num = Math.min(left[i],right[i]);
            sum += Math.max(0,num-height[i]);//相当于把负数的去掉
        }
        return sum;  
        */
        
        //sol3:[堆栈] 利用堆栈可以popup的特性
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0;i < height.length; i++) {
            
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i); //存入的是index，如果是下降趋势
            } 
            else {
                int count = stack.pop();
                if (!stack.isEmpty()) {  //如果弹出后仍有元素
                    int h = Math.min(height[stack.peek()], height[i]) - height[count];
                    h = h>0 ? h :0;
                    area += h* (i-stack.peek()-1);
                }
                i--;
            }
        }
        return area;
        
        //sol4:
        int water = 0;
        int rightPtr = height.length - 1;
        int leftPtr = 0;
        if(rightPtr < 2) {
        	return 0;
        }
        int lower = Math.min(height[leftPtr],height[rightPtr]);
        while(leftPtr < rightPtr - 1) {
        	if(height[leftPtr] < height[rightPtr]) {
        		if(lower > height[++leftPtr]) {
        			water += lower - height[leftPtr];
        		}else {
        			lower = Math.min(height[leftPtr],height[rightPtr]);
        		}
        	}else {
        		if(lower > height[--rightPtr]) {
        			water += lower - height[rightPtr];
        		}else {
        			lower = Math.min(height[leftPtr],height[rightPtr]);
        		}
        	}
        }
        return water;
        
        //sol5:
        if (height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1, count = 0;
        int ltemp = height[l], rtemp = height[r];
        while (l < r) {
            if (height[l] > height[r]) {
                if (height[r] > rtemp) {
                    rtemp = height[r];
                } 
                else {
                    count += rtemp - height[r];
                }
                r--;
            } 
            else {
                if (height[l] > ltemp) {
                    ltemp = height[l];
                } 
                else {
                    count += ltemp - height[l];
                }
                l++;
            }
        }
        return count;
        
         /*
        【接雨水】
         1. 找到最高点p
         2.从左往右，算出[0,p)局部最高点序列。然后拿这个序列减去原序列对应的位置。累加起来s1。
         3.从右往左，和2做同样的操作。得s2
         4.结果为s = s1+s2
         例：[0,1,0,2,1,0,1,3,2,1,2,1] 3为最高点。

         从前往后局部最高点序列 [0,1,1,2,2,2,2] [0,1,0,2,1,0,1] s1 = 0+0+1+0+1+2+1=5
         从后往前局部最高点序列 [2,2,2,1] [2,1,2,1] s2 = 0+1+0+0
         s = s1+s2 = 6
         */    
    }
}

