package com.example.householdaccountapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var spinnerItems=arrayOf("食事","娯楽")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, spinnerItems)

        val vg = findViewById<View>(R.id.tableLayout) as ViewGroup

        var k:Int=0

        button_add.setOnClickListener{

            getLayoutInflater().inflate(R.layout.table, vg)
            val tr = vg.getChildAt(k) as TableRow;

            //spinnerの処理
            ((tr.getChildAt(0))as Spinner).adapter = adapter
            //textviewに文字を格納
            ((tr.getChildAt(1)) as EditText).setText(k.toString())
            ((tr.getChildAt(2)) as EditText).setText(k.toString())
            ((tr.getChildAt(3)) as Button)?.setText("削除")
            //buttonの動的追加と押されたときの処理の記載
            ((tr.getChildAt(3)) as Button)?.setOnClickListener {

                vg.removeView(tr)
                k--
            }
            k++

        }
    }
}
