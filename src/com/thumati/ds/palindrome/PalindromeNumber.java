package com.thumati.ds.palindrome;

public class PalindromeNumber {
    public static void main(String[] args) {
        int[] arr = {719, 9350539, 15051, 123456};

        for(int n : arr){
            int sum = 0;
            int a = n;
            while(a>0){
                int lastDigit = a%10;
                sum = sum*10 + lastDigit;
                a = a/10;
            }
            String result = (n==sum)?n+" is a palindrome":n+" is not a palindrome";
            System.out.println(result);
        }
    }
}
