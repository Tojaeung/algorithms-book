package 탐색;

import java.util.*;

class Virus implements Comparable<Virus> {
    private int index;  // 바이러스 종류
    private int second; // 시간
    private int x;  // 위치 x
    private int y;  // 위치 y

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Virus o) {
        return (this.index > o.index) ? 1 : -1;
    }
}

public class 실전3_경쟁적전염 {
    public static int n, k;
    // 미리 맵을 최대로 만든다. (코드 간단)
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                // 해당 위치에 바이러스가 존재하는 경우
                if (graph[i][j] != 0) {
                    // (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        // 정렬 이후에 큐로 옮기기 (낮은 번호의 바이러스가 먼저 증식하므로)
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        int targetS = sc.nextInt();
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        // 너비 우선 탐색(BFS) 진행
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.getSecond() == targetS) break;
            // 현재 노드에서 주변 4가지 위치를 각각 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                // 해당 위치로 이동할 수 있는 경우
                if (nx < 0 || nx > n || ny < 0 || ny > n) continue;
                // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = virus.getIndex();
                    q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                }
            }
        }
        System.out.println(graph[targetX - 1][targetY - 1]);
    }
}
