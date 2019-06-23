package com.example.householdaccountapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView

class TotalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "TotalActivity"

        var spinnerItems=intent.getStringArrayListExtra("SPINNER_ITEMS_KEY")
        var sum=intent.getIntegerArrayListExtra("SUM_KEY")
        println("sum="+sum)









    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
