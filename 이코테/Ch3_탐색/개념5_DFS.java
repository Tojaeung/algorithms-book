package 이코테.Ch3_탐색;

import java.util.ArrayList;

public class 개념5_DFS {

    public static boolean[] visited = new boolean[9];   // 모두 false로 초기화 된다.
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList();

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            // 9개의 빈배열 생성 (0노드 빈배열도 포함)
            graph.add(new ArrayList());
        }

        //////////////////////////////////////////////////////

        //  0노드   1노드    2노드    3노드    4노드  5노드  6노드   7노드    8노드
        // [ [] , [2,3,8], [1,7], [1,4,5], [3,5], [3,4], [7], [2,6,8], [1,7]  ]

        // 0 노드는 1노드부터 표현하기 위해 인위적으로 빈배열을 추가한것이다. (계산 간결)

        //////////////////////////////////////////////////////

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);

    }
}
