package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {

  public static void main(String[] args) {

    School school = new School();
    // 학생들 저장
    List<Student> studentList = school.getStudentList();
    List<Student> registStudentList = new ArrayList<>();

    // 검색 및 저장
    boolean flag = true;
    Scanner sc = new Scanner(System.in);
    while (flag) {
      System.out.println("검색하고 싶은 학생 이름을 입력하세요!!");
      String search = sc.next();
      boolean searchResult = false;
      for (Student student : studentList) {
        if (student.name.equals(search)) {
          System.out.println("찾았습니다.");
          registStudentList.add(student);
          searchResult = true;
          break;
        }
      }
      if (!searchResult) {
        System.out.println("검색 결과가 없습니다!!");
      }
      System.out.println("계속 검색을 하겠느냐 true, 종료하고싶으면 false");
      flag = sc.nextBoolean();
    }
    // 종료
    System.out.println("종료합니다.!!");
    System.out.println("등록된 학생 목록입니다.");
    for (Student student : registStudentList) {
      System.out.println(student.toString());
    }
  }

  private List<Student> getStudentList() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new StudentBuilder("손오공", 1).build());
    studentList.add(new StudentBuilder("저팔계", 2).build());
    studentList.add(new StudentBuilder("사오정", 3).build());
    studentList.add(new StudentBuilder("삼장법사", 4).build());
    return studentList;
  }

  public class StudentBuilder {

    private Student student;

    public StudentBuilder(String name, int no) {
      this.student = new Student();
      this.student.setName(name);
      this.student.setNo(no);
    }

    public Student getStudent() {
      return student;
    }

    public void setStudent(Student student) {
      this.student = student;
    }

    public Student build() {
      return this.student;
    }

  }

  public class Student {
    private String name;
    private int no;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getNo() {
      return no;
    }

    public void setNo(int no) {
      this.no = no;
    }

    @Override
    public String toString() {
      return "Student{" +
        "name='" + name + '\'' +
        ", no=" + no +
        '}';
    }
  }

}
