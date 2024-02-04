package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  listfragment = supportFragmentManager.findFragmentById(R.id.listContainer) as ListFragment


        listfragment.setItemClickListener {
            val heroFragmentToADD = HeroFragment()
            heroFragmentToADD.setDescription(it)
            supportFragmentManager.beginTransaction()
                .add(R.id.listContainer, heroFragmentToADD)
                .commit()


        }

    }
}



