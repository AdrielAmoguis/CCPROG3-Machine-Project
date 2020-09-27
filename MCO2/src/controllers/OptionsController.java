package controllers;

import thatslife.ThatsLife;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.lang.Math;

public class OptionsController implements EventHandler<Event>
{
	@FXML Button backButton;
	@FXML Slider actionCardsSlider;
	@FXML Slider salaryCardsSlider;
	@FXML Label numActionCards;
	@FXML Label numSalaryCards;
	
	@FXML
	void initialize()
	{
		// Set the slider onChangeEvent
		actionCardsSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
			{
				numActionCards.setText(String.valueOf(Math.round(Math.ceil((Double)newVal))));
			}
		});
		salaryCardsSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
			{
				numSalaryCards.setText(String.valueOf(Math.round(Math.ceil((Double)newVal))));
			}
		});
		
		// Set the slider values
		
		// ActionCards
		for(String arg : ThatsLife.args)
        {        	
        	if(arg.startsWith("actionCards"))
        	{
        		String nCards = arg.substring("actionCards=".length());
        		numActionCards.setText(nCards);
        		actionCardsSlider.setValue(Double.parseDouble(nCards));
        	}
        }
		
		// SalaryCards
		for(String arg : ThatsLife.args)
        {        	
        	if(arg.startsWith("salaryCards"))
	       	{
	      		String nCards = arg.substring("salaryCards=".length());
        		numSalaryCards.setText(nCards);
	       		salaryCardsSlider.setValue(Double.parseDouble(nCards));
	       	}
        }
	}
	
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	private void handle(ActionEvent ev)
	{
		// Buttons
		if(ev.getSource() instanceof Button)
		{
			Button eventSource = (Button) ev.getSource();
			
			// Buttons
			switch(eventSource.getId())
			{
				case "backButton":
					
					// Update changes
					
					// ActionCards
					boolean found = false;
					for(String arg : ThatsLife.args)
					{
						if(arg.startsWith("actionCards"))
						{
							ThatsLife.args.set(ThatsLife.args.indexOf(arg), new String("actionCards=" + numActionCards.getText()));
							found = true;
						}
					}
					if(!found)
						ThatsLife.args.add(new String("actionCards=" + numActionCards.getText()));
					
					// SalaryCards
					found = false;
					for(String arg : ThatsLife.args)
					{
						if(arg.startsWith("salaryCards"))
						{
							ThatsLife.args.set(ThatsLife.args.indexOf(arg), new String("salaryCards=" + numSalaryCards.getText()));
							found = true;
						}
					}
					if(!found)
						ThatsLife.args.add(new String("salaryCards=" + numSalaryCards.getText()));
					
					try
					{
						// Swap this stage with the main
						Stage primaryStage = (Stage) eventSource.getScene().getWindow();
						
						FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/MainMenu.fxml"));
						Parent root = newLoader.load();
						primaryStage.setTitle("Main Menu - That's Life!");
						primaryStage.setResizable(false);
						primaryStage.setScene(new Scene(root));
						primaryStage.show();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					break;
			}
		}
	}	
}
