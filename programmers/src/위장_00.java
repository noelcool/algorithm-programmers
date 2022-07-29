import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 얼굴, 상의, 하의, 겉옥 목록이 주어진다
 * 매일 다른 옷을 조합하여 위장한다
 *
 * clothes의 각 행은 의상의 이름, 의상의 종류로 이루어져 있다
 * 의상의 수는 1개 이상 30개 이하이다
 * 같은 이름을 가진 의상은 없다
 * 모든 문자열의 길이는 1이상 20이하인 자연수이며 알파벳 소문자 또는 _ 로만 이루어져 있다
 * 하루에 최소 한개의 의상을 입는다
 *
 * [
 *  ["yellowhat", "headgear"],
 *  ["bluesunglasses", "eyewear"],
 *  ["green_turban", "headgear"]
 * ]
 *
 * 종류별로 분류 - 입지 않는 경우 추가 - 전체 조합
 * */


public class 위장_00 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String [] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        위장_00 sol = new 위장_00();
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(sol.solution(clothes));
    }
}
