//Rui Li
//Pro 168 Easy

/*
 Given a column title as appear in an Excel sheet, return its corresponding column number.
 
 For example:
 
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 Example 1:
 
 Input: "A"
 Output: 1
 Example 2:
 
 Input: "AB"
 Output: 28
 Example 3:
 
 Input: "ZY"
 Output: 701
 
*/
class Solution {
    public int titleToNumber(String s) {
        /*
         //sol1:
         if(s.equals("")){return 0;}
         int n=s.length();
         int res=0;
         int i=1;
         while(i<=n){
         int tmp=(int)Math.pow(26.0,n-i);
         res=(s.charAt(i-1)-'A'+1)*tmp+res;
         i++;
         }
         return res;
         */
        
        
        //sol2:   (直接从前往后，前面的答案直接*26， 不需要算pow，the idea is basically same as sol1, but faster and use less memory)
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
