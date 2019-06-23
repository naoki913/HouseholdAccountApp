package com.example.householdaccountapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val spinnerItems=arrayOf("食事","娯楽")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, spinnerItems)

        //var temp1:Int=10;
        //var temp2:Int
        //var minus:ArrayList<Int> =arrayListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        val vg = findViewById<View>(R.id.tableLayout) as ViewGroup
        /*
        for (i in 0 until 5 ){
            getLayoutInflater().inflate(R.layout.table, vg)
            val tr = vg.getChildAt(i) as TableRow;

            //spinnerの処理
            ((tr.getChildAt(0))as Spinner).adapter = adapter
            //textviewに文字を格納
            ((tr.getChildAt(1)) as EditText).setText(i.toString())
            ((tr.getChildAt(2)) as EditText).setText(i.toString())
            ((tr.getChildAt(3)) as Button)?.setText("削除")
            //buttonの動的追加と押されたときの処理の記載
            ((tr.getChildAt(3)) as Button)?.setOnClickListener {
                //この中に処理を書きます
                //println(((tr.getChildAt(1)) as Button).id)
                temp2=i

                for(j in 0 until 5){
                    if(temp1<j){
                        minus[j]++

                    }
                }
                    temp2 -= minus[i]
                vg.removeViewAt(temp2)
                temp1=i
            }

        }
        */
        var k:Int=0

        button_aaa.setOnClickListener{

            println("aaa")
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
                //この中に処理を書きます
                //println(((tr.getChildAt(1)) as Button).id)
                /*

                temp2=k

                for(j in 0 until 6){
                    if(temp1<j){
                        minus[j]++

                    }
                }
                temp2 -= minus[k]
                vg.removeViewAt(temp2)
                minus.removeAt(temp2)
                k--
                temp1=k
            }*/
                vg.removeView(tr)
                k--
            }
            k++

        }
    }
}
