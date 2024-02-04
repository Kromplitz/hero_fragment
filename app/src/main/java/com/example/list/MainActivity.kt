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


        listfragment.setItemClickListener { name, image ->
            val heroFragmentToADD = HeroFragment()
            heroFragmentToADD.setDescription(name, image)
            supportFragmentManager.beginTransaction()
                .add(R.id.listContainer, heroFragmentToADD)
                .addToBackStack("hero_fragment")
                .commit()


        }

    }
}



