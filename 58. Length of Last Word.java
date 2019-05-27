//Rui Li
//Pro 58 Easy

/*
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 
 If the last word does not exist, return 0.
 
 Note: A word is defined as a character sequence consists of non-space characters only.
 
 Example:
 
 Input: "Hello World"
 Output: 5
*/

class Solution {
    public int lengthOfLastWord(String s) {
        boolean start=false;
        int num=0;
        if(s.length()==0){return 0;}
        for(int i=s.length()-1; i>=0; i--){
            if(!start&&s.charAt(i)!=' '){
                start=true;
            }
            if(start){
                num++;
                if(s.charAt(i)==' '){
                    return num-1;
                }
            }
        }
        return num;
    }
}
