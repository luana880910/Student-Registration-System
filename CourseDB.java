import java.sql.*;

public class CourseDB {
  public void getStudentData(Student a) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE ID = \'" + a.getID() + "\';");
      String name = rs.getString("name");
      String grade = rs.getString("grade");
      String department = rs.getString("department");

      a.setName(name);
      a.setGrade(grade);
      a.setDepartment(department);
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public void getCourseData(Course a) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM COURSE WHERE ID = \'" + a.getCourseID() + "\';");
      String name = rs.getString("courseName");
      String teacher = rs.getString("teacher");
      String grade = rs.getString("grade");
      String department = rs.getString("department");
      String courseTime = rs.getString("courseTime");
      int nowNum = rs.getInt("nowNum");
      int upNum = rs.getInt("upNum");

      a.setCourseName(name);
      a.setTeacher(teacher);
      a.setGrade(grade);
      a.setDepartment(department);
      a.setTime(courseTime);
      a.setNowNum(nowNum);
      a.setUpNum(upNum);
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      a.setCode(-1);
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public int[] getSudentCourse(String id) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS c FROM " + id + ";");
      int[] course = new int[rs.getInt("c")];
      stmt.close();
      stmt = c.createStatement();
      rs = stmt.executeQuery("SELECT * FROM " + id + ";");
      int i = 0;
      while (rs.next()) {
        course[i] = rs.getInt("id");
        i++;
      }
      rs.close();
      stmt.close();
      c.close();
      return course;
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
      int[] course = new int[0];
      return course;
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public void updateCourseNum(int course, int num, int doNum) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);
      num = num + doNum;
      stmt = c.createStatement();
      String sql = "UPDATE COURSE set nowNum = " + num + " where ID=" + course + ";";
      stmt.execute(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public void insertCourse(String id, int num) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO " + id + "(ID)" + "VALUES (" + num + ");";
      stmt.execute(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public void deleteCourse(String id, int num) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);
      stmt = c.createStatement();
      String sql = "DELETE from " + id + " where ID=" + num + ";";
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }

  public Course[] getAllCourse() {
    // SELECT COUNT(*) FROM
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS c FROM COURSE;");
      Course[] course = new Course[rs.getInt("c")];
      for (int i = 0; i < 9; ++i) {
        course[i] = new Course();
      }
      stmt.close();
      stmt = c.createStatement();
      rs = stmt.executeQuery("SELECT * FROM COURSE;");
      int i = 0;
      while (rs.next()) {
        course[i].setCode(rs.getInt("id"));
        course[i].setCourseName(rs.getString("courseName"));
        course[i].setTeacher(rs.getString("teacher"));
        course[i].setTime(rs.getString("courseTime"));
        course[i].setGrade(rs.getString("grade"));
        course[i].setDepartment(rs.getString("department"));
        course[i].setNowNum(rs.getInt("nowNum"));
        course[i].setUpNum(rs.getInt("upNum"));
        i++;
      }
      rs.close();
      stmt.close();
      c.close();
      return course;
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
      Course[] course = new Course[0];
      return course;
    } finally {
      try {
        stmt.close();
        c.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
    }
  }
}