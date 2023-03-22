package start.hellospring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    @Test
    void 완주하지_못한_선수(){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for(int i =0; i < participant.length; i++){
            if(i == participant.length){
                answer = participant[i];
                break;
            } else if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
    }

    @Test
    void 전화번호_목록(){
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length; i++){
            if(i == phone_book.length){
                break;
            }else if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        for(String phone : phone_book){
            System.out.println(phone);
        }
        System.out.println(answer);
    }

    @Test
    void test(){
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = clothes.length;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i< clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0) + 1);
        }
        if(map.size() >1){
            int count = 1;
            for(String key : map.keySet()){
                count *= map.get(key)+1;
            }
            count--;
            answer = count;
        }
        System.out.println(answer);
    }

    @Test
    void K번째수(){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = new int[commands.length];

        for(int a = 0; a < commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] temp = new int[j - i + 1];
            int count = 0;
            for(int b= i-1; b <= j-1; b++){
                temp[count] = array[b];
                count ++;
            }
            Arrays.sort(temp);
            result[a] = temp[k-1];
        }
    }

    @Test
    void 스코빌지수(){
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 2
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = -1;
        for(int i=0; i < scoville.length-1; i++){
            int hot =scoville[i] + ( scoville[i+1] * scoville[i+1]);
            if(hot >= K){
                answer = i +1;
                break;
            }else{
                scoville[i+1] = hot;
            }
        }
        System.out.println(answer);
    }

    @Test
    void 카드뭉치(){
        String[] cards1 = {"i","drink", "water" };
        String[] cards2 = {"want", "to"};

        ArrayList<String> card1Array= new ArrayList<>(Arrays.asList(cards1));
        ArrayList<String> card2Array= new ArrayList<>(Arrays.asList(cards2));
        String[] goals = {"i", "want", "to", "drink", "water"};
        String answer = "Yes";
        for(int i=0; i<goals.length; i++){
            String goal = goals[i];
            System.out.println(goal);
            if(!card1Array.isEmpty() && card1Array.get(0).equals(goal)){
                card1Array.remove(0);
            }else if(!card2Array.isEmpty() && card2Array.get(0).equals(goal)){
                card2Array.remove(0);
            }else{
                answer = "No";
                break;
            }
        }
        System.out.println(answer);


    }

    @Test
    void 둘만의_암호(){
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        char[] sCharArray = s.toCharArray();
        for(char c: sCharArray ){
            System.out.println(Character.valueOf(c+5));
        }
    }

}
