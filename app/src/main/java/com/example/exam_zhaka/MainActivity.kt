package com.example.exam_zhaka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() ,OnBtnClicked {


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()
    }

    override fun setText1(enterText: String,enterNum :String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("textF",enterText )
        bundle.putString("Num",enterNum)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }


}