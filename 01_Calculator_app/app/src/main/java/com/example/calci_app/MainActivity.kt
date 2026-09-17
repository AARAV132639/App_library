package com.example.calci_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Calculator(){

    fun add(a: Double, b: Double): Double{
        return a+b;
    }

    fun subtract(a:Double, b: Double):Double{
        return a-b;
    }

    fun multiply(a: Double, b: Double):Double{
        return a*b;
    }

}

class MainActivity: ComponentActivity()
{
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

        setContent{
            CalculatorScreen()
        }
    }
}

@Composable
fun CalculatorScreen(){



    var display by remember{
        mutableStateOf("0")
    }

    var firstNumber by remember{
        mutableStateOf<Double?>(null)
    }

    var operator by remember {
        mutableStateOf<String?>(null)
    }

    fun selectOperator(newOperator: String){
        firstNumber = display.toDouble()
        operator = newOperator
        display="0"
    }

    fun enterNumber(number:String)
    {
        display = if(display=="0"){number}
        else{display+number}
    }

    fun calculate(){

        val first = firstNumber?:return
        val second = display.toDouble()
        val selectedOperator = operator?:return

        val calculator = Calculator()

        try{
            val result = when(selectedOperator){
                "+"->calculator.add(first,second)
                "-"->calculator.subtract(first,second)
                "*"->calculator.multiply(a=first, b= second)

                else -> return
            }

            display = result.toString()

            firstNumber = null
            operator = null

        }catch(e: ArithmeticException){
            display="Error"
            firstNumber = null
            operator = null
        }
    }

    Column( modifier = Modifier.fillMaxSize().padding(16.dp),verticalArrangement = Arrangement.Bottom){

        Text(text= display, fontSize = 48.sp, modifier = Modifier.fillMaxWidth().padding(16.dp))

        Row( modifier = Modifier.fillMaxWidth()) {

            CalculatorButton("7") {
                enterNumber("7")
            }

            CalculatorButton("8") {
              //  display += "8"
                enterNumber("8")
            }

            CalculatorButton("9") {
               // display += "9"
                enterNumber("9")
            }

            CalculatorButton("/") {
                selectOperator("/")
            }
        }


        Row(modifier = Modifier.fillMaxWidth()) {

            CalculatorButton("4") {
               // display += "4"
                enterNumber("4")
            }

            CalculatorButton("5") {
               // display += "5"
                enterNumber("5")
            }

            CalculatorButton("6") {
              //  display += "6"
                enterNumber("6")
            }

            CalculatorButton("*") {
                selectOperator("*")
            }
        }


        Row(modifier = Modifier.fillMaxWidth()) {

            CalculatorButton("1") {
                //display += "1"
                enterNumber("1")
            }

            CalculatorButton("2") {
               // display += "2"
                enterNumber("2")
            }

            CalculatorButton("3") {
               //display += "3"
                enterNumber("3")
            }

            CalculatorButton("-") {
                selectOperator("-")
            }
        }


        Row( modifier = Modifier.fillMaxWidth()) {
            CalculatorButton("0") {
                enterNumber("0")
            }

            CalculatorButton("C") {
                display = "0"
                firstNumber = null
                operator = null
            }

            CalculatorButton("=") {
                calculate()
            }

            CalculatorButton("+") {
                selectOperator("+")
            }
        }
    }
}

@Composable
fun RowScope.CalculatorButton(text:String, onClick:()->Unit)
{
    Button(onClick=onClick, modifier = Modifier.weight(1f).padding(4.dp))
    {
        Text(text=text,fontSize=24.sp)
    }
}





