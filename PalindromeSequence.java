package com.java.test;

import java.util.Scanner;

public class PalindromeSequence {
    private static final Scanner scanner = new Scanner(System.in);

    private static int countPalindrome(String str)
    {
        int n = str.length();

        int[][] paliArray = new int[n+1][n+1];

        for (int i = 0; i < n; i++)
            paliArray[i][i] = 1;

        for (int j=2; j<=n; j++)
        {
            for (int i = 0; i < n; i++)
            {
                int k = j + i - 1;
                if (k < n){
                    if (str.charAt(i) == str.charAt(k))
                        paliArray[i][k] = paliArray[i][k-1] + paliArray[i+1][k] + 1;
                    else
                        paliArray[i][k] = paliArray[i][k-1] + paliArray[i+1][k] - paliArray[i+1][k-1];
                }
            }
        }

        return paliArray[0][n-1];
    }

    public static void main(String[] args)
    {
        System.out.println("Total : "+ countPalindrome(scanner.next()));
    }

}
