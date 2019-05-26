//Rui Li
//Pro 243

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)||words[i].equals(word2)){
                String tmp=words[i];
                int dis=1;
                for(int j=i+1; j<words.length; j++){
                  if(words[j].equals(word1)||words[j].equals(word2)){
                      if(words[j].equals(tmp)){
                          dis=1;
                      }
                      else{
                        if(dis<res){
                           res=dis;
                        }
                      }
                  }
                  else{
                      dis++;
                  }
                }      
            }
        }
        return res;
    }
}