//Rui Li
//Pro 12 Medium

/*
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 
 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 
 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 
 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 
 Example 1:
 
 Input: 3
 Output: "III"
 Example 2:
 
 Input: 4
 Output: "IV"
 Example 3:
 
 Input: 9
 Output: "IX"
 Example 4:
 
 Input: 58
 Output: "LVIII"
 Explanation: L = 50, V = 5, III = 3.
 Example 5:
 
 Input: 1994
 Output: "MCMXCIV"
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
*/

class Solution {
    public String intToRoman(int num) {
        //sol1: 纯手工算法：）
        String res="";
        while(num>0){
            if(num>=1000){
                res+='M';
                num-=1000;
            }
            else if(num>=900){
                res+="CM";
                num-=900;
            }
            else if(num>=500){
                res+='D';
                num-=500;
            }
            else if(num>=400){
                res+="CD";
                num-=400;
            }
            else if(num>=100){
                res+='C';
                num-=100;
            }
            else if(num>=90){
                res+="XC";
                num-=90;
            }
            else if(num>=50){
                res+='L';
                num-=50;
            }
            else if(num>=40){
                res+="XL";
                num-=40;
            }
            else if(num>=10){
                res+='X';
                num-=10;
            }
            else if(num>=9){
                res+="IX";
                num-=9;
            }
            else if(num>=5){
                res+='V';
                num-=5;
            }
            else if(num>=4){
                res+="IV";
                num-=4;
            }
            else if(num>=1){
                res+='I';
                num-=1;
            }
        }
        return res;
        
        
        //sol2: same idea with sol1, but use two array with less things to write
        int values[]=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String strs[]=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String str="";
        for(int i=0; i<13; i++){
            if(num==0)
                break;
            int times=num/values[i];     //calculate how many letter will be used
            if(times==0)
                continue;
            for(int t=0;t<times;t++)     //add same element to result
            {
                str+=strs[i];
            }
            num=num-(times*values[i]);   //substract the added element
        }
        return str;
        
        //sol3: different idea
        List<String> list = new ArrayList<>();   //save all the romans
        list.add("I");//1
        list.add("V");//5
        list.add("X");//10
        list.add("L");//50
        list.add("C");//100
        list.add("D");//500
        list.add("M");//1000
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num % 5 == 4) {                   //special cases 4,9
                sb.insert(0, list.get(pos + num % 10 / 5 + 1));
                sb.insert(0, list.get(pos));
            } else {                             //common cases
                for (int i = num % 5; i > 0; i--) {
                    sb.insert(0, list.get(pos));
                }
                if (num % 10 > 4) {
                    sb.insert(0, list.get(pos + 1));
                }
            }
            num /= 10;
            pos += 2;
        }
        return sb.toString();
    }
}
