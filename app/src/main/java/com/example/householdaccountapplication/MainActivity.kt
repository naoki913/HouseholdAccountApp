package com.example.householdaccountapplication

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType.TYPE_CLASS_NUMBER

import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var spinnerItems=arrayListOf("食事","娯楽")

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
            //((tr.getChildAt(1)) as EditText).setText(k.toString())
            ((tr.getChildAt(2)) as EditText).setText("0")
            ((tr.getChildAt(2)) as EditText).setInputType(TYPE_CLASS_NUMBER)
            ((tr.getChildAt(3)) as Button)?.setText("削除")
            //buttonの動的追加と押されたときの処理の記載
            ((tr.getChildAt(3)) as Button)?.setOnClickListener {
                vg.removeView(tr)
                k--
            }
            k++
        }

        button_genre.setOnClickListener{
            val myedit = EditText(this)
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("追加する項目を入力してください")
            dialog.setView(myedit)
            dialog.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                // OKボタン押したときの処理
                var isEqual:Boolean=false
                val text = myedit.getText().toString()
                for(word in spinnerItems){
                    if(word==text){
                        isEqual=true
                    }
                }
                if(isEqual==false) {
                    spinnerItems.add(text)
                }
            })
            dialog.setNegativeButton("キャンセル", null)
            dialog.show()
        }

        button_total.setOnClickListener {
            //ジャンルごとの合計金額の計算
            var sum= arrayListOf(0)
            for(i in 0..spinnerItems.size-1){
                sum.add(0)
            }

            //var sum=Array<Int>(spinnerItems.size,{0})
            for(v in 0.. vg.childCount-1){
                val tr=vg.getChildAt(v) as TableRow;
                val selectedGenre=((tr.getChildAt(0))as Spinner).selectedItem

                for(num in 0..spinnerItems.size-1){
                    if(selectedGenre==spinnerItems.get(num)){
                        val price:Int=Integer.parseInt(((tr.getChildAt(2)) as EditText).text.toString())
                        sum[num] += price
                    }
                }
            }

            //画面遷移
            val intent = Intent(this,TotalActivity::class.java)
            intent.putExtra("SPINNER_ITEMS_KEY",spinnerItems)
            intent.putExtra("SUM_KEY",sum)

            startActivity(intent)



        }




    }


}

