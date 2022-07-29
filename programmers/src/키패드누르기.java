/**
 * 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 한다
 * 맨 처음 왼손 엄지손가락은 * 키패드에, 오른손 엄지손가락은 # 키패드에서 시작하며 엄지손가락을 사용하는 규칙은 다음과 같다
 *
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리에 1로 해당한다
 * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용한다
 * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지 손가락을 사용한다
 * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지 손가락에 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용한다
 *  만약 두 엄지손가락의 거리가 같다면 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용한다
 *
 *  순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인지 나타내는 문자 hand가 매개변수로 주어질 때
 *  각 번호를 누른 엄지손가락이 왼손인지 오른손인지 나타내는 연속된 문자열 형태를 return 하라
 *
 * */
public class 키패드누르기 {

    Position left;
    Position right;
    Position numPos;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        // 1. 왼손 오른손 위치 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);


        for(int num : numbers) {
            // 2. 숫자를 누를 손가락 정하기
            numPos = new Position((num-1) / 3, (num-1) % 3);
            if(num == 0) numPos = new Position(3, 1);

            String finger = numPos.getFinger(hand);

            // 3. 정해진 손가락을 answer에 담고 손가락 위치 이동
            answer += finger;
            if(finger.equals("L")) left = numPos;
            else right = numPos;
        }

        return answer;

    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";
            if(this.col == 0) finger = "L";
            else if (this.col == 2) finger = "R";
            else {
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);
                if (leftDist < rightDist) finger = "L";
                else if (rightDist < leftDist) finger = "R";
            }
            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }

    public static void main(String[] args) {
        키패드누르기 sol = new 키패드누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution(numbers, hand));

    }
}
