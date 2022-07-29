/**
 * n개의 음이 아닌 정수들이 있다
 * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다
 *
 * 사용하고자 하는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 주어질 때 타겟 넘버를 만드는 경우의 수를 리턴하라
 *
 * 숫자의 개수는 2개 이상 20개 이하
 * 각 숫자는 1 이상 50 이하인 자연수
 * 타겟 넘버는 1이상 1000 이하인 자연수
 *
 * */

public class 타겟넘버 {

    int[] numbers;
    int target;
    int answer;

    void dfs(int index, int sum) {
        // 탈출 조건
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }

        // 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        return answer;
    }


}
