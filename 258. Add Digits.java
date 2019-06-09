//Rui Li
//Pro 287 Medium

/*
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 
 Example:
 
 Input: 38
 Output: 2
 Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
              Since 2 has only one digit, return it.
 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 
*/

class Solution {
    public int addDigits(int num) {
        /*
         //sol1:暴力法，超过了时间限制
         String tmp=""+num;
         while(tmp.length()>1){
         for(int i=0; i<tmp.length(); i++){
         num+=tmp.charAt(i)-'0';
         }
         tmp=""+num;
         }
         return num;
         */
        
        //假设一个三位数整数n=100*a+10*b+c,变化后addn=a+b+c； 两者的差值n-addn=99a+9b，差值可以被9整除，说明每次缩小9的倍数 那么我们可以对res=num%9，若不为0则返回res，为0则返回9
        //sol2: 找规律
        if(num==0){return 0;}
        return num%9==0?9:num%9;   //直到最终不能被9整除。
    }
}
