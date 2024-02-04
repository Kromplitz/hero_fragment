package com.example.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListFragment: Fragment() {


    private var onItemClick: (String) -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_all_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val api = ApiClient.client.create(ApiInterface::class.java)
        api.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ( {
                if ( it.isNotEmpty()){

                    val adapter = RecyclerViewAdapter(it as List<Hero>) {
                        onItemClick(it)
                    }
                    recyclerView.adapter = adapter
                }
            }, {
                Toast.makeText(view.context,"Error ${it.message}", Toast.LENGTH_LONG).show()

            })

        }
    fun setItemClickListener(lambda: (String) -> Unit){
        onItemClick = lambda
    }

}