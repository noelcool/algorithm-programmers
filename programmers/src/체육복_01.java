/**
 * 체육복을 도난 당했다
 * 여벌 체육복을 빌릴 수 있는데 바로 앞번호의 학생이나 뒷번호의 학생에게만 빌려줄 수 있다
 * 전체 학생 수 n, 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
 * 체육 수업을 들을 수 있는 학생의 최대값을 리턴하라
 *
 * 전체 학생의 수는 2~30
 * 도난 당한 학생의 수는 1~n명 이하, 중복 x
 * 여벌 체육복 가지고 있는 학생은 1~n명 이하, 중복 x
 * 여벌 체육복을 가지고 있는 학생이 도난 당한 경우 체육복은 1벌만 가지고 있음
 *
 * 5, [2, 4] [1,3,5]
 *
 * */
public class 체육복_01 {

    public int solution(int n, int[] lost, int[] reserve) {

        // 1. student 배열을 생성한다
        int[] student = new int[n+2];
        int answer = 0;

        // 2. reserve / lost 정보를 반영한다
        for(int l : lost) {
            student[l]--;
        }
        for(int r: reserve) {
            student[r]++;
        }

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다
        for(int i=1; i<=n; i++) {
            if(student[i] == 1) {
                if(student[i-1] == -1) {
                    student[i]--;
                    student[i-1]++;
                } else if(student[i+1] == -1) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }

        // 4. 체육복을 갖고 있는 학생수를 계산한다
        for(int i=1; i<=n; i++) {
            if(student[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        체육복_01 sol = new 체육복_01();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(5, lost, reserve));

    }
}
