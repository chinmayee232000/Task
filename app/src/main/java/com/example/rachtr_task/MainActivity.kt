package com.example.rachtr_task

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var name: EditText
    lateinit var pass: EditText
    lateinit var login:Button
    lateinit var value:String
    var b=Bundle()
    lateinit var next: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        pass = findViewById(R.id.pass)
        name = findViewById(R.id.name)
        login=findViewById(R.id.button)
        val options = resources.getStringArray(R.array.options_array)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, options
            )
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                value=options[position]
                Log.d(TAG, "onItemSelected: "+options[position].toString())

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        login.setOnClickListener(object:View.OnClickListener {
            override fun onClick(p0: View?) {
                converter(value)

            }

        })



    }

    private fun converter(option: String) {
        Log.d(TAG, "converter: ")
        val BASE_URL="https://uatrelwebapi.azurewebsites.net/api/user/user/"
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(ApiInterface::class.java)
        var rq=RequestClass(name.text.toString(),pass.text.toString(),option.toString())
        Log.d(TAG, "converter: request"+rq.userName+rq.password+rq.userType)
        val retrofitData=retrofitBuilder.getData(rq)
        retrofitData.enqueue(object : Callback<pojo> {
            override fun onResponse(
                    call: Call<pojo>,
                    response: Response<pojo>
            ) {
                if (response != null) {
                    if(response.body()!=null) {
                        Log.d(TAG, "onResponse: " + response.body().bandName)
                        Log.d(ContentValues.TAG, "onResponse: " + response.body().toString())
                        Log.d(TAG, "onResponse: " + response.body().bandId)
                        b.putSerializable("r1", response.body().bandId.toString())

                        b.putSerializable("r2", response.body().bandName)
                        b.putSerializable("r3", response.body().careTaker)
                        b.putSerializable("r4", response.body().departmentId)
                        b.putSerializable("r5", response.body().departmentName)
                        b.putSerializable("r6", response.body().isActive)
                        b.putSerializable("r7", response.body().isDeleted)
                        b.putSerializable("r8", response.body().region)
                        b.putSerializable("r9", response.body().reporting)
                        b.putSerializable("r10", response.body().territory)
                        b.putSerializable("r11", response.body().userEmail)
                        b.putSerializable("r12", response.body().userId.toString())
                        next = Intent(this@MainActivity, Details::class.java)
                        next.putExtras(b)
                        startActivity(next)
                        // b.putSerializable("r13", response.body().userState)
                        //b.putSerializable("r14", response.body().address.toString())
                        //b.putSerializable("r15", response.body().contactNumber.toString())
                        //b.putSerializable("r16", response.body().userType)
                    }
                    else
                    {
                        Toast.makeText(this@MainActivity,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.d(TAG, "onResponse: response body null")
                }
            }

            override fun onFailure(call: Call<pojo>, t: Throwable?) {
                if (t != null) {
                    Log.d(TAG, "onFailure: " + t.message.toString())
                }
            }
        })

    }
}