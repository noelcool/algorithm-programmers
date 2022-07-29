import java.util.ArrayList;
import java.util.HashMap;

/**
 * info를 기반으로 hashMap 생성 - 각 info가 해당되는 hashMap 전부 생성
 * query 처리 - query 조건에 맞는 지원자들의 점수 가져오기
 * 기준 점수 이상인 지원자 - query 로 얻어온 정보 지원자 중 기준 점수 이상인 지원자 수
 * */


public class 순위검색 {

    public int[] solution(String[] info, String[] query) {
        // 1. INFO 를 기반으로 hashMap을 만든다
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for(String i : info) {
            String [] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);
            for(String lang : languages)
                for(String job : jobs)
                    for(String exp : exps)
                        for(String food : foods) {
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        // 2. 각 hashMap의 value를 오름차순 정렬한다
        for(ArrayList<Integer> arr : hashMap.values())
            arr.sort(null);

        // 3. query 조건에 맞는 지원자를 가져온다
        int[] answer = new int[query.length];
        int i = 0;
        for(String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if(hashMap.containsKey(key)) {
                // 4. binary search를 통해서 lower-bound를 찾는다
                ArrayList<Integer> list = hashMap.get(key);
                int left = 0;
                int right = list.size();
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }
                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {

        순위검색 sol = new 순위검색();
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 150",
                "python frontend senior chicken 210",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        System.out.println(sol.solution(info, query));

    }
}
