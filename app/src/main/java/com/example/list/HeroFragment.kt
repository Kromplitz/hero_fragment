package com.example.list

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.bumptech.glide.Glide

class HeroFragment: Fragment() {

    private var description:String =""
    private var titleTextView:TextView? = null
    private var dataTextView:TextView? = null
    private var imageView:ImageView? = null
    private var heroImageUrl:String = ""

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
        imageView = view.findViewById(R.id.heroImage)

        Glide.with(view.context)
            .load(heroImageUrl)
            .into(imageView!!)

        titleTextView?.text = description

    }
    fun setDescription(title: String, image: String){
     description = title
        heroImageUrl = image
    }



}