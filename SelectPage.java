import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SelectPage extends Application{

    public void selectPage(String id){
        //Layout
	GridPane grid = new GridPane(); //Grid排版
	grid.setAlignment(Pos.CENTER); //Layout置中
	grid.setHgap(10); //水平距離
	grid.setVgap(10); //垂直距離
    Button ans1 = new Button("1)個人資料");
    Button ans2 = new Button("2)選課系統");
    Button ans3 = new Button("3)我的課表");
    Button ans4 = new Button("4)讀書計畫");
    Button ans5 = new Button("5)登出");
 
	grid.setPadding(new Insets(10, 10, 10, 10)); //填充邊界。Insets定義上、右、下、左四個方向的長度。
 
	//用Layout作為Scene的root node
    Scene scene = new Scene(grid, 450, 435);
    Stage stage = new Stage();

    //GUI元件
    grid.add(ans1, 0, 0);
    grid.add(ans2, 0, 1);
    grid.add(ans3, 0, 2);
    grid.add(ans4, 0, 3);
    grid.add(ans5, 0, 5);
    ans1.setOnAction(e->
    {
        PersonalInformationPage p = new PersonalInformationPage();
        stage.hide();
        p.personalPage(id);
    });		
    ans2.setOnAction(e->
    {
        CourseChooseSwitchPage c = new CourseChooseSwitchPage();
        stage.hide();
        c.courseSwitchPage(id);
    });		
    ans3.setOnAction(e->
    {
        CurriculumPage c = new CurriculumPage();
        stage.hide();
        c.curPage(id);
    });		
    ans4.setOnAction(e->
    {
        // stage.hide();
        // 還沒做好!!
    });		
    ans5.setOnAction(e->
    {
        LogPage l = new LogPage();
        stage.hide();
        l.page1();
    });	

    stage.setTitle("SRS");
    stage.setScene(scene);
    stage.setResizable(false);

    stage.show();   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        

    }
}//class