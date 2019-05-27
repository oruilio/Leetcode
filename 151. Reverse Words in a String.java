//Rui Li
//Pro 151 Medium

/*
 Given an input string, reverse the string word by word.
 
 
 
 Example 1:
 
 Input: "the sky is blue"
 Output: "blue is sky the"
 Example 2:
 
 Input: "  hello world!  "
 Output: "world! hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:
 
 Input: "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

class Solution {
    public String reverseWords(String s) {
        /*
         //sol1:
         ArrayList<String> list=new ArrayList<String>();
         int start=0;
         int end=0;
         if(s.length()==0){return "";}
         if(s.charAt(0)!=' '){
         start=0;
         }
         for(int i=1; i<s.length(); i++){
         if(s.charAt(i-1)==' '&&s.charAt(i)!=' '){
         start=i;
         }
         if(s.charAt(i-1)!=' '&&s.charAt(i)==' '){
         end=i;
         list.add(s.substring(start,end));
         }
         }
         if(s.charAt(s.length()-1)!=' '){
         list.add(s.substring(start,s.length()));
         }
         String res="";
         for(int i=list.size()-1; i>=0; i--){
         if(i!=0){res=res+list.get(i)+" ";}
         else{res=res+list.get(i);}
         }
         return res;
         */
        
        //sol2:
        StringBuilder sb = new StringBuilder();
        
        if(s == null || "".equals(s.trim())){
            return "";
        }
        String[] strs = s.trim().split("\\s+");//trim()去除首末的空格，再分隔即可。split("\\s+")代表以一个或多个空格来分隔字符串，这样分隔出来的数组中就不会有空格存在了。
        for(int i =strs.length-1;i>=0;i--){
            if(i!=0){
                sb.append(strs[i].trim()+" ");
            }else{
                sb.append(strs[i].trim());
            }
        }
        return sb.toString();
    }
}
