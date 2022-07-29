import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 신입 사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발한다
 * 각 유저는 한번에 한 명의 유저를 신고할 수 있다
 *  신고 횟수에 제한은 없다, 서로 다른 유저를 계속 신고할 수 있다
 *  한 유저를 여러번 신고할 수 있지만 동일한 유저에 대한 신고 횟수는 1회로 처리된다
 * k 번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송한다
 *  유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송한다
 *
 * */



public class 신고결과받기 {

    public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];

        // 1. 중복 제거
        HashSet<String> reportSet = new HashSet<String>();
        for(String rep : report) reportSet.add(rep);

        // 2. notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for(String rep : reportSet) {
            int blankIdx = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIdx);
            String reportee = rep.substring(blankIdx+1);

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if(reporterList == null) reporterList = new ArrayList<>();
            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }

        // 3. notifyListHash를 기반으로 reporterHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for(ArrayList<String> notifyList : notifyListHash.values())
            if(notifyList.size() >= k)
                for(String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);

        // 4. reporterHash 기반으로 answer를 만든다
        for(int i = 0; i < idList.length; i++) {
            answer[i] = reporterHash.getOrDefault(idList[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        신고결과받기 sol = new 신고결과받기();
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(sol.solution(idList, report, k));

    }
}
