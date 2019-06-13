//Rui Li
//Pro 277 Medium

/*
 Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

 

Example 1:


Input: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
Example 2:


Input: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
Output: -1
Explanation: There is no celebrity.
 

Note:

The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means person i knows person j while a[i][j] = 0 means the contrary.
Remember that you won't have direct access to the adjacency matrix.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-celebrity
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //sol1:
        boolean[] list=new boolean[n];
        for(int i=0; i<n; i++){      //初始化
            list[i]=true;
        }
        for(int i=0; i<n; i++){
            if(list[i]!=false){        //如果至此所有人都认识i
                for(int j=0; j<n; j++){
                    if(list[j]!=false){      //j还需要判断
                        if(!knows(i,j)||(i!=j&&knows(j,i))){   //j认识任何人||存在人不认识j
                            list[j]=false;
                        }
                    }
                    if(!knows(j,i)||(i!=j&&knows(i,j))){    //i认识任何人||存在人不认识i
                        list[i]=false;           //i判断完毕可以跳出循环
                        break;
                    }                    
                }
                if(list[i]==true){
                    return i;
                }
            }     
        }
        return -1;
        
        //sol2:
        int num=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){                      //除了i自己   
                if(!knows(i,j)&&knows(j,i)){   //有多少人认识i
                    num++;             
                }
                else{
                    break;   //如果i认识任何人就跳出
                } 
                }
            }
            if(num==n-1){return i;}     //如果有n-1个人认识i，则i为celebrity
            else{num=0;}
        }
        return -1;


        //sol3: 表现最佳O(n)
        int cel=0;
        for(int i=0; i<n; i++){            
            if(cel!=i&&knows(cel,i)){      //有人认识则这个人可能为celebrity，【存在人不认识则i必然不是celebrity】
                cel=i;                     //而当前这个人认识其他人所以他不是celebrity 保证除了cel以外其他都不可能为cel
            }
        }
        for(int i=0; i<n; i++){            //确认此人谁都不认识，且所有人都认识他
            if(cel!=i&&(knows(cel,i)||!knows(i,cel))){
                return -1;               
            }
        }
        return cel;
    }
}