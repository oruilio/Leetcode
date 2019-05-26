//Rui Li
//Pro 244

/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 
 !!!!!Your method will be called repeatedly many times with different parameters.
 
Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

class WordDistance {
    
    Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
   
    public WordDistance(String[] words) {
        for(int i=0; i<words.length; i++){
            if(!map.containsKey(words[i])){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i],list);
            }
            else{
                map.get(words[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int res=Integer.MAX_VALUE;
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(res>Math.abs(list1.get(i)-list2.get(j))){
                    res=Math.abs(list1.get(i)-list2.get(j));
                }
            }
        }
        return res;
    }
}


