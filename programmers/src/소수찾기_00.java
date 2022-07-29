import java.util.HashSet;
import java.util.Iterator;

/**
 * 모든 숫자 조합을 만들고 그 중 소수의 개수를 리턴
 * numbers는 길이 1 이상 7 이하인 문자열이다
 * numbers는 0~9까지의 숫자만으로 이루어져 있다
 * 013은 0,1,3 숫자가 적힌 종이 조각이 흩어져있다는 의미이다
 *
 * */


public class 소수찾기_00 {

    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;

        int lim = (int)Math.sqrt(num); // 배수 여부 확인

        for(int i=2; i<=lim; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others) {
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        for(int i=0; i<others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }

    public int solution(String numbers) {
        int count = 0;
        recursive("", numbers);
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        소수찾기_00 sol = new 소수찾기_00();
        System.out.println(sol.solution("17"));
    }
}
