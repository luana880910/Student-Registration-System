import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PersonalInformationPage extends Application{


    public void personalPage(String id){
        //Layout
	GridPane grid = new GridPane(); //Grid排版
	grid.setAlignment(Pos.CENTER); //Layout置中
	grid.setHgap(10); //水平距離
    grid.setVgap(10); //垂直距離
    Student st = new Student(id);
    CourseDB db = new CourseDB();
    db.getStudentData(st);
    Text ans1 = new Text("姓名:");
    Text ans2 = new Text(st.getName());
    Text ans3 = new Text("學號:");
    Text ans4 = new Text(st.getID());
    Text ans5 = new Text("年級:");
    Text ans6 = new Text(String.valueOf(st.getGrade()));
    Text ans7 = new Text("系級:");
    Text ans8 = new Text(String.valueOf(st.getDepartment()));
    Button btn = new Button("返回");
 
	grid.setPadding(new Insets(10, 10, 10, 10)); //填充邊界。Insets定義上、右、下、左四個方向的長度。
 
	//用Layout作為Scene的root node
    Scene scene = new Scene(grid, 450, 435);
    Stage stage = new Stage();

    //GUI元件
    grid.add(ans1, 0, 0);
    grid.add(ans2, 1, 0);
    grid.add(ans3, 0, 1);
    grid.add(ans4, 1, 1);
    grid.add(ans5, 0, 2);
    grid.add(ans6, 1, 2);
    grid.add(ans7, 0, 3);
    grid.add(ans8, 1, 3);
    grid.add(btn, 1, 5);
    btn.setOnAction(e->
    {
        SelectPage s = new SelectPage();
        stage.hide();
        s.selectPage(id);
    });		
    stage.setTitle("個人資料");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        

    }
}//class