package Test;

import java.util.*;

public class HashCode_Equals {
    static class Student {
        private String id;
        private String name;
        private String email;
        private int age;

        public Student(String id) {
            this.id = id;
        }

        public Student(String id, String name, String email, int age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String toString() {
            String studentInfo = "Student " + id;
            studentInfo += ": " + name;
            studentInfo += " - " + email;
            studentInfo += " - " + age;

            return studentInfo;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student another = (Student) obj;
                if (this.id.equals(another.id)) {
                    return true;
                }
            }

            return false;
        }

        public int hashCode() {
            return 31 + id.hashCode();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("123", "Tom", "tom@gmail.com", 30);
        Student student2 = new Student("123", "Tom", "tom@gmail.com", 30);
        Student student3 = new Student("456", "Peter", "peter@gmail.com", 23);

        Set<Student> setStudents = new HashSet<>();

        setStudents.add(student1);
        setStudents.add(student2);
        setStudents.add(student3);

        if (setStudents.contains(student1) && setStudents.contains(student2)) {
            System.out.println("True");
        }

        setStudents.forEach(student -> System.out.println(student));
    }
}
