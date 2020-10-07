package com.example.firstco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstco.TestApi.User
import com.example.firstco.TestApi.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var recycleuser: RecyclerView
    private lateinit var mainActivityViewModel:TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        textView=findViewById(R.id.value)
        var fab:Button =findViewById(R.id.inc)
        mainActivityViewModel= ViewModelProviders.of(this).get(TestViewModel::class.java)
        mainActivityViewModel.countLiveData.observe(this, Observer { ff ->
            value.setText("Count is "+ff)
        })


        fab.setOnClickListener {
            mainActivityViewModel.getCurrentCount()
        }


        recycleuser = findViewById(R.id.RecycleViewUser)
        mainActivityViewModel.setDataUser()

        //var data:LiveData<List<User>> = mainActivityViewModel.getDataUser()
        var data : LiveData<java.util.List<User>?> = mainActivityViewModel.getUserDump()

        data.observe(this,Observer<java.util.List<User>?> {

            recycleuser.apply {
                adapter = UserAdapter(it)
                layoutManager = LinearLayoutManager(context)
            }
        })







    }




}

