package cn.az.code.year2021.may;

/**
 * @author az
 * @since 2021-05-10
 */
public class CountPrimes {

    // https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution

    public int countPrimes(int n) {
      if(n <=1 ) return 0;
    
    boolean[] notPrime = new boolean[n];        
    notPrime[0] = true; 
    notPrime[1] = true; 

    for(int i = 2; i < Math.sqrt(n); i++){
        if(!notPrime[i]){
            for(int j = 2; j*i < n; j++){
                notPrime[i*j] = true; 
            }
        }
    }
    
    int count = 0; 
    for(int i = 2; i< notPrime.length; i++){
        if(!notPrime[i]) count++;
    }
    return count; 
    }
}