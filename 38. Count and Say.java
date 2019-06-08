//Rui Li
//Pro 38 Easy

/*
 The count-and-say sequence is the sequence of integers with the first five terms as following:
 
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 
 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 
 Note: Each term of the sequence of integers will be represented as a string.
 
  
 
 Example 1:
 
 Input: 1
 Output: "1"
 Example 2:
 
 Input: 4
 Output: "1211"
*/

class Solution {
    public String countAndSay(int n) {
        
        
        //sol1:
        String pre=""+1;
        String now="";
        int count=1;
        
        if(n==0){return "";}
        if(n==1){return pre;}
        for(int i=2; i<=n; i++){
            char tmp=pre.charAt(0);             //save the first number
            for(int j=1; j<pre.length(); j++){
                if(pre.charAt(j)!=tmp){         //meet a different number
                    now=now+count+tmp;          //save the count of the previous number
                    count=0;
                    tmp=pre.charAt(j);          //save the different number
                }
                count++;
            }
            now=now+count+tmp;
            pre=now;
            now="";                             //reset all the parameters
            count=1;
        }
        return pre;
        
        
    
         //sol2: (behave much better than sol1 but the main idea is same)
         String str = "1";
         for (int i = 2; i <= n; i++) {
         StringBuilder builder = new StringBuilder();
         char pre = str.charAt(0);
         int count = 1;
         for (int j = 1; j < str.length(); j++) {
         char c = str.charAt(j);
         if (c == pre) {
         count++;
         } else {
         builder.append(count).append(pre);
         pre = c;
         count = 1;
         }
         }
         builder.append(count).append(pre);
         str = builder.toString();
         }
         
         return str;
         
    }
}
