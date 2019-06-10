//Rui Li
//Pro 365 Easy

/*
 You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 
 If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 
 Operations allowed:
 
 Fill any of the jugs completely with water.
 Empty any of the jugs.
 Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 Example 1: (From the famous "Die Hard" example)
 
 Input: x = 3, y = 5, z = 4
 Output: True
 Example 2:
 
 Input: x = 2, y = 6, z = 5
 Output: False
 
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
*/


class Solution {
    //sol1:
    //找到最小的倒水量(recursive)
    //最大公约数的求法
    public int gcd(int p,int q)
    {
        if(p==0)return q;
        int r=q%p;     //r<q 舍去大值
        return gcd(r,p);
    }
    
    public boolean canMeasureWater(int x, int y, int z) {        
        if(x+y<z)return false;                //special cases
        if(x==z || y==z || x+y==z) return true;
        return z%gcd(x,y)==0;
        
    }
}

//sol2:
//根据题得公式ax+by=z 或 ay+bx=z，已知x, y, z 求得是否存在a, b使得等式成立。a, b 最大为 x, y, z中的最大值。
/*
 class Solution:
 def canMeasureWater(self, x: int, y: int, z: int) -> bool:
 if z == 0:
 return True
 if x+y < z:
 return False
 if x<y:
 x, y = y, x
 for i in range(max(x,z)+1):
 if y == 0:
 if x == z:
 return True
 return False
 if (z - x*i) % y == 0:
 return True
 return False
 */

