package com.prototype.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.math.MathOps;

public class CalculatorController {
    @FXML
    private TextField displayText; //displays user input when selected or calculated value when calculation is run

    private String num1 = "";  //first number entered
    private String num2 = "";  //second number entered
    private boolean firstNum = true;  //use to keep track of before or after operator
    private String operator = ""; // "+", "-", "x", "/"

    @FXML
    protected void onButton1Click(ActionEvent event) { addNumber("1"); }
    @FXML
    protected void onButton21Click(ActionEvent event) { addNumber("2"); }
    @FXML
    protected void onButton3Click(ActionEvent event) { addNumber("3"); }
    @FXML
    protected void onButton4Click(ActionEvent event) { addNumber("4"); }
    @FXML
    protected void onButton5Click(ActionEvent event) { addNumber("5"); }
    @FXML
    protected void onButton6Click(ActionEvent event) { addNumber("6"); }
    @FXML
    protected void onButton7Click(ActionEvent event) { addNumber("7"); }
    @FXML
    protected void onButton8Click(ActionEvent event) { addNumber("8"); }
    @FXML
    protected void onButton9Click(ActionEvent event) { addNumber("9"); }
    @FXML
    protected void onButton0Click(ActionEvent event) { addNumber("0"); }
    @FXML
    protected void onAddButtonClick(ActionEvent event) { setOperator("+"); }
    @FXML
    protected void onSubtractButtonClick(ActionEvent event) { setOperator("-"); }
    @FXML
    protected void onMultiplyButtonClick(ActionEvent event) { setOperator("x"); }
    @FXML
    protected void onDivideButtonClick(ActionEvent event) { setOperator("/"); }
    @FXML
    protected void onEqualsButtonClick(ActionEvent event) { calculate(); }
    @FXML
    protected void onAllClearButtonClick(ActionEvent event) { clear(); }

    protected void addNumber (String number){
         if(firstNum){
             //don't want to add "0"s to the beginning
             if(num1 == "0"){
                 num1 = number;
             }
             else {
                 num1 += number;
             }
             displayText.setText(num1);
         }
         else{
             //don't want to add "0"s to the beginning
             if(num2 == "0") {
                 num2 = number;
             }
             else{
                 num2 += number;
             }
             displayText.setText(num2);
         }
    }

    protected void setOperator (String operator){
        if(firstNum) {
            this.operator = operator;
            // move on to the second number
            firstNum = false;
            displayText.setText(operator);
        }
    }

    protected void calculate(){
        switch (operator){
            case "+": int sum = (int) MathOps.add(Integer.parseInt(num1),Integer.parseInt(num2));
                        displayText.setText(Integer.toString(sum));
                        break;
            case "-": int difference = (int) MathOps.subtract(Integer.parseInt(num1),Integer.parseInt(num2));
                        displayText.setText(Integer.toString(difference));
                        break;
            case "x": int product = (int) MathOps.multiply(Integer.parseInt(num1),Integer.parseInt(num2));
                        displayText.setText(Integer.toString(product));
                        break;
            case "/": double quotient = MathOps.divide(Double.parseDouble(num1),Double.parseDouble(num2));
                        displayText.setText(Double.toString(quotient));
                        break;
        }
        //reset the variables, but keep the calculated number in the text field
        num1 = "0";
        num2 = "0";
        firstNum = true;
    }

    protected void clear(){
        //reset the variables and set the text field to "0"
        num1 = "0";
        num2 = "0";
        firstNum = true;
        displayText.setText("0");
    }

}