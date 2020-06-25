import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class LogPage extends Application{

    @Override
    public void start(Stage primaryStage) {
        primaryStage.hide();
        page1();
    }

    public void page1(){
        //Layout
	GridPane grid = new GridPane(); //Grid排版
	grid.setAlignment(Pos.CENTER); //Layout置中
	grid.setHgap(10); //水平距離
	grid.setVgap(10); //垂直距離
    Label prompt = new Label("請輸入學號密碼:");
    Label IDStr = new Label("學號:");
    Label passwordStr = new Label("密碼:");
    PasswordField password = new PasswordField();
    password.setPromptText("請輸入密碼");
    TextField ID = new TextField();
    ID.setPromptText("請輸入學號");
    Button logbtn = new Button("登入");
    Button leavebtn = new Button("離開");
 
	grid.setPadding(new Insets(10, 10, 10, 10)); //填充邊界。Insets定義上、右、下、左四個方向的長度。
 
	//用Layout作為Scene的root node
    Scene scene = new Scene(grid, 450, 435);
    Stage stage = new Stage();

    //GUI元件
    grid.add(prompt, 0, 0);
    grid.add(IDStr, 0, 1);
    grid.add(ID, 1, 1);
    grid.add(passwordStr, 0, 3);
    grid.add(password, 1, 3);
    grid.add(logbtn, 0, 5);
    grid.add(leavebtn, 1, 5);
    logbtn.setOnAction(e->
    {
        StudentDB db = new StudentDB();
        if (db.judgeAccount(ID.getText(), password.getText()) == true) {
            SelectPage s = new SelectPage();
            s.selectPage(ID.getText());
            stage.close();
        } else {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("錯誤");
            alert.setHeaderText("帳號密碼有誤！！");
            alert.setContentText("請重新輸入您的學號與密碼。");
            alert.showAndWait();
        }
    });	
    leavebtn.setOnAction(e->
    {
        stage.close();
    });
        // Set the title of Stage
    stage.setTitle("SRS");
    stage.setScene(scene);
    stage.setResizable(false);

    // Show Stage
    stage.show();   
    }
    public static void main(String[] args)
    {
        launch(args); 
    }//main
}//class