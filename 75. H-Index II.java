//Rui Li
//Pro 275 Medium

/*
 Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/h-index-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

class Solution {
    public int hIndex(int[] citations) {
        //x(h)>=h
        //x(N-h)<=h
        //h==x(n)
        //三种方法时间和内存消耗基本相同，第三种方法和第一种方法基本一致
        
        //sol1:
        int h=0;
        for(int i=citations.length-1; i>=0; i--){
            for(h=citations[i]; i-1>=0&&h>citations[i-1]; h--){  //选取h，因为h可能在前一位和这一位之间，故尝试h,这部可以简化
                if(citations.length-i>=h){  //看选择的h是否满足条件，现在选取的有citations.length-i个的值>=h的，所以看个数>=h
                    return h;
                }
            }
        }        
        return Math.min(h,citations.length);
        
        //sol2: 二分法
        int l=0;
        int r=citations.length-1;
        int le=r;
        while(l<r){
            int mid=(l+r)/2;
            if(citations[mid]==le-mid+1)
                return citations[mid];
            else if(citations[mid]<le-mid+1){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        if(citations.length==0||citations[l]<le-l+1)
            return 0;
        else
            return le-l+1;
        
        
        //sol3: the ideal is basically same as sol1
        int n = 1;
    	for(int i=citations.length-1;i>=0&&citations[i]>=n;i--) {
    		n++;
    	}
    	return n-1;
        

    }
}