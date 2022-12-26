import java.util.Scanner;

public class AllSum4 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[M +1];

        for(int i = 1; i<=M; i++){
            arr[i] = arr[i-1] + sc.nextInt();
        }

        for(int j = 0; j < M; j++){
            int firstIndex = sc.nextInt();
            int secondIndex = sc.nextInt();
            System.out.println(arr[secondIndex] - arr[firstIndex-1]);
        }


    }
}
