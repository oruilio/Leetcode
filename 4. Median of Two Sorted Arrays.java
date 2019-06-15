//Rui Li
//Pro 4 Hard

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


/************************一些知识点***********************/
//【没想出来，直接看的答案】
//链接：https://leetcode-cn.com/problems/two-sum/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s
//中位数：将一个集合划分为两个长度相等的子集，其中一个子集的元素总是大于另一个子集中的元素

//在两个集合中分别找到A和B， 让A>=B之前所有的元素，B>=A之前所有的元素，且 AB前的元素个数之和==AB后的元素之和（此概念和中位数相符）
//然后取左最大，右最小来计算中位数

//procedure[递归+二叉树搜索]
//二叉树搜索/binary search: set two boundaries maximum and minimum, get the medium of [min,max], 每次运行减少一半的数据
//看到带log的运行时间一般是一半一半缩小搜索范围的算法

//ps:理解以后自己写竟然还没跑出来，大概是废惹= =

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        //模仿题解：
         //确保j的合理性
        if(nums1.length>nums2.length){
            int[] tmp=nums2; nums2=nums1; nums1=tmp;
        }
        int maxi=nums1.length;
        int mini=0;
        while(maxi>=mini){
            int i=(maxi+mini)/2;
            int j=(nums1.length+nums2.length+1)/2-i;    //一半长度-i   默认条件：一半长度>=1
            if(i<maxi&&nums1[i]<nums2[j-1]){         //确保i!=nums1.length，保证i的合理性，同时j-1也被保证了合理性(nums2.length-x-1)/2>=0; nums2.length-x>=1
                                                     //如果i==maxi，则i值被唯一确定，为解
                mini=i+1;                
            }
            else if(i>mini&&nums1[i-1]>nums2[j]){    //和上一条件项相同
                maxi=i-1;
            }
            else{//如果i被确定
                //左边界 
                //-候选人 max(nums1[i-1],nums2[j-1]) 
                //-考虑存在性 i-1,j-1
                double left=0.0;
                if(i==0) left=nums2[j-1];
                else if(j==0) left=nums1[i-1];
                else left=Math.max(nums1[i-1],nums2[j-1]);
                if((nums1.length+nums2.length)%2==1) return left;
                
                //右边界 min(nums1[i],nums2[j])
                double right=0.0;
                if(i==nums1.length) right=nums2[j];
                else if(j==nums2.length) right=nums1[i];
                else right=Math.min(nums1[i],nums2[j]);
                
                //final result
                return (left+right)/2;
            }           
        }
        return 0.0;

        
        //官方题解：
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
