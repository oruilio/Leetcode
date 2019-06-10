//Rui Li
//Pro 367 Easy

/*
 Given a positive integer num, write a function which returns True if num is a perfect square else False.
 
 Note: Do not use any built-in library function such as sqrt.
 
 Example 1:
 
 Input: 16
 Output: true
 Example 2:
 
 Input: 14
 Output: false
 
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-perfect-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
*/


class Solution {
    public boolean isPerfectSquare(int num) {
        
        //n的平方根不会大于n/2+1
        //sol1:
        for(long i=0; i<=num/2+1; i++){
            if(i*i<=num&&(i+1)*(i+1)>num){
                if(i*i==num){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
        /*
         //sol2:
         //利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
         int sum=0;
         for(long i=1; i<=num; i=i+2){
         sum+=i;
         if(sum==num){return true;}
         }
         return false;
         */
        
    }
}
