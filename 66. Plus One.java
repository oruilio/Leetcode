//Rui Li
//Pro 287 Medium

/*
 Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 
 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 
 You may assume the integer does not contain any leading zero, except the number 0 itself.
 
 Example 1:
 
 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:
 
 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        /*
         //sol1:
         //这一段可以不要
         if(digits[digits.length-1]!=9){     //the most common cases: if the last digit is not 9, then just plus one on the last digit is enough
         digits[digits.length-1]++;
         return digits;
         }
         */
        int i=0;
        while(digits.length-1-i>=0&&digits[digits.length-1-i]==9){   //special case (meet 9): from the last digit 如果是9， 就变成0，然后前面的一位变成最后一位（判断是否为9；如果不是9，跳出循环
            digits[digits.length-1-i]=0;
            i++;
        }
        if(i==digits.length){    //如果遍历整个digits array都是9， 那么需要添加一位，前面变为1
            int[] res=new int[digits.length+1];
            res[0]=1;
            System.arraycopy(res, 1, digits, 0, digits.length);
            return res;
        }
        else{                    //如果中途跳出，就直接在跳出的那一位+1
            digits[digits.length-1-i]++;
            return digits;
        }
        
        //sol2:
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;     //if the digits is 10
            if (digits[i] != 0) return digits;  //if is 10, transform to 0
        }
        digits = new int[digits.length + 1];    //如果可以到这里，说明后面全是0了，所以这里要进位，多加一位
        digits[0] = 1;
        return digits;
        
    }
}
