package com.example.list

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class HeroFragment: Fragment() {

    private var description:String =""
    var titleTextView:TextView? = null
    var dataTextView:TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hero_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleTextView = view.findViewById(R.id.heroTitle)
        dataTextView = view.findViewById(R.id.heroData)
        titleTextView?.text = description

    }

    fun setDescription(title: String){
     description = title
    }



}