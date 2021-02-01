package com.example.sp_w7_order_app_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var whipedcream: Boolean = false
    private var chocolatechecked: Boolean = false
    private var textView: TextView? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var order: Button? = null
    private var cream: CheckBox? = null
    private var chocolate: CheckBox? = null
    private var count: Int = 0
    private var reciept: TextView? = null
    private var toppings: TextView? = null
    private var editText: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById<Button>(R.id.plus)
        textView = findViewById<TextView>(R.id.amount)
        button2 = findViewById<Button>(R.id.minus)
        cream = findViewById<CheckBox>(R.id.whipped_cream)
        chocolate = findViewById<CheckBox>(R.id.chocolate)
        order = findViewById<Button>(R.id.order)
        reciept = findViewById<TextView>(R.id.reciept)
        editText = findViewById<TextView>(R.id.name_text)
        toppings = findViewById<TextView>(R.id.toppings)

        button1?.setOnClickListener {
            count++
            textView?.text = count.toString()
        }

        button2?.setOnClickListener {
            if (count > 0) {
                count--
                textView?.text = count.toString()
            }
        }

        cream?.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                    Log.d("Myapp", "Status of checkbox" + isChecked)
                    whipedcream = isChecked
                }


        chocolate?.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                    Log.d("Myapp", "Status of checkbox" + isChecked)
                    chocolatechecked = isChecked
        }

        order?.setOnClickListener {
                    var total: Int = 0
                    if (whipedcream) {
                        total += 10
                    }
                    if (chocolatechecked) {
                        total += 5
                    }
                    total = total * count

                    reciept?.setText(
                        "ORDER SUMMARY " +
                                "\n Person ${editText?.text} " +
                                "\n Add wipped cream? : $whipedcream" +
                                "\n Add chocolate? : $chocolatechecked" +
                                "\n Quantity: ${textView?.text}" +
                                "\n Total: $total$ " +
                                "\n Thank you!!! "
                    )
                }
    }
}