//Rui Li
//Pro 242 Easy

/*
 Given two strings s and t , write a function to determine if t is an anagram of s.
 
 Example 1:
 
 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:
 
 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.
 
 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        /*
         if(s.length()!=t.length()){
         return false;
         }
         char[] arrS=s.toCharArray();       //transform to strings to arrays
         char[] arrT=t.toCharArray();
         Arrays.sort(arrS);
         Arrays.sort(arrT);                 //sort the arrays
         
         //sol1:
         for(int i=0; i<arrS.length; i++){  //check whether the arrays are same(the letters are same with same occurence)
         if(arrS[i]!=arrT[i]){
         return false;
         }
         }
         return true;
         
         
         //sol2:   (cost more time than sol1)
         String str1 = String.valueOf(arrS);
         String str2 = String.valueOf(arrT);
         if(str1.equals(str2)){
         return true;
         }
         return false;
         */
        
        //sol3:  (cost leat time and memory)
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];                //get a chart for 26 letters
        for(int i = 0; i< s.length(); i++) {      //calculate each letter's occurence
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;          // 0 should be the final result
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
        
        /*
         *************NOTE************
         // String转char[]
         String str = "Hello World!";
         char[] cs = str.toCharArray();
         for (char c : cs)
         System.out.print(c);
         System.out.println();
         
         // char[] 类型转String类型
         char[] cs2 = { 'I', 'L', 'o', 'v', 'e', 'C', 'o', 'd', 'e' };
         String str2 = String.valueOf(cs2);
         System.out.println(str2);
         
         OUTPUT:
         Hello World!
         ILoveCode
         */
    }
}
