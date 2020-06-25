import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CourseChooseSwitchPage extends Application{

    public void courseSwitchPage(String id){
        //Layout
	GridPane grid = new GridPane(); //Grid排版
	grid.setAlignment(Pos.CENTER); //Layout置中
	grid.setHgap(10); //水平距離
	grid.setVgap(10); //垂直距離
    Button ans1 = new Button("1)加選");
    Button ans2 = new Button("2)退選");
    Button ans5 = new Button("3)返回");
 
	grid.setPadding(new Insets(10, 10, 10, 10)); //填充邊界。Insets定義上、右、下、左四個方向的長度。
 
	//用Layout作為Scene的root node
    Scene scene = new Scene(grid, 450, 435);
    Stage stage = new Stage();

    //GUI元件
    grid.add(ans1, 0, 0);
    grid.add(ans2, 0, 1);
    grid.add(ans5, 0, 5);
    ans1.setOnAction(e->
    {
        ChooseCoursePage c = new ChooseCoursePage();
        stage.hide();
        c.coursePage(id);
    });		
    ans2.setOnAction(e->
    {
        UnselectCoursePage c = new UnselectCoursePage();
        stage.hide();
        c.coursePage(id);
    });		
    ans5.setOnAction(e->
    {
       SelectPage s = new SelectPage();
       stage.hide();
       s.selectPage(id);
    });	
        // Set the title of Stage
    stage.setTitle("選課系統");
    stage.setScene(scene);
    stage.setResizable(false);

    // Show Stage
    stage.show();   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        

    }
}//class