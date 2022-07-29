import java.util.*;
import java.util.stream.Collectors;

/**
 * order 정렬 -> 코스 길이 별 조합 생성 -> 가장 많은 조합 저장
 *
 * 조합을 만들 때는 정렬을 고려
 * HashMap의 기본 형태는 Name:Count
 * 재귀 - 탈출조건 + 수행동작
 *
 * */
public class 메뉴리뉴얼_00 {

    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        // order 정렬
        for(int i=0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // order 를 기준으로 코스 길이 만큼의 조합 만들기
        for(int courseLength : course) {
            for(String order : orders) {
                combination("", order, courseLength);
            }
            if(!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);
                if(max > 1) {
                    for(String key : hashMap.keySet()) {
                        if(hashMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();
            }
        }


        // 가장 많은 조합을 저장
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public void combination(String order, String others, int count) {
        // 탈출 조건
        if(count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0)+1);
            return;
        }
        // 수행 동작
        for(int i=0; i<others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i+1), count - 1);
        }
    }

    public static void main(String[] args) {

        메뉴리뉴얼_00 sol = new 메뉴리뉴얼_00();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(sol.solution(orders, course));

    }
}
