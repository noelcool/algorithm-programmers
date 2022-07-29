import java.util.Arrays;

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
 * sorting -> 비교 -> 없으면 마지막 주자
 * */


public class 완주하지못한선수_00 {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for (;i<completion.length; i++)
            if (!participant[i].equals(completion[i]))
                break;


        return participant[i];
    }

    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        완주하지못한선수_00 result = new 완주하지못한선수_00();
        System.out.println(result.solution(part, comp));
    }

}
