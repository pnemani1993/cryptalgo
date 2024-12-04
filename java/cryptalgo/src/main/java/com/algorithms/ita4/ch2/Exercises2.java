package com.algorithms.ita4.ch2;

import java.util.Arrays;

public class Exercises2 {
    
    public byte[] addBinaryIntegers(byte[] a, byte[] b, int n){
        byte[] c = new byte[n + 1];
        byte carry = 0;
        for(int i = n - 1; i >= 0; i--){
            c[i+1] = (byte) ((byte)((byte)a[i])^((byte)b[i])^(carry));
            carry = (byte)((a[i]&b[i])|carry);
        }
        c[0] = carry;
        return c;
    }

    public static void main(String[] args) {
        Exercises2 ex = new Exercises2();
        byte[] a1 = new byte[]{1,0,1,1,1};
        byte[] a2 = new byte[]{1,1,0,0,1};
        System.out.println(Arrays.toString(ex.addBinaryIntegers(a1, a2, 5)));
    }
}

