import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeMoney {
    public static void main(String[] args) throws IOException {
        int[] collectMoney = {500,100,50,10};

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("거스름돈에 최소 갯수를 구하세요");
        System.out.println("거슬러야할 금액을 입력해주세요.");
        int requestMoney = Integer.parseInt(bf.readLine()); //Int

        int count = 0;

        for(int money : collectMoney){
            count += requestMoney / money;
            requestMoney = requestMoney % money;
        }
        System.out.println(count);


    }
}
