package com.java.test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OfficeParty {
    private static final Scanner scanner = new Scanner(System.in);
    private static LinkedHashMap<Double, Integer> reverseSort(double[] area) {
        LinkedHashMap<Double, Integer> reverseSortedMap = new LinkedHashMap<>();
        LinkedHashMap<Double, Integer> unSortedMap = new LinkedHashMap<>();
        for(double a: area){
            unSortedMap.merge(a, 1, Integer::sum);
        }
        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;
    }

    private static double largestPiece(final int[] radii, final int ng) {
        final int n = radii.length;
        double[] area = new double[n];
        for(int i = 0; i < n; i++) {
            area[i] = (double) Math.round((3.14159265359 * radii[i] * radii[i]) * 10000) / 10000;
        }
        if(area.length == 1) {
            return area[area.length - 1] / ng;
        }
        LinkedHashMap<Double, Integer> reverseSortedMap = reverseSort(area);

        // convert map into arrays
        int[] count_array = new int[reverseSortedMap.size()];
        double[] area_array = new double[reverseSortedMap.size()];
        int j = 0;
        for (Map.Entry<Double, Integer> entry : reverseSortedMap.entrySet()) {
            area_array[j] = entry.getKey();
            count_array[j++] = entry.getValue();
        }

        for(int i = 0; i < area_array.length - 1; i++) {
            if(count_array[i] >= ng)
                return area_array[i];
            else {
                for(j = 1; j <= ng; j++) {
                    double rem_area = area_array[i] / (double) j ;
                    if(area_array[i + 1] > rem_area/2) {
                        int rg = ng - j;
                        if(count_array[i + 1] >= rg) {
                            return Math.min(rem_area, area_array[i + 1]);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        final int n = scanner.nextInt();
        int[] radii = new int[n];
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i = 0; i < n; i++) {
            radii[i] = scanner.nextInt();
        }
        final int numberOfGuests = scanner.nextInt();
        System.out.println(largestPiece(radii, numberOfGuests));
    }
}
