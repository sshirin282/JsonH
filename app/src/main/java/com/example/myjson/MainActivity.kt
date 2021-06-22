package com.example.myjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.Error
import javax.xml.transform.ErrorListener

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3: TextView
    val url:String="https://api.androidhive.info/volley/person_object.json"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.text)
        textView1=findViewById(R.id.text1)
        textView2=findViewById(R.id.text2)
        textView3=findViewById(R.id.text3)
        val request:StringRequest= StringRequest(Request.Method.GET,url, {
                response ->
            Log.e("response>>>", response)
            JSONObject(response)
            val jsonObject:JSONObject= JSONObject(response)
            val name:String=jsonObject.getString("name")
            textView.text=name
            val email:String=jsonObject.getString("email")
            textView1.text=email
            val jsonObject1:JSONObject=jsonObject.getJSONObject("phone")
            val home:String=jsonObject1.getString("home")
            textView2.text=home
            Log.e("home>>>",home)
            val mobile:String=jsonObject1.getString("mobile")
            textView3.text=mobile
            Log.e("mobile>>>",mobile)

        },Response.ErrorListener {

        })
        val  requestQueue = Volley.newRequestQueue(this)
        requestQueue?.add(request)
    }
}