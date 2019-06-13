//Rui Li
//Pro 245 Medium

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-word-distance-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        
        //sol1：O(n) 遍历数组一遍
        int start=0;
        String last="";
        int res=Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){          //找出第一个word1 or word2作为起点
            if(words[i].equals(word1)||words[i].equals(word2)){
                last=words[i];
                start=i;
                break;
            }
        }
        for(int i=start+1; i<words.length; i++){   
            if(words[i].equals(word1)||words[i].equals(word2)){   //第二个点
                if(!word1.equals(word2)&&!words[i].equals(last)){  //如果两个词不相等，且第二个点遇到的是不同的词，记下此时距离，取更小结果
                    res=Math.min(res,i-start);
                }
                if(word1.equals(word2)&&words[i].equals(word1)){  //如果两个词相等，遇到就算距离，取更小结果
                    res=Math.min(res,i-start);
                }
                start=i;            //节点
                last=words[i];
            }
        }
        return res;  
        
        //sol2: 相当于用hash表分别记录word1和word2的坐标，sol1其实也可以随便用什么表格来记一下
        //用哈希表记录列表中单词出现的索引，当当前单词是word1/word2时，计算最短距离
        Map<String,Integer> map = new HashMap<>();
        int res = words.length;
        for(int i = 0;i < words.length;i++){
            //如果当前元素为word1
            if(words[i].equals(word1) && map.get(word2) != null){
                res = Math.min(res,i-map.get(word2));
            }
            //如果当前元素为word2
            if(words[i].equals(word2) && map.get(word1) != null){
                res = Math.min(res,i-map.get(word1));
            }
            
            map.put(words[i],i);
        }
        return res;
    }
}