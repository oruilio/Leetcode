//Rui Li
//Pro 14 Easy

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 
 If there is no common prefix, return an empty string "".
 
 Example 1:
 
 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:
 
 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:
 
 All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res="";
        if(strs.length==0){return res;}
        for(int i=0; i<strs[0].length(); i++){
            for(int j=0; j<strs.length; j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i)){
                    return res;
                }
            }
            res=res+strs[0].charAt(i);
        }
        return res;
    }
}
