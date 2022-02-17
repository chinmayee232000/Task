package com.example.rachtr_task

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        //var b=intent.getSerializableExtra("response")
        var d1:TextView=findViewById(R.id.r1)
        var d2:TextView=findViewById(R.id.r2)
        var d3:TextView=findViewById(R.id.r3)
        var d4:TextView=findViewById(R.id.r4)
        var d5:TextView=findViewById(R.id.r5)
        var d6:TextView=findViewById(R.id.r6)
        var d7:TextView=findViewById(R.id.r7)
        var d8:TextView=findViewById(R.id.r8)
        var d9:TextView=findViewById(R.id.r9)
        var d10:TextView=findViewById(R.id.r10)
        var d11:TextView=findViewById(R.id.r11)
        var d12:TextView=findViewById(R.id.r12)
        var out=findViewById<Button>(R.id.logout)

        Log.d(TAG, "onCreate: "+intent.getSerializableExtra("r1").toString())
        d1.text=intent.getSerializableExtra("r1").toString()
        //Log.d(TAG, "onCreate: "+intent.getSerializableExtra("r1").toString())
        d2.text=intent.getSerializableExtra("r2").toString()
        d3.text=intent.getSerializableExtra("r3").toString()
        d4.text=intent.getSerializableExtra("r4").toString()
        d5.text=intent.getSerializableExtra("r5").toString()
        d6.text=intent.getSerializableExtra("r6").toString()
        d7.text=intent.getSerializableExtra("r7").toString()
        d8.text=intent.getSerializableExtra("r8").toString()
        d9.text=intent.getSerializableExtra("r9").toString()
        d10.text=intent.getSerializableExtra("r10").toString()
        d11.text=intent.getSerializableExtra("r11").toString()
        d12.text=intent.getSerializableExtra("r12").toString()

        out.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                var back= Intent(this@Details,MainActivity::class.java)
                startActivity(back)
            }

        })
        //d13.text=intent.getSerializableExtra("r13").toString()
        //d14.text=intent.getSerializableExtra("r14").toString()
        //d15.text=intent.getSerializableExtra("r15").toString()
        //d16.text=intent.getSerializableExtra("r16").toString()

    }
}