package 이코테.Ch4_정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student2 implements Comparable<Student2> {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student2(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    @Override
    public int compareTo(Student2 o) {
        /*
         * this.score는 자기자신
         * o.score는 비교대상
         * [4,2]
         * 4는 자기자신, 2는 비교대상
         * 리턴값이 1인경우에 자리를 바꾼다.
         * [2,4]
         * 즉, 오름차순 정렬이 된다.
         * */

        /*
         * 모든 점수가 같다면 이름순이 먼저 나와야한다. 가 먼저 와야한다.
         * 아니면 국어점수가 같은경우 와 같은 경우에서 값이 결과가 출력되기 때문이다.
         * */
        if (this.korean == o.korean && this.english == o.english && this.math == o.math) {  // 오름차순
            // 앞에가 더 크면 1반환
            return o.name.compareTo(this.name);
        }

        if (this.korean == o.korean && this.english == o.english) { // 내림차순
            // 앞에 인자가 더 크면 1반환
            return Integer.compare(o.math, this.math);
        }
        if (this.korean == o.korean) {  // 오름차순
            // 앞에 인자가 더 크면 1반환 
            return Integer.compare(this.english, o.english);
        }

        // 내림차순
        return Integer.compare(o.korean, this.korean);
    }
}

public class 실전1_국영수 {
    public static int n;
    public static ArrayList<Student2> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 학생수

        for (int i = 0; i < n; i++) {
            String studentName = sc.next();
            int koreanScore = sc.nextInt();
            int englishScore = sc.nextInt();
            int mathScore = sc.nextInt();

            arr.add(new Student2(studentName, koreanScore, englishScore, mathScore));
        }

        Collections.sort(arr);

        for (Student2 student : arr) {
            System.out.println(student.getName());
        }

    }
}
