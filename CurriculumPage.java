import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class CurriculumPage extends Application {

    private TableView<Subject> table = new TableView<>();
    private ObservableList<Subject> data = FXCollections.observableArrayList();
    private String id;

    public void setSubject() {
        CourseDB db = new CourseDB();
        int[] cid = db.getSudentCourse(id);
        Curriculum c = new Curriculum();
        for (int i = 0; i < cid.length; i++) {
            c.setAllCourse(id);
        }
        for (int i = 0; i < 10; i++) {
            String[] str = c.getRow(i);
            data.add(new Subject(str[0], str[1], str[2], str[3], str[4], str[5]));
        }
    }

    public void curPage(String id) {
        this.id = id;
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("課表");
        stage.setWidth(1350);
        stage.setHeight(650);

        table.setEditable(true);
        table.setPrefSize(1203, 515);

        TableColumn<Subject, String> time = new TableColumn<>("時間");
        time.setPrefWidth(200);
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Subject, String> Col1 = new TableColumn<>("一");
        Col1.setPrefWidth(200);
        Col1.setCellValueFactory(new PropertyValueFactory<>("col1"));

        TableColumn<Subject, String> Col2 = new TableColumn<>("二");
        Col2.setPrefWidth(200);
        Col2.setCellValueFactory(new PropertyValueFactory<>("col2"));

        TableColumn<Subject, String> Col3 = new TableColumn<>("三");
        Col3.setPrefWidth(200);
        Col3.setCellValueFactory(new PropertyValueFactory<>("col3"));

        TableColumn<Subject, String> Col4 = new TableColumn<>("四");
        Col4.setPrefWidth(200);
        Col4.setCellValueFactory(new PropertyValueFactory<>("col4"));

        TableColumn<Subject, String> Col5 = new TableColumn<>("五");
        Col5.setPrefWidth(200);
        Col5.setCellValueFactory(new PropertyValueFactory<>("col5"));

        setSubject();
        table.setItems(data);
        table.getColumns().addAll(Arrays.asList(time, Col1, Col2, Col3, Col4, Col5));

        Button leaveButton = new Button("返回");
        leaveButton.setOnAction((ActionEvent e) -> {
            SelectPage s = new SelectPage();
            stage.hide();
            s.selectPage(id);
        });

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 0, 0, 20));
        vbox.getChildren().addAll(table, leaveButton);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static class Subject {

        private final SimpleStringProperty time;
        private final SimpleStringProperty col1;
        private final SimpleStringProperty col2;
        private final SimpleStringProperty col3;
        private final SimpleStringProperty col4;
        private final SimpleStringProperty col5;

        private Subject(final String time, final String col1, final String col2, final String col3, final String col4,
                final String col5) {
            this.time = new SimpleStringProperty(time);
            this.col1 = new SimpleStringProperty(col1);
            this.col2 = new SimpleStringProperty(col2);
            this.col3 = new SimpleStringProperty(col3);
            this.col4 = new SimpleStringProperty(col4);
            this.col5 = new SimpleStringProperty(col5);
        }

        public String getTime() {
            return time.get();
        }

        public String getCol1() {
            return col1.get();
        }

        public String getCol2() {
            return col2.get();
        }

        public String getCol3() {
            return col3.get();
        }

        public String getCol4() {
            return col4.get();
        }

        public String getCol5() {
            return col5.get();
        }

    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

    }
}