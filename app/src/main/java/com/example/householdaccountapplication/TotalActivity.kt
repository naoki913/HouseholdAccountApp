package com.example.householdaccountapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*

class TotalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "TotalActivity"

        var spinnerItems=intent.getStringArrayListExtra("SPINNER_ITEMS_KEY")
        var sum=intent.getIntegerArrayListExtra("SUM_KEY")

        var texts: Array<TextView?> = arrayOfNulls(spinnerItems.size)
        val layout: FrameLayout = findViewById(R.id.totalTableLayout)

        for (i in 0..spinnerItems.size-1){
            texts[i] = TextView(this)
            texts[i]?.text = spinnerItems[i]+"　：　"+sum[i]+"円"
            texts[i]?.setTextSize(30f)
            texts[i]?.y =50.0f + 150.0f*i
            layout.addView( texts[i], LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 150*spinnerItems.size))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
