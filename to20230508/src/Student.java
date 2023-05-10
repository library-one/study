

public class Student {
    private String id;
    private String name;
    private String dept;
    private String grade;

    public Student(){}
    public Student(String id, String name, String dept, String grade) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {return grade;}

    public void setGrade(String grade) {this.grade = grade;}
    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String toString() {
        return this.id  +"  "+ this.name  +"  "+ this.dept +"  "+ this.grade ;
    }

    public static void main(String[] args) {
    }
}
