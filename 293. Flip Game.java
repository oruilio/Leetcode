//Rui Li
//Pro 293 Easy

/*
 You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 
 Write a function to compute all possible states of the string after one valid move.
 
 Example:
 
 Input: s = "++++"
 Output:
 [
 "--++",
 "+--+",
 "++--"
 ]
 Note: If there is no valid move, return an empty list [].
 
*/

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> res = new ArrayList<String>();
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
                StringBuilder strBuilder = new StringBuilder(s);  //new method!!!!
                strBuilder.setCharAt(i, '-');
                strBuilder.setCharAt(i+1, '-');
                String str=strBuilder.toString();
                res.add(str);
            }
        }
        return res;
    }
}
