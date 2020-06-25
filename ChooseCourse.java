public class ChooseCourse {
    public String judgeCourse(String id, int num) {
        Student st = new Student(id);
        Course c = new Course(num);
        CourseDB db = new CourseDB();
        db.getStudentData(st);
        db.getCourseData(c);
        int[] hCourse = db.getSudentCourse(id);
        if (c.getCourseID() == -1) {
            return "不存在此課程。";
        }
        for (int i : hCourse) {
            Course temp = new Course(i);
            db.getCourseData(temp);
            if (num == i) {
                return "已選此課程。";
            }
            if (temp.getTime().equals(c.getTime())) {
                return "此時段已有課程。";
            }
        }
        if (!(c.getDepartment().equals(st.getDepartment()) || c.getDepartment().equals(Department.ALL.getDepartment()))) {
            return "系所修課權限不符。";
        }
        else {
            if(c.getGrade().getNum() > st.getGrade().getNum()) {
                return "修課年級不符，請洽系辦處理上修。";
            }
            else {
                if(c.getUpNum()-c.getNowNum() < 1) {
                    return "修課人數已滿，是否排入候補名單";
                }
            }
        }
        insertNum(id, num, c.getNowNum());
        return "";
    }
    public void insertNum(String id, int num,int nowNum) {
        CourseDB db = new CourseDB();
        db.insertCourse(id,num);
        db.updateCourseNum(num, nowNum,1);
    }
    public void deleteNum(String id, int num, int nowNum) {
        CourseDB db = new CourseDB();
        db.deleteCourse(id,num);
        db.updateCourseNum(num, nowNum,-1);
    }
    public String judgeUnselect(String id, int num) {
        Student st = new Student(id);
        Course c = new Course(num);
        CourseDB db = new CourseDB();
        db.getStudentData(st);
        db.getCourseData(c);
        int[] hCourse = db.getSudentCourse(id);
        if (c.getCourseID() == -1) {
            return "不存在此課程。";
        }
        for (int i : hCourse) {
            if (num == i) {
                deleteNum(id, num, c.getNowNum());
                return "";
            }
        }
        return "您未選此課程。";
    }
}