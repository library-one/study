import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    StudentDAO dao = null;
    Scanner scanner = new Scanner(System.in);

    public StudentMain() {
        dao = new StudentDAO();
    }
    public void getList(){
        ArrayList<Student> list = dao.studentList();
        for(Student s:list)
            System.out.println(s.toString());
    }
    public void menu(){
        while(true) {
            System.out.println("====학생 관리 프로글맴====");
            System.out.println("1.학생 리스트");
            System.out.println("2.학생 정보 추가");
            System.out.println("3.학생 정보 수정");
            System.out.println("4.학생 정보 삭제");
            System.out.println("0.종료");
            System.out.print("입력할 메뉴 선택 : ");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    this.getList();
                    break;
                case 2:
                    this.doInsert();
                    break;
                case 3:
                    this.doUpdate();
                    break;
                case 4:
                    this.doDelete();
                    break;
                case 0:
                    break;
            }
            if (num == 0)
                break;
        }
    }
    public void doInsert(){
        System.out.println("추가할 학생 정보를 입력하시요..");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("NAME: ");
        String name = scanner.next();
        System.out.print("Dept: ");
        String dept = scanner.next();
        System.out.print("Grade: ");
        String grade = scanner.next();
        Student student = new Student(id,name,dept,grade);

        boolean success = dao.insertStudent(student);
        if(success)
            System.out.println("학생 정보 추가 성공");
        else
            System.out.println("학생 정보 추가 실패");
    }
    public void doUpdate(){
        System.out.println("수정할 학생 정보를 입력하시요..");
        Scanner scanner = new Scanner(System.in);
        System.out.print("변경하고 싶은 학생 ID: ");
        String id = scanner.next();
        System.out.print("수정할 학생 NAME: ");
        String name = scanner.next();
        System.out.print("수정할 학생 Dept: ");
        String dept = scanner.next();
        System.out.print("수정할 학생 Grade: ");
        String grade = scanner.next();
        Student student = new Student(id,name,dept,grade);
        boolean success = dao.updateStudent(student);
        if(success)
            System.out.println("학생 정보 수정 성공");
        else
            System.out.println("학생 정보 수정 실패");
    }
    public void doDelete(){
        System.out.println("삭제할 학생 정보를 입력하시요..");
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 ID: ");
        String id = scanner.next();
        Student student = new Student();
        student.setId(id);
        boolean success = dao.deleteStudent(student);
        if(success)
            System.out.println("학생 삭제 성공");
        else
            System.out.println("학생 삭제 실패");
    }

    public static void main(String[] args) {

        StudentMain m = new StudentMain();
        m.menu();
    }
}