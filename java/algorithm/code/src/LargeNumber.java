import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LargeNumber {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 제일 큰수와 두번째로 큰수
        int first = arr[n - 1];
        int second = arr[n - 2];

        int result = 0;
        int index = 0;
        for(int j = 0; j<m; j++){
            if(index == k){
                index =0;
                result += second;
            }else if (index != k){
                index++;
                result += first;
            }
        }
        System.out.println(result);
    }
}
