//Rui Li
//Pro 205 Easy

/*
 Given an unsorted integer array, find the smallest missing positive integer.
 
 Example 1:
 
 Input: [1,2,0]
 Output: 3
 Example 2:
 
 Input: [3,4,-1,1]
 Output: 2
 Example 3:
 
 Input: [7,8,9,11,12]
 Output: 1
 Note:
 
 Your algorithm should run in O(n) time and uses constant extra space.Given two strings s and t, determine if they are isomorphic.
 
 Two strings are isomorphic if the characters in s can be replaced to get t.
 
 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 
 Example 1:
 
 Input: s = "egg", t = "add"
 Output: true
 Example 2:
 
 Input: s = "foo", t = "bar"
 Output: false
 Example 3:
 
 Input: s = "paper", t = "title"
 Output: true
 Note:
 You may assume both s and t have the same length.
 

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){      //if different length, return false
            return false;
        }
        HashMap<Character, Character> map=new HashMap<>();     //transform map<letter in s, letter in t>
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){            //if the letter haven't been considered
                if(map.containsValue(t.charAt(i))){       //the transformed value exists return false
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));        //put the transform in map
            }
            else{                                         //if the transform exist
                if(map.get(s.charAt(i))!=t.charAt(i)){    //if the transform is different return false.
                    return false;
                }
            }
        }
        
        return true;
    }
}
