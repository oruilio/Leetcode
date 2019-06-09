//Rui Li
//Pro 11 Medium

/*
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 
 Note: You may not slant the container and n is at least 2.
 
  
 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
  
 
 Example:
 
 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49

*/

class Solution {
    public int maxArea(int[] height) {
        
        //sol1: really basic idea
        int res=0;
        for(int i=0; i<height.length; i++){
            for(int j=i;j<height.length; j++){    //the most water we can get use the current element
                int tmp=Math.abs(i-j)*Math.min(height[i],height[j]);
                res=Math.max(res,tmp);
            }
        }
        return res;
        
        //sol2: move from both sides
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;              //move the shorter line to get a possiblity to increase the water
            else
                r--;
        }                         //因为是从两边向中间逼近，短的一方限制了水量，所以动短的一方有可能得到更大值，而动长的一方只会得到更小值或不变，所以只需要动短的一边即可
        return maxarea;
    }
}
