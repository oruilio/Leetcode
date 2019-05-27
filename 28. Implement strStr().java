//Rui Li
//Pro 28 Easy

/*
 Implement strStr().
 
 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 
 Example 1:
 
 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:
 
 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:
 
 What should we return when needle is an empty string? This is a great question to ask during an interview.
 
 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 

*/

class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack.equals("")&&needle.equals(""))||needle.equals("")){
            return 0;
        }
        for(int i=0; i<haystack.length(); i++){
            int tmp=i;
            for(int j=0; j<needle.length()&&tmp<haystack.length(); j++){
                if(haystack.charAt(tmp)!=needle.charAt(j)){
                    break;
                }
                if(j==needle.length()-1){
                    return i;
                }
                tmp++;
            }
        }
        return -1;
    }
}
