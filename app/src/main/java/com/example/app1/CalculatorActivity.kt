package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var buttonAdd:Button
    lateinit var fnum:EditText
    lateinit var snum:EditText
    lateinit var textanswer:TextView
    lateinit var buttonSubtract:Button
    lateinit var buttonMultiply:Button
    lateinit var buttonDivide:Button
    lateinit var buttonPi:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        buttonAdd=findViewById(R.id.btn_add)
        fnum=findViewById(R.id.edt_fnum)
        snum=findViewById(R.id.edt_snum)
        textanswer=findViewById(R.id.txt_Answer)
        buttonSubtract=findViewById(R.id.btn_subtract)
        buttonDivide=findViewById(R.id.btn_divide)
        buttonMultiply=findViewById(R.id.btn_multipy)
        buttonPi=findViewById(R.id.btn_pi)

        buttonAdd.setOnClickListener {
            var fnum=fnum.text.toString()
            var snum=snum.text.toString()
            if (fnum.isEmpty() && snum.isEmpty()){
                textanswer.text="Oops"

            }else {
                var answer=fnum.toDouble()+ snum.toDouble()
                textanswer.text=answer.toString()
            }

        }
        buttonSubtract.setOnClickListener {
            var fnum = fnum.text.toString()
            var snum = snum.text.toString()
            if (fnum.isEmpty() && snum.isEmpty()) {
                textanswer.text = "Oops"

            } else {
                var answer = fnum.toDouble() - snum.toDouble()
                textanswer.text = answer.toString()
            }
        }
        buttonDivide.setOnClickListener {
            var fnum = fnum.text.toString()
            var snum = snum.text.toString()
            if (fnum.isEmpty() && snum.isEmpty()) {
                textanswer.text = "Oops"

            } else {
                var answer = fnum.toDouble() / snum.toDouble()
                textanswer.text = answer.toString()
            }
        }
        buttonMultiply.setOnClickListener {
            var fnum = fnum.text.toString()
            var snum = snum.text.toString()
            if (fnum.isEmpty() && snum.isEmpty()) {
                textanswer.text = "Oops"

            } else {
                var answer = fnum.toDouble() * snum.toDouble()
                textanswer.text = answer.toString()
            }
        }
        buttonPi.setOnClickListener {
            var fnum = fnum.text.toString()
            val pi=(3.14)
            if  (fnum.isEmpty()){
                textanswer.text="Oops"
            }else{
                var answer=fnum.toDouble() *pi.toDouble()
                textanswer.text= answer.toString()
            }

        }
    }
}