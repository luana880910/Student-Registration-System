public class Student {
    // private String id = "u10716010";
    // private String password = "123";
    // private String name = "陳芮甯";
    // private Grade grade = Grade.Sophomore;
    // private Department department = Department.ComputerScience;
    private String id;
    private String password;
    private String name;
    private Grade grade;
    private Department department;
    public Student() {}
    public Student(String id) {
        this.id = id;
    }
    public String getID() {
        return id;
    }
    public String findID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Grade getGrade() {
        return grade;
    }
    public String getDepartment() {
        return department.getDepartment();
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGrade(String grade) {
        this.grade = Grade.valueOf(grade);
    }
    public void setDepartment(String department) {
        this.department = Department.valueOf(department);
    }
}