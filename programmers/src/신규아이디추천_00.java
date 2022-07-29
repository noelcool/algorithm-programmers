import java.util.Locale;

/**
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 *
 * 아이디 길이는 3자 이상 15자 이하
 * 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표만 사용 가능
 * 마침표는 처음과 끝에 사용할 수 없으며 연속된 사용 불가능
 *
 * */
public class 신규아이디추천_00 {

    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();


        for(int i=0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                answer += ch;
            }
        }

        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        if(!answer.isEmpty() && answer.charAt(0) == '.')
            answer = answer.substring(1);
        if(!answer.isEmpty() && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);

        if(answer.isEmpty())
            answer = "a";

        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1) == '.')
                answer = answer.substring(0, answer.length()-1);
        }

        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        신규아이디추천_00 sol = new 신규아이디추천_00();
        System.out.println(sol.solution("...!@baT#*..y.abcdefghijklm"));
    }
}
