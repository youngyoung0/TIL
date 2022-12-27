import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PianoGymnastics {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N+1];
        int[] sum = new int[N+1];

        String[] level = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
           arrN[i] = Integer.parseInt(level[i-1]);
           if(arrN[i-1] > arrN[i]){
               sum[i] += sum[i-1]+1;
           }else{
               sum[i] = sum[i-1];
           }
        }
        int Q = Integer.parseInt(br.readLine());
        int mistake = 0;
        for(int j=0; j<Q; j++){
            String[] index = br.readLine().split(" ");
            int start = Integer.parseInt(index[0]);
            int end = Integer.parseInt(index[1]);
            mistake = sum[end] - sum[start];
            System.out.println(mistake);
        }
    }
}

