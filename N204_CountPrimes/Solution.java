package N204_CountPrimes;

import java.util.Map;

/**
 * Created by srx on 2019/1/3.
 */
public class Solution {
    public int countPrimes(int n) {
        if (n<=2)
            return 0;
        int rt = 0;
        for (int i = 2;i<n;i++){
            if (isPrime(i)==true){
                rt++;
            }
        }
        return rt;
    }
    public boolean isPrime(int n){
        if (n==2 || n==3)
            return true;
        for (int i = 2;i<= Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
    public int dp(int n){
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(1500000));
        System.out.print(s.dp(1500000));
    }
}
