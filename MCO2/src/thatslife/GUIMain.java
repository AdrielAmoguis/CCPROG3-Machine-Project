package thatslife;
	
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.fxml.*;


public class GUIMain extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/MainMenu.fxml"));
			AnchorPane root = (AnchorPane) fxmlLoader.load();
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Main Menu - That's Life! (AMOGUIS - S13B)");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		// Launch the model
		launch(args);
	}
}
