public class Curriculum {
    private String[][] curriculumStr = new String[10][6];

    public String getTimeStr(int i) {
        String str = "";
        switch (i) {
            case 0:
                str = "第 1 節\n08:10-09:00";
                break;
            case 1:
                str = "第 2 節\n09:10-10:00";
                break;
            case 2:
                str = "第 3 節\n10:10-11:00";
                break;
            case 3:
                str = "第 4 節\n11:10-12:00";
                break;
            case 4:
                str = "第 5 節\n12:10-13:00";
                break;
            case 5:
                str = "第 6 節\n13:10-14:00";
                break;
            case 6:
                str = "第 7 節\n14:10-15:00";
                break;
            case 7:
                str = "第 8 節\n15:10-16:00";
                break;
            case 8:
                str = "第 9 節\n16:10-17:00";
                break;
            case 9:
                str = "第 10 節\n17:10-18:00";
                break;
            default:
                break;
        }
        return str;
    }

    public void setAllCourse(String id) {
        CourseDB db = new CourseDB();
        int[] cId = db.getSudentCourse(id);
        Course c = new Course();
        for (int i = 0; i < 10; i++) {
            setCourse(getTimeStr(i), i, 0);
        }
        for (int i = 0; i < cId.length; ++i) {
            c.setCode(cId[i]);
            db.getCourseData(c);
            int[] lesson = c.getLesson();
            for (int j = 0; j < lesson.length; j++) {
                setCourse(c.getCourseName()+"\n"+c.getTeacher(), lesson[j]-1, c.getWeek());
            }
        }
    }
    public String[] getRow(int row) {
        String[] str = new String[6];
        for (int i = 0; i < 6; i++) {
            str[i] = curriculumStr[row][i];
        }
        return str;
    }
    public void setCourse(String str, int i, int j) {
        this.curriculumStr[i][j] = str;
    }
    
}