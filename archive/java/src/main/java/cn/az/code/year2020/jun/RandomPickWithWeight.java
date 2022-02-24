package cn.az.code.year2020.jun;

import java.util.Arrays;

public class RandomPickWithWeight {

    private double[] probabilities;

    public void solution(int[] w) {
        double sum = 0;
        this.probabilities = new double[w.length];
        for(int weight : w) {
            sum += weight;
        }
        for(int i = 0; i < w.length; i++){
            w[i] += (i == 0) ? 0 : w[i - 1];
            probabilities[i] = w[i]/sum;
        }
    }

    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
    }
}
