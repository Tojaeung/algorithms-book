package 이코테.Ch4_정렬;

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
        if (this.score > o.score) return 1;
        return -1;
    }
}

public class 문제2_성적이낮은순서로학생출력 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> student = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            /*
             * next()에 대해서 알아보자
             * next는 공백문자를 구분자로 인식한다. 예를들어서 "이순신 85"를 입력한다면 next는 이순신만 출력한다.
             * 그 다음 버퍼에는 " 85"가 남아 있고 nextInt는 공백문자를 포함하지 않고 오직 숫자만 출력한다.
             * 만약 nextLine이 있다면 공백문자까지 같이 출력을 하기 때문에 " 85"가 출력될것이다.
             * nextLine을 사용하면 공백문자가 포함되므로 사용전에는 반드시 버퍼를 초기화 하자
             * */
            String name = sc.next();
            int score = sc.nextInt();
            student.add(new Student(name, score));
        }

        Collections.sort(student);
        // student.sort(Comparator.naturalOrder());

        for (int i = 0; i < student.size(); i++) {
            System.out.print(student.get(i).getName() + " ");
        }

    }
}
