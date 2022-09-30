package 구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public char getDirection() {
        return direction;
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class 실전5_뱀 {
    public static int n, k, l;
    public static int[][] arr = new int[101][101];
    public static ArrayList<Node> info = new ArrayList<>();

    // direction = 0 일때는 동쪽
    // direction = 1 일때는 남쪽
    // direction = 2 일때는 서쪽
    // direction = 3 일때는 북쪽
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if (c == 'L') {
            // 현재 방향이 동쪽이라면 북쪽(3)으로
            direction = (direction == 0) ? 3 : direction - 1;
        } else {
            // 4로 나눈 나머지를 활용해서 올바른 방향을 정하고 있는 코드이다.
            direction = (direction + 1) % 4;
        }
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1;   // 뱀의 처음 위치
        arr[x][y] = 2;  // 뱀이 있는 위치
        int direction = 0;  // 처음에는 동쪽이기 때문에 0으로 초기화 해주었다.
        int time = 0;
        int index = 0;  // turn을 해야할 index를 나타낸다.

        // 뱀이 차지하고 있는 위치
        // 뱀이 이동하면 마지막 위치정보는(큐의 맨앞) 사라져야하기때문에 큐 자료구조를 사용하였다.
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];


            if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && arr[nx][ny] != 2) { // 맵에 충돌하거나 뱀이 자기자신에게 충돌하지 않을때
                if (arr[nx][ny] == 0) { // 이동위치에 사과가 없을때
                    // 새로운 이동위치는 뱀의 위치가 된다.
                    arr[nx][ny] = 2;
                    // 새로운 이동위치를 큐에 뱀의 위치정보가 담겨있는 큐에 넣어준다.
                    q.offer(new Position(nx, ny));

                    // 뱀이 이동함으로써 마지막 위치는 초기화 시켜준다. 
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }

                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            } else {    // 맵에 충돌하거나 뱀이 작기자신에게 충돌하였을때
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;

            // 회전을 해야하는 시간일때
            if (index < 1 && time == info.get(index).getTime()) {
                // turn함수를 이용해서 다음으로 나아갈 방향을 정해준다.
                direction = turn(direction, info.get(index).getDirection());
                // 다음 회전을 해야하는 시간을 info배열에서 추출하기 위해 index를 업데이트해준다.....
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 맵
        k = sc.nextInt();   // 사과갯수

        // 사과가 있는곳 1로 표시
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        l = sc.nextInt();   // 방향전환 갯수
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }

        System.out.println(simulate());
    }
}
