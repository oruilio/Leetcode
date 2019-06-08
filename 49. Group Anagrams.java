//Rui Li
//Pro 49 Medium

/*
 Given an array of strings, group anagrams together.
 
 Example:
 
 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:
 
 All inputs will be in lowercase.
 The order of your output does not matter.
 
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //sol1:
        Map<String, ArrayList<String>> map=new HashMap();    //<pattern, the words suit the pattern>
        ArrayList<List<String>> res=new ArrayList();
        for(int i=0; i<strs.length; i++){
            char[] tmp=strs[i].toCharArray();
            Arrays.sort(tmp);
            String str = String.valueOf(tmp);                //check the pattern for each word
            if(!map.containsKey(str)){                       //whether the pattern suits the exits ones
                ArrayList<String> list=new ArrayList();
                //list.add(strs[i]);
                map.put(str, list);
            }
            //else{
            map.get(str).add(strs[i]);                   //update the words list for the pattern
            //}
        }
        
        for(String s: map.keySet()){                         //get the answer
            res.add(map.get(s));
        }
        
        return res;
        
        
        /*
         //sol2: (the idea is totally same as sol1)
         if (strs.length == 0) return new ArrayList();
         Map<String, List> ans = new HashMap<String, List>();
         for (String s : strs) {
         char[] ca = s.toCharArray();
         Arrays.sort(ca);
         String key = String.valueOf(ca);
         if (!ans.containsKey(key)) ans.put(key, new ArrayList());
         ans.get(key).add(s);
         }
         return new ArrayList(ans.values());
         */
        
        //sol3:(use the number of each letters' occurance as the pattern)
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;  //get the letters occurences
            
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {                    //get the list of times of the occurences
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();                       //get the list to string
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
        
    }
}
