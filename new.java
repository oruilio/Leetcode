//Rui Li
//Pro 69 Easy

/*
 Implement int sqrt(int x).
 
 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 
 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 
 Example 1:
 
 Input: 4
 Output: 2
 Example 2:
 
 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
              the decimal part is truncated, 2 is returned.
 
*/


class Solution {
    public int mySqrt(int x) {
        //sol1:
        for(long i=0; i<=x; i++){
            if(i*i<=x&&(i+1)*(i+1)>x){
                return (int)i;
            }
        }
        return -1;
    }
}


//sol2:

//下面这种方法可以很有效地求出根号:首先随便猜一个近似值x,然后不断令x等于x和a/x的平均数，迭代个六七次后 x的值就已经相当精确了。

//https://leetcode-cn.com/problems/two-sum/solution/niu-dun-die-dai-fa-by-loafer/

class Solution {
    int s;
    
    public int mySqrt(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }
    
    public double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        }
        else {
            return sqrts(res);
        }
    }
}

