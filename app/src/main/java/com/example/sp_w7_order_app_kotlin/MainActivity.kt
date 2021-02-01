package com.example.sp_w7_order_app_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var whipedcream: Boolean = false
    private var chocolatechecked: Boolean = false

    private var textView_ItemAmount: TextView? = null
    private var button_Plus: Button? = null
    private var button_Minus: Button? = null
    private var button_Order: Button? = null
    private var checkBox_Cream: CheckBox? = null
    private var checkBox_Chocolate: CheckBox? = null

    private var count: Int = 0

    private var textView_Reciept: TextView? = null
    private var textView_Toppings: TextView? = null
    private var editText_CustomerName: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_Plus = findViewById<Button>(R.id.plus)
        textView_ItemAmount = findViewById<TextView>(R.id.amount)
        button_Minus = findViewById<Button>(R.id.minus)
        checkBox_Cream = findViewById<CheckBox>(R.id.whipped_cream)
        checkBox_Chocolate = findViewById<CheckBox>(R.id.chocolate)
        button_Order = findViewById<Button>(R.id.order)
        textView_Reciept = findViewById<TextView>(R.id.reciept)
        editText_CustomerName = findViewById<TextView>(R.id.name_text)
        textView_Toppings = findViewById<TextView>(R.id.toppings)

        button_Plus?.setOnClickListener {
            count++
            textView_ItemAmount?.text = count.toString()
        }

        button_Minus?.setOnClickListener {
            if (count > 0) {
                count--
                textView_ItemAmount?.text = count.toString()
            }
        }

        checkBox_Cream?.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                    Log.d("Myapp", "Status of checkbox" + isChecked)
                    whipedcream = isChecked
                }


        checkBox_Chocolate?.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                    Log.d("Myapp", "Status of checkbox" + isChecked)
                    chocolatechecked = isChecked
        }

        button_Order?.setOnClickListener {
                    var total: Int = 0
                    if (whipedcream) {
                        total += 10
                    }
                    if (chocolatechecked) {
                        total += 5
                    }
                    total = total * count

            textView_Reciept?.text = "ORDER SUMMARY " +
                    "\n Person ${editText_CustomerName?.text} " +
                    "\n Add wipped cream? : $whipedcream" +
                    "\n Add chocolate? : $chocolatechecked" +
                    "\n Quantity: ${textView_ItemAmount?.text}" +
                    "\n Total: $total$ " +
                    "\n Thank you!!! "
                }
    }
}