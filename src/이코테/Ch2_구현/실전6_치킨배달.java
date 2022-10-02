package 이코테.Ch2_구현;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private int n;  // 치킨집 갯수
    private int r;
    private int[] now;  // 현재조합
    private ArrayList<ArrayList<Position2>> result;  // 모든 조합

    public ArrayList<ArrayList<Position2>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position2>>();
    }

    public void combination(ArrayList<Position2> arr, int depth, int index, int target) {
        // now = 조합이 모이는 배열
        // 
        if (depth == r) {
            ArrayList<Position2> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
        }

        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);

    }
}

class Position2 {
    private int x;
    private int y;

    public Position2(int x, int y) {
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

public class 실전6_치킨배달 {
    public static int n, m;
    public static int[][] arr = new int[50][50];
    public static ArrayList<Position2> chicken = new ArrayList<>();
    public static ArrayList<Position2> house = new ArrayList<>();

    public static int getSum(ArrayList<Position2> candidates) {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getX();
            int hy = house.get(i).getY();
            // 가장 가까운 치킨집을 찾기
            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                arr[r][c] = sc.nextInt();
                // 1 == 일반집
                if (arr[r][c] == 1) house.add(new Position2(r, c)); // 일반집
                // 2 == 치킨집
                if (arr[r][c] == 2) chicken.add(new Position2(r, c)); // 치킨집
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨집을 뽑는 조합계산
        Combination comb = new Combination(chicken.size(), m);  // nCr
        comb.combination(chicken, 0, 0, 0);
        ArrayList<ArrayList<Position2>> chickenList = comb.getResult();

        // 치킨거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }

        System.out.println(result);

    }
}
