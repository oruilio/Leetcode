//Rui Li
//Pro 246 Easy

/*
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 
 Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 
 Example 1:
 
 Input:  "69"
 Output: true
 Example 2:
 
 Input:  "88"
 Output: true
 Example 3:
 
 Input:  "962"
 Output: false

*/

class Solution {
    public boolean isStrobogrammatic(String num) {
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i)=='2'             //if these number exits, false
               ||num.charAt(i)=='3'
               ||num.charAt(i)=='4'
               ||num.charAt(i)=='5'
               ||num.charAt(i)=='7'){
                return false;
            }
            if(num.charAt(i)=='0'             //strobogrammatic number
               ||num.charAt(i)=='1'
               ||num.charAt(i)=='8'){
                if(num.charAt(num.length()-1-i)!=num.charAt(i)){
                    return false;
                }
            }
            if(num.charAt(i)=='6'){          //specific 6
                if(num.charAt(num.length()-1-i)!='9'){
                    return false;
                }
            }
            if(num.charAt(i)=='9'){          //specific 9
                if(num.charAt(num.length()-1-i)!='6'){
                    return false;
                }
            }
        }
        return true;
    }
}
