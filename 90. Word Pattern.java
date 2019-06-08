//Rui Li
//Pro 90 Easy

/*
 Given a pattern and a string str, find if str follows the same pattern.
 
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 
 Example 1:
 
 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true
 Example 2:
 
 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false
 Example 3:
 
 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false
 Example 4:
 
 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        
         //sol1:
         String[] tmp=str.split("\\s");     //creat a string list which is split the original string with ' ', if there are more than one space can use "\\s+" to split the original string.
         HashMap<Character, String> map=new HashMap();   //save the transformation
         if(pattern.length()!=tmp.length){
         return false;
         }
         for(int i=0; i<pattern.length(); i++){
         if(!map.containsKey(pattern.charAt(i))){    //transformation exist
         if(map.containsValue(tmp[i])){          //the reverse transformation is not unique
         return false;
         }
         map.put(pattern.charAt(i), tmp[i]);
         }
         else{
         if(!map.get(pattern.charAt(i)).equals(tmp[i])){     //transformation is not unique
         return false;
         }
         }
         }
         return true;

        
        //sol2:
        char[] chars = pattern.toCharArray();
        char[] strs = str.toCharArray();
        
        Map<Character, String> map = new HashMap<>();
        int step=0, i=0;
        for (i = 0; i < chars.length && step < strs.length; i++) {  //split the word by word by calcualting the step (which means the split method costs lots of time)
            String target = map.get(chars[i]);
            StringBuilder sb = new StringBuilder();
            while (step <= strs.length - 1) {
                char c = strs[step];
                step += 1;
                if (c == ' ') {
                    break;
                }
                sb.append(c);
            }
            String result = sb.toString();
            
            if (target == null) {                                //same as sol1
                if (map.containsValue(result)) {
                    return false;
                }
                map.put(chars[i], result);
            } else if (!target.equals(result)) {
                return false;
            }
        }
        if (step != strs.length || i != chars.length) {
            return false;
        }
        return true;
        
    }
}
