package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalcController {
	String input, input2; // used as placeholders for the input into the calculator
	String digitButton; //used to determine which value is to be added to the display label
	String memLocation; //latest value is stored in memory location, used for the memory functions
	boolean firstClick = true; //used to determine if the starting zero needs to be deleted.
	boolean hasDecimal = false; //used to make sure only one decimal is entered. 
	int operation = 0; //will be used to determine which operation to run.
	double result; //used to get the results after an operation is completed. 
	
	
	//FXML objects
	@FXML 
	private Label CalcLabelID;
	@FXML 
	private Button zeroButtonID;
	@FXML 
	private Button oneButtonID;
	@FXML 
	private Button twoButtonID;
	@FXML 
	private Button threeButtonID;
	@FXML 
	private Button fourButtonID;
	@FXML 
	private Button fiveButtonID;
	@FXML 
	private Button sixButtonID;
	@FXML 
	private Button sevenButtonID;
	@FXML 
	private Button eightButtonID;
	@FXML 
	private Button nineButtonID;
	@FXML 
	private Button addButtonID;
	@FXML 
	private Button subButtonID;
	@FXML 
	private Button multiplyButtonID;
	@FXML 
	private Button divideButtonID;
	@FXML 
	private Button equalsButtonID;
	
	@FXML
	public void decimalClicked(ActionEvent event) //What to do when the 0 button is pressed. 
	{
		if(hasDecimal == false)
		{
			digitButton = ".";
			userInputNumber(digitButton);
			hasDecimal = true;
		}
	}
	
	@FXML
	public void zeroClicked(ActionEvent event) //What to do when the 0 button is pressed. 
	{
		digitButton = "0";
		userInputNumber(digitButton);
	}
	
	@FXML
	public void oneClicked(ActionEvent event) //What to do when the 1 button is pressed. 
	{
		digitButton = "1";
		userInputNumber(digitButton);
	}
	
	@FXML
	public void twoClicked(ActionEvent event)  //What to do when the 2 button is pressed. 
	{
		digitButton = "2";
		userInputNumber(digitButton);
	}
	@FXML
	public void threeClicked(ActionEvent event) //What to do when the 3 button is pressed. 
	{
		digitButton = "3";
		userInputNumber(digitButton);
	}
	@FXML
	public void fourClicked(ActionEvent event) //What to do when the 4 button is pressed. 
	{
		digitButton = "4";
		userInputNumber(digitButton);
	}
	@FXML
	public void fiveClicked(ActionEvent event) //What to do when the 5 button is pressed. 
	{
		digitButton = "5";
		userInputNumber(digitButton);
	}
	@FXML
	public void sixClicked(ActionEvent event) //What to do when the 6 button is pressed. 
	{
		digitButton = "6";
		userInputNumber(digitButton);
	}
	@FXML
	public void sevenClicked(ActionEvent event) //What to do when the 7 button is pressed. 
	{
		digitButton = "7";
		userInputNumber(digitButton);
	}
	@FXML
	public void eightClicked(ActionEvent event) //What to do when the 8 button is pressed. 
	{
		digitButton = "8";
		userInputNumber(digitButton);
	}
	@FXML
	public void nineClicked(ActionEvent event) //What to do when the 9 button is pressed. 
	{
		digitButton = "9";
		userInputNumber(digitButton);
	}
	@FXML
	public void addClicked(ActionEvent event) //
	{
		operation = 1; //1 means add
		CalcLabelID.setText(""); //clears the old data
		firstClick = true;
		userInputNumber(digitButton);
	}
	@FXML
	public void subClicked(ActionEvent event)//2 means subtract
	{
		operation = 2;
		CalcLabelID.setText(""); //clears the old data
		firstClick = true;
		userInputNumber(digitButton);
	}
	@FXML
	public void multiplyClicked(ActionEvent event)//3 means multiply
	{
		operation = 3;
		CalcLabelID.setText(""); //clears the old data
		firstClick = true;
		userInputNumber(digitButton);
	}
	@FXML
	public void divideClicked(ActionEvent event)//4 means divide
	{
		operation = 4;
		CalcLabelID.setText(""); //clears the old data
		firstClick = true;
		userInputNumber(digitButton);
	}
	@FXML
	public void equalsClicked(ActionEvent event)//operation is used to determine course of action
	{
		switch(operation)
		{
			case 1:
				result = Double.parseDouble(input) + Double.parseDouble(input2);
				break;
			case 2:
				result = Double.parseDouble(input) - Double.parseDouble(input2);
				break;
			case 3:
				result = Double.parseDouble(input) * Double.parseDouble(input2);
				break;
			case 4:
				result = Double.parseDouble(input) / Double.parseDouble(input2);
				break;
		}
		if (operation != 0) //will only update the label if an arithmetic operation has been selected
		{
			CalcLabelID.setText(Double.toString(result));
			input = Double.toString(result);
		}
	}
	@FXML
	public void CEClicked(ActionEvent event) //resets the label
	{
		CalcLabelID.setText("");
	}
	@FXML
	public void CClicked(ActionEvent event) // resets the label, and the placeholders
	{
		CalcLabelID.setText("0");
		input = "";
		input2 = "";
		hasDecimal = false;
		firstClick = true;
		operation = 0;
	}
	@FXML
	public void MCClicked(ActionEvent event) //resets the value in memlocation
	{
		memLocation = "";
	}
	@FXML
	public void MRClicked(ActionEvent event) //recalls the memlocation and sets the label
	{
		CalcLabelID.setText(memLocation);
		input = memLocation;
	}
	@FXML
	public void MPlusClicked(ActionEvent event)//adds the current value to the one stored in memlocation
	{
		result = Double.parseDouble(input) + Double.parseDouble(memLocation);
		input = Double.toString(result);
	}
	
	
	
	public void userInputNumber(String digitButton) //used for getting the button pressed and puts it into the placeholder and the label.
	{

		if(operation == 0 && firstClick == false) //makes sure that its still the first input, and not the first button pressed. 
		{
			CalcLabelID.setText(CalcLabelID.getText() + digitButton);//adds the next digit to the current value in the label
			input = CalcLabelID.getText();
		}
		else if(operation == 0 && firstClick == true) //if the digit button is pressed and its the first time, removes the standard zero in the label
		{
			CalcLabelID.setText(digitButton);
			input = CalcLabelID.getText();
			memLocation = input;
		}
		else //if an operation has been pressed, this will run. storing the value in a different placeholder than the first. 
		{
			if (firstClick == true)
			{
				CalcLabelID.setText("");
				input2 = "";
				hasDecimal = false;
			}
			else
			{
				CalcLabelID.setText(CalcLabelID.getText() + digitButton);
				input2 = CalcLabelID.getText();
				memLocation = input;
			}
		}
		
		firstClick = false;//if this function has been called then it is no longer the firstClicked button. 
		
	}
	
	

	
}
