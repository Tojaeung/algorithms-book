package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /*
     * 객체의 값을 비교하기 위해 상속받은 메서드이다.
     * 기본타입은 내부적으로 compareTo가 구현되어 있어서 정렬이 가능하지만
     * 사용자 정의 타입의 객체는 comparable을 상속받아서 정렬기준을 정의해야한다.
     * */
    @Override
    public int compareTo(Student o) {
        /*
         * 주체객체가 더 큰데 1을 리턴해서 바꿔준다.?? 이것은 내림차순 정렬이다.
         *  주체객체가 더 큰데 -1을 리턴해서 바꿔준다.?? 이것은 내림차순 정렬이다.
         * 1을 리턴하면 자리를 바꿔준다.
         * -1을 리턴하면 자리를 유지한다.
         * */
        return this.score < o.score ? -1 : 1;
    }
}

public class 문제2_성적이낮은순서로학생출력 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> student = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            student.add(new Student(name, score));
        }

        Collections.sort(student);

        for (int i = 0; i < student.size(); i++) {
            System.out.print(student.get(i).getName() + " ");
        }

    }
}
