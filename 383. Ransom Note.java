//Rui Li
//Pro 383 Easy

/*
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 
 Each letter in the magazine string can only be used once in your ransom note.
 
 Note:
 You may assume that both strings contain only lowercase letters.
 
 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
         //sol1:
         char[] mag=magazine.toCharArray();
         char[] ran=ransomNote.toCharArray();
         Arrays.sort(mag);
         Arrays.sort(ran);
         if(mag.length<ran.length){return false;}
         int start=0;
         boolean con=false;
         for(int i=0; i<ran.length;i++){
         con=false;
         for(int j=start; j<mag.length; j++){
         if(ran[i]==mag[j]){
         con=true;
         start=j+1;
         break;
         }
         }
         if(!con){
         return false;
         }
         }
         return true;
         */
        
        //sol2:
        int[] m = new int[26];
        for (int i = 0; i < magazine.length(); ++i){
            m[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); ++i){
            if (m[ransomNote.charAt(i)-'a']-- <= 0) return false;
        }
        return true;
        
    }
}
