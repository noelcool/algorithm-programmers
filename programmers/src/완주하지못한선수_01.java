import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 수 많은 마라톤 선수들이 마라톤에 참여했다,
 * 단 한명의 선수를 제외하고 모든 선수가 마라톤을 완주했다
 * 완주하지 못한 선수를 찾아라
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때
 * 완주하지 못한 선수의 이름을 return 하라
 *
 * 선수의 수는 1명 이상 10만명 이하
 * completion의 길이는 participant의 길이보다 1 작다
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있다
 * 동명이인이 있을 수 있다
 *
 * participant = {"leo", "kiki", "eden"}
 * completion = {"eden", "kiki"}
 * return = "leo"
 *
 * Hash 만들기 -> Hash 빼기 -> 마지막 주자
 * */


public class 완주하지못한선수_01 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }

//        for(String key : map.keySet()) {
//            if(map.get(key) != 0) {
//                answer = key;
//                break;
//            }
//        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        완주하지못한선수_01 result = new 완주하지못한선수_01();
        System.out.println(result.solution(part, comp));
    }

}
