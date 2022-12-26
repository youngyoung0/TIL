import java.util.Scanner;

public class TwoDimensionalArrySum {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][M+1];

        for(int i=1; i<=N; i++ ){
            for(int j=1; j<= M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        for(int i=0; i<k; i++ ){
            int sum = 0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int j = x1; j<=x2; j ++){
                for(int z = y1; z<=y2; z++){
                    sum += arr[j][z];
                }
            }
            System.out.println(sum);

        }
        sc.close();
    }
}

