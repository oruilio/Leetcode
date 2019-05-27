//Rui Li
//Pro 387 Easy

/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 
 Examples:
 
 s = "leetcode"
 return 0.
 
 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        boolean rep=false;
        if(s.length()==1){return 0;}
        if(s.length()==0){return -1;}
        for(int i=0; i<s.length(); i++){
            rep=false;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)&&i!=j){
                    rep=true;
                    break;
                }
            }
            if(!rep){
                return i;
            }
        }
        return -1;
    }
}
