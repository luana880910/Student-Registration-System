import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class ChooseCoursePage extends Application {

    private TableView<Subject> table = new TableView<>();
    private ObservableList<Subject> data = FXCollections.observableArrayList();
    HBox hb = new HBox();

    public void setSubject() {
        CourseDB db = new CourseDB();
        Course[] c = db.getAllCourse();
        for (int i = 0; i < c.length; i++) {
            data.add(new Subject(String.valueOf(c[i].getCourseID()), c[i].getCourseName(), c[i].getTeacher(),
                    c[i].getTime(), c[i].getGrade(), c[i].getDepartment(), c[i].getNowNum(), c[i].getUpNum()));
        }
    }

    public void coursePage(String id) {
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("選課系統 - 加選");
        stage.setWidth(1750);
        stage.setHeight(650);

        Label label = new Label("課程列表");

        table.setEditable(true);

        TableColumn<Subject, String> IDCol = new TableColumn<>("課程代碼");
        IDCol.setMinWidth(200);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Subject, String> nameCol = new TableColumn<>("課程名稱");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Subject, String> timeCol = new TableColumn<>("課程時間");
        timeCol.setMinWidth(200);
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Subject, String> teacherCol = new TableColumn<>("授課老師");
        teacherCol.setMinWidth(200);
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));

        TableColumn<Subject, String> gradeCol = new TableColumn<>("年級");
        gradeCol.setMinWidth(200);
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<Subject, String> departCol = new TableColumn<>("系所");
        departCol.setMinWidth(200);
        departCol.setCellValueFactory(new PropertyValueFactory<>("depart"));

        TableColumn<Subject, String> nowNumCol = new TableColumn<>("已選人數");
        nowNumCol.setMinWidth(200);
        nowNumCol.setCellValueFactory(new PropertyValueFactory<>("nowNum"));

        TableColumn<Subject, String> upNumCol = new TableColumn<>("上限");
        upNumCol.setMinWidth(200);
        upNumCol.setCellValueFactory(new PropertyValueFactory<>("upNum"));

        setSubject();
        table.setItems(data);
        table.getColumns()
                .addAll(Arrays.asList(IDCol, nameCol, teacherCol, timeCol, gradeCol, departCol, nowNumCol, upNumCol));

        TextField addSubject = new TextField();
        addSubject.setPromptText("輸入課程代碼");
        addSubject.setMaxWidth(300);

        Button addButton = new Button("選課");
        addButton.setOnAction((ActionEvent e) -> {
            ChooseCourse cc = new ChooseCourse();
            try {
                int tempCourseNum = Integer.parseInt(addSubject.getText());
                String temp = cc.judgeCourse(id, tempCourseNum);
                if (temp.equals("")) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("選課成功");
                    alert.setHeaderText("加選成功!");
                    alert.setContentText("恭喜~~搶到課了!!!");
                    alert.showAndWait();
                    table.getItems().clear();
                    table.getItems().addAll(data);
                    setSubject();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("選課錯誤");
                    alert.setHeaderText(temp);
                    alert.setContentText("請重新輸入您的數字。");
                    alert.showAndWait();
                }
            } catch (NumberFormatException ee) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("選課錯誤");
                alert.setHeaderText("輸入的並非為數字!!");
                alert.setContentText("請重新輸入您的數字。");
                alert.showAndWait();
            }
        });

        Button leaveButton = new Button("返回");
        leaveButton.setOnAction((ActionEvent e) -> {
            CourseChooseSwitchPage c = new CourseChooseSwitchPage();
            stage.hide();
            c.courseSwitchPage(id);
        });
        hb.getChildren().addAll(addSubject, addButton);
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb, label, table, leaveButton);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static class Subject {

        private final SimpleStringProperty ID;
        private final SimpleStringProperty name;
        private final SimpleStringProperty teacher;
        private final SimpleStringProperty time;
        private final SimpleStringProperty grade;
        private final SimpleStringProperty depart;
        private final SimpleStringProperty nowNum;
        private final SimpleStringProperty upNum;

        private Subject(final String ID, final String name, final String teacher, final String time, final Grade grade,
                final String depart, final int nowNum, final int upNum) {
            this.ID = new SimpleStringProperty(ID);
            this.name = new SimpleStringProperty(name);
            this.teacher = new SimpleStringProperty(teacher);
            this.grade = new SimpleStringProperty(grade.toString());
            this.time = new SimpleStringProperty(time);
            this.depart = new SimpleStringProperty(depart);
            this.nowNum = new SimpleStringProperty(String.valueOf(nowNum));
            this.upNum = new SimpleStringProperty(String.valueOf(upNum));
        }

        public String getID() {
            return ID.get();
        }

        public String getName() {
            return name.get();
        }

        public String getTeacher() {
            return teacher.get();
        }

        public String getGrade() {
            return grade.get();
        }

        public String getTime() {
            return time.get();
        }

        public String getDepart() {
            return depart.get();
        }

        public String getNowNum() {
            return nowNum.get();
        }

        public String getUpNum() {
            return upNum.get();
        }

    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

    }
}