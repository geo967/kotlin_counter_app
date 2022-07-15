package com.example.counter_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var inputNumber1:String
    lateinit var inputNumber2:String


    override fun onCreate(savedInstanceState: Bundle?) {
       val binding= ActivityMainBinding.inflate(layoutInflater)
       val rootActivity=binding.root
        super.onCreate(savedInstanceState)
        setContentView(rootActivity)


        binding.imageButton1.setOnClickListener {
          inputNumber1=binding.inputText.text.toString().trim()
            var n:Int = if(inputNumber1 == "") 0 else Integer.parseInt(inputNumber1)
            n += 1
            inputNumber1=n.toString()
            binding.inputText.setText(n.toString())
        }
        binding.imageButton2.setOnClickListener {
            inputNumber1=binding.inputText.text.toString().trim()
            var n:Int = if(inputNumber1 == "") 0 else Integer.parseInt(inputNumber1)
            if(n==0){
                Toast.makeText(this,"negative!!!",Toast.LENGTH_SHORT).show()
            }
            else
            { n -= 1
            inputNumber1=n.toString()}
            binding.inputText.setText(n.toString())
        }
        binding.reset.setOnClickListener {
            binding.inputText.setText("0")
        }

        //for max mark
        binding.plusButtonForMaxMark.setOnClickListener {
            inputNumber2=binding.inputMaxMark.text.toString().trim()
            var n:Int = if(inputNumber2 == "") 0 else Integer.parseInt(inputNumber2)
            n += 1
            inputNumber2=n.toString()
            binding.inputMaxMark.setText(n.toString())
        }
        binding.minusButtonForMaxMark.setOnClickListener {
            inputNumber2=binding.inputMaxMark.text.toString().trim()
            var n:Int = if(inputNumber2 == "") 0 else Integer.parseInt(inputNumber2)
            if(n==0){
                Toast.makeText(this,"negative!!!",Toast.LENGTH_SHORT).show()
            }
            else
            { n -= 1
            inputNumber2=n.toString()}
            binding.inputMaxMark.setText(n.toString())
        }
        binding.resetButtonForMaxMark.setOnClickListener {
            binding.inputMaxMark.setText("0")
        }


        //result button
        binding.resultButtonId.setOnClickListener {
            val result=(binding.inputText.text.toString().trim().toInt()*100/binding.inputMaxMark.text.toString().trim().toInt())
            binding.outputId.text = String.format("output is : %d",result)
        }

    }
}