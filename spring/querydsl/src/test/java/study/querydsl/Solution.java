package study.querydsl;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    @Test
    public void solution() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = bf.readLine();

        String[] arr = n.split(" ");

        for(int i = 0; i < arr.length; i++){
            String str = "";
            for(int j = arr[i].length() - 1; j >= 0; j--){
                str += arr[i].charAt(j);
            }
            arr[i] = str;
            sb.append(arr[i] + " ");
        }

    }
}
