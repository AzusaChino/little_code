package cn.az.code.year2020.oct;

public class BitwiseComplement {

     public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X << 2 + 1;
        return N ^ X;
    }
}