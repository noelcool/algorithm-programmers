import java.util.Arrays;
import java.util.HashMap;

/**
 * 전화번호웨 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하기
 *
 * 접두어면 False, 아니면 True
 * 전화번호를 담은 배열 phone_book이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접우어인 경우가 있으면 false를 그렇지 않으면 true를 리턴
 *
 * 전화번호부의 길이는 1 이상 1000000 이하
 * 각 전화번호의 길이는 1이상 20 이하
 * 중복된 전화번호는 없다
 * */

public class 전화번호목록_01 {

    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        for(int i=0; i<phone_book.length; i++) {
            for(int j=1; i<phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        전화번호목록_01 result = new 전화번호목록_01();
        System.out.println(result.solution(phone_book));

    }
}
