public class Course {
    
    private int code;
    private String teacher;
    private String arrStr;
    private Department department;
    private Grade grade;
    private String courseName;
    private int upNum;
    private int nowNum;
    public Course() {}

    public Course(int code) {
        this.code = code;
    }
    
    public int getCourseID() {
        return code;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTime() {
        String[] temp = arrStr.split(",");
        int[] intTemp = new int[temp.length];
        String reStr = "";
        int minN = 100;
        ;
        int maxN = 0;
        for (int i = 0; i < temp.length; i++) {
            intTemp[i] = Integer.parseInt(temp[i]);
            Week week = new Week();
            int tempWeek = 0;
            if(intTemp[i]%10 == 0) {
                tempWeek = intTemp[i]/10;
            }
            else {
                tempWeek = (intTemp[i] / 10) + 1;
            }
            reStr = week.wString(tempWeek);
            int tempN = 0;
            if(intTemp[i]%10 == 0) {
                tempN = 10;
            }
            else {
                tempN = intTemp[i]%10;
            }
            minN = Math.min(minN, tempN);
            maxN = Math.max(maxN, tempN);
        }
        reStr += " " + minN + "-" + maxN;
        return reStr;
    }

    public int getWeek() {
        String[] temp = arrStr.split(",");
        int intTemp = 0;
        intTemp = Integer.parseInt(temp[0]);
        int tempWeek = 0;
        if(intTemp%10 == 0) {
            tempWeek = intTemp/10;
        }
        else {
            tempWeek = (intTemp / 10) + 1;
        }
        return tempWeek;
    }

    public int[] getLesson() {
        String[] temp = arrStr.split(",");
        int[] intTemp = new int[temp.length];
        int[] lesson = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            intTemp[i] = Integer.parseInt(temp[i]);
            int tempN = 0;
            if(intTemp[i]%10 == 0) {
                tempN = 10;
            }
            else {
                tempN = intTemp[i]%10;
            }
            lesson[i] = tempN;
        }
        return lesson;
    }

    public String getTeacher() {
        return teacher;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department.getDepartment();
    }
    
    public int getUpNum() {
        return upNum;
    }

    public int getNowNum() {
        return nowNum;
    }

    public void setCode(int id) {
        this.code = id;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.arrStr = time;
    }

    public void setGrade(String grade) {
        this.grade = Grade.valueOf(grade);
    }

    public void setDepartment(String department) {
        this.department = Department.valueOf(department);
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setUpNum(int upNum) {
        this.upNum = upNum;
    }

    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }

}