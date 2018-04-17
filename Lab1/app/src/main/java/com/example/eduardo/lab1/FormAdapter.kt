package com.example.eduardo.lab1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.graphics.Movie
import android.view.LayoutInflater
import android.support.annotation.NonNull
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.util.Log
import org.jetbrains.anko.find


class FormAdapter(private val mContext: Context, resource: Int, list: ArrayList<Form>) : ArrayAdapter<Form>(mContext, resource, list) {
    private var formsList = ArrayList<Form>()
    private var resourceLayout = 0

    init {
        formsList = list
        resourceLayout = resource
    }

    override fun getView(position: Int, @Nullable view: View?, parent: ViewGroup): View {
        var listItem = view

        val currentForm = formsList[position]
        Log.d("currentForm", currentForm.toString())

        val name = listItem!!.find(R.id.nameForm) as TextView
        name.text = currentForm.name

        val date = listItem!!.find(R.id.dateForm) as TextView
        date.text = currentForm.date

        val comment = listItem!!.find(R.id.commentForm) as TextView
        comment.text = currentForm.comment

        return listItem
    }
}