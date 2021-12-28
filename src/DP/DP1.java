package DP;

public class DP1 {

/*

 jeet class discussion

 =====================================0/1 Knapsack Problem=====================================
int maxProft(int[]wt, int[]val,int W, int n){

  if(W==0||n==0)
      return 0;

  if(wt[n-1]<=W){
     return max(val[n-1]+maxProft(wt,val,W-wt[n-1],n-1),maxProfit(wt,val,W,n-1));
  }
  else{
      return maxProfit(wt,val,W,n-1);
  }
}

//TopDown DP
Integer[][] memo = new Integer[n+1][W+1];
int maxProft(int[]wt, int[]val,int W, int n,Integer[][] memo){

  if(W==0||n==0)
      return 0;
  if(memo[n][W]!=null)
      return memo[n][W];

  if(wt[n-1]<=W){
    return memo[n][W] =  max(val[n-1]+maxProft(wt,val,W-wt[n-1],n-1),maxProfit(wt,val,W,n-1));
  }
  else{
     return memo[n][W] = maxProfit(wt,val,W,n-1);
  }
}

//Bottom Up (avoid Recursion) + iteration Dp
int[][] memo = new int[n+1][W+1];
int maxProft(int[]wt, int[]val,int W, int n){
    for(int i=0;i<=n;i++){
       for(int j=0;j<=W;j++){
           if(i==0||j==0)
               memo[i][j]=0;
     }
    }

    for(int i=1;i<=n;i++){
        for(int j=1;j<=W;j++){
            if(wt[i-1]<=W){
                memo[i][j] = Math.max(val[i-1]+memo[i-1][j-wt[i-1]],memo[i-1][j]);
            }
            else
                memo[i][j] = memo[i-1][j];
     }
    }
    return memo[n][W];

}


========Subset sum problem==========
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        if(sum%2!=0)
            return false;
        boolean dp[][] = new boolean[nums.length+1][sum/2+1];
        dp[0][0] = true;
        for(int i=1;i<=nums.length;i++)
            dp[i][0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][sum/2];
    }
}

===========Coin change 2 unbounded knapsack=============
class Solution {
    public int change(int amount, int[] coins) {
        int choices[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            choices[i][0]=1;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j)
                    choices[i][j] = choices[i][j-coins[i-1]]+choices[i-1][j];
                else
                    choices[i][j] = choices[i-1][j];
            }
        }
        return choices[coins.length][amount];
    }
}


=======Longest common subsequence============
int lcs(String x,String y, int m, int n){
    if(m==0 || n==0)
       return 0;

   if(x.charAt(m-1)==y.charAt(n-1))
      return 1+lcs(x,y,m-1,n-1);

    else
     return Math.max(lcs(x,y,m-1,n),lcs(x,y,m,n-1));
}


========Top down approach============:


int lcs(String x,String y, int m, int n){
Integer[][] dp = new Integer[m+1][n+1];
   return lcsHelper(x,y,m,n,dp);
}

int lcsHelper(String x, String y, int m,int n, Integer[][] dp){
 if(m==0 || n==0)
       return 0;

 if(dp[m][n]!=null)
    return dp[m][n];

  if(x.charAt(m-1)==y.charAt(n-1))
      return dp[m][n] = 1+lcs(x,y,m-1,n-1,dp);

    else
     return dp[m][n] = Math.max(lcs(x,y,m-1,n,dp),lcs(x,y,m,n-1,dp));

}

===========Bottom Up Approach=====================
int lcs(String x,String y, int m,int n){
int dp[][] = new int[m+1][n+1];
for(int i=0;i<=m;i++){
   for(int j=0;j<=n;j++){
     if(i==0||j==0)
       dp[i][j]=0;

       if(x.charAt(i-1)==y.charAt(j-1))
         dp[i][j] = 1+dp[i-1][j-1];
        else
        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
    }
   }
return dp[m][n];
}




*/

}
