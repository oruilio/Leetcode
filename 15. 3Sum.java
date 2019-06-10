//Rui Li
//Pro 15 Medium

/*
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 
 Note:
 
 The solution set must not contain duplicate triplets.
 
 Example:
 
 Given array nums = [-1, 0, 1, 2, -1, -4],
 
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //two sum的升级版，two sum有三种方法：
        //1.循环套循环：遍历所有可能
        //2.两个独立循环：HashMap 登记所有信息，然遍历一次，查有无可能性
        //3.循环一次：因为可能性一一独立，所以当前项直接查找HashMap，如果没有符合要求项，把自己写入HashMap，后面的对象会把它再捞出来。
        
        //3Sum：
        //1.三个循环嵌套
        //2.两个循环嵌套+two sum里的sol3
        //3.把sol2里面的一个循环用双指针来写
        //先确定一个元素，然后用左右两个指针进行遍历即可。
        
        
        //sol1: 非常sb&冗长&粗暴的方法= =
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        
        //特例：小于三位，全大于0，小于0的情况
        if(nums.length<3||nums[0]>0||nums[nums.length-1]<0){
            return res;
        }
        
        //遍历数组，得到>=0的第一个数字的index
        int k=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            }
            if(nums[i]>0){
                k=i;
                break;
            }
        }
        
        if(count>0){
            k--;
        }
        if(count>=3){          //如果出现三个0
            ArrayList<Integer> tmp=new ArrayList<>();
            tmp.add(0);
            tmp.add(0);
            tmp.add(0);
            res.add(tmp);
        }
        
        
        for(int i=0; i<k; i++){                 //<0的元素
            if(i==0||nums[i]!=nums[i-1]){       //如果有重复数字则略过
                for(int j=k; j<nums.length; j++){   //>0的元素
                    if(j==k||nums[j]!=nums[j-1]){   //如果元素重复略过
                        ArrayList<Integer> tmp=new ArrayList<>();
                        //List<Integer> tmp=new List<>();
                        if(nums[i]+nums[j]<=0){
                            for(int m=j+1; m<nums.length; m++){    //使上列两元素为0的元素
                                if(nums[i]+nums[j]+nums[m]==0){
                                    tmp.add(nums[i]);
                                    tmp.add(nums[j]);
                                    tmp.add(nums[m]);
                                    res.add(tmp);
                                    break;
                                }
                            }
                        }
                        else{
                            for(int m=i+1; m<k; m++){
                                if(nums[i]+nums[j]+nums[m]==0){
                                    tmp.add(nums[i]);
                                    tmp.add(nums[j]);
                                    tmp.add(nums[m]);
                                    res.add(tmp);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return res;
        
        
        //sol2:
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
                
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
        
    }
}
