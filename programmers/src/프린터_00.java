import java.util.ArrayList;
import java.util.List;

/**
 * 중요도를 고려한 프린터
 * 중요도가 높은 문서를 먼저 프린터하라
 *
 * 인쇄 대기목록 가장 앞에 있는 문서를 대기 목록에서 꺼낸다
 * 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한개라도 존재하면 J를 대기목록의 가장 마지막에 넣는다
 * 그렇지 않으면 J를 인쇄한다
 *
 * 인쇄 대기목록에는 1개 이상 100개 이하의 문서가 있다
 * 작업의 중요도가 1~9로 숫자가 클수록 중요하다
 * location은 0이상(현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며, 대기목록 가장 앞에 있으면 0, 두번째로 있으면 1로 표현한다
 *
 * [2, 1, 3, 2]
 *
 * 큐 생성 - 하나씩 꺼내서 처리 - loc 비교
 * */



public class 프린터_00 {

    public int solution(int[] priorities, int location) {
        // queue 를 만들기
        List<PrintJob> printer = new ArrayList<PrintJob>();
        for(int i = 0; i < priorities.length; i++) {
            printer.add(new PrintJob(i, priorities[i]));
        }

        int turn = 0;
        while(!printer.isEmpty()) {
            PrintJob job = printer.remove(0);
            // 0번을 꺼내서 max 가 아니면 다시 넣는다
            if (printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
                printer.add(job);
            } else {
                // max이면 내가 잡는 job이 맞는지 확인한다
                turn++;
                if(location == job.location) {
                    break;
                }
            }
        }
        return turn;
    }

    class PrintJob {
        int priority;
        int location;

        public PrintJob(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {

        프린터_00 sol = new 프린터_00();
        int[] priorities = {2, 1, 3, 2};

        System.out.println(sol.solution(priorities, 2));
    }
}
