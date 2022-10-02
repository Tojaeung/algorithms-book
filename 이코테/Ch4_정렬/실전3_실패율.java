package 이코테.Ch4_정렬;

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {
    private int stage;
    private double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return stage;
    }

    public double getFail() {
        return fail;
    }

    @Override
    public int compareTo(Node o) {
        if (this.fail == o.fail) {
            return Integer.compare(this.stage, o.stage);
        }
        return Double.compare(o.fail, this.fail);
    }
}


public class 실전3_실패율 {

    public static int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        ArrayList<Node> arrList = new ArrayList<>();
        int stagesLength = stages.length;

        for (int stage = 1; stage <= n; stage++) {

            int cnt = 0;
            /*
             * 특정 스테이지 찾기
             * stageLength로 하면 답이 이상하게 나옴 (증명필요)
             * stageLength로 하면 루프 돌때마다 스테이지를 하고 있는 플레이어수가 작아지기 때문에
             * stageLength가 짧아진다.
             * 그와 더불어 for문에 최대값으로 설정된 stageLength도 짧아지기 때문에 예상못한 답이 나온다.
             * for문이 한번 실행이 되면 끝날때까지 그대로 가는줄알았는데
             * for문 루프 돌때마다 새롭개 초기화가 된다 ㄷㄷ;;;;
             * */
            for (int j = 0; j < stages.length; j++) {
                if (stage == stages[j]) cnt++;
            }
            /*
             * 스테이지에 유저없으면 실패율 0
             * 어차피 cnt 0이면 실패율 0
             * */
            double fail = 0;
            if (stagesLength >= 1) {
                fail = (double) cnt / stagesLength;
            }

            arrList.add(new Node(stage, fail));

            // 다음 루프 돌때는 그 스테이지에 도달한 사람만이 포함된다.
            stagesLength -= cnt;

        }

        // 실패율 높은순으로 정렬
        Collections.sort(arrList);

        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i).getStage();
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        // int[] stages = {4, 4, 4, 4, 4};
        int[] result = solution(5, stages);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
