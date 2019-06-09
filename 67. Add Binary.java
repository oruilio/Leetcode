//Rui Li
//Pro 67 Easy

/*
 Given two binary strings, return their sum (also a binary string).
 
 The input strings are both non-empty and contains only characters 1 or 0.
 
 Example 1:
 
 Input: a = "11", b = "1"
 Output: "100"
 Example 2:
 
 Input: a = "1010", b = "1011"
 Output: "10101"

*/

class Solution {
    public String addBinary(String a, String b) {
        int tmp=0;
        int sum=0;
        String res="";
        for(int i=1; i<=Math.max(a.length(),b.length()); i++){
            if(a.length()-i>=0&&b.length()-i>=0){
                sum=tmp+(a.charAt(a.length()-i)-'0')+(b.charAt(b.length()-i)-'0');
            }
            else if(b.length()-i<0){
                sum=tmp+(a.charAt(a.length()-i)-'0');
            }
            else if(a.length()-i<0){
                sum=tmp+(b.charAt(b.length()-i)-'0');
            }
            tmp=0;               //as the tmp has been used, clear the content
            if(sum>=2){          //if the sum is bigger
                sum-=2;
                tmp=1;
            }
            res=""+sum+res;
        }
        if(tmp==1){              //如果最后位数溢出，仍有进位，则增加一位
            res=""+tmp+res;
        }
        return res;
    }
}
