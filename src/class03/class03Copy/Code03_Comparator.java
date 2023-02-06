package Algorithm.basic.class03.class03Copy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {
        @Override
        // TODO:返回负数的时候，第一个参数放前面
        // TODO:返回正数的时候，第二个参数放前面
        // TODO:返回0的时候，谁前都行
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    public static void main(String[] args) {

        Student student1 = new Student("A", 2, 23);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);

        Student[] students = new Student[]{student1, student2, student3};

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);


        // 利用堆进行特殊规则的排序
        PriorityQueue<Student> maxHeapBasedID = new PriorityQueue<>(new IdAscendingComparator());
        maxHeapBasedID.add(student1);
        maxHeapBasedID.add(student2);
        maxHeapBasedID.add(student3);
        while (!maxHeapBasedID.isEmpty()) {
            Student stu = maxHeapBasedID.poll();
            System.out.println("Name:" + stu.name + ",Id:" + stu.id + ",Age" + stu.age);

        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
}
