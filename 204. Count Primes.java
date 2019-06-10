//Rui Li
//Pro 204 Easy

/*
 Count the number of prime numbers less than a non-negative number, n.
 
 Example:
 
 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-primes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
*/


class Solution {
    public int countPrimes(int n) {
         /*
         //sol1: 超时
         if(n<=2){return 0;}
         if(n==3){return 1;}
         ArrayList<Integer> list=new ArrayList<>();
         list.add(2);
         list.add(3);
         boolean prime=true;
         for(int i=4; i<n; i++){
         for(int j=0; j<list.size(); j++){
         if(i%list.get(j)==0){
         prime=false;
         break;
         }
         }
         if(prime){
         list.add(i);
         }
         prime=true;
         }
         return list.size();
         */
        
        //sol2: 厄拉多塞筛法. 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
        boolean [] notPrim = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
            if (notPrim[i] == false) {
                count++;
                for (int j = 2; j*i < n; j++) {
                    notPrim[j*i] = true;
                }
            }
        }
        return count;
        
    }
}
