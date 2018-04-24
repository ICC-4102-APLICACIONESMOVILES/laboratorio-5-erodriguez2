package com.example.eduardo.lab1.Fragments


import android.arch.persistence.room.Room
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.eduardo.lab1.Form
import com.example.eduardo.lab1.FormAdapter
import com.example.eduardo.lab1.FormDatabase

import com.example.eduardo.lab1.R
import org.jetbrains.anko.find
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class AllFormsFragment : Fragment() {

    private lateinit var formDatabase: FormDatabase
    private lateinit var listForms: ListView
    private lateinit var listAdapter: FormAdapter
    private val DATABASE_NAME = "form_db"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_forms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listForms = view.find(R.id.listForms)
        formDatabase = Room.databaseBuilder(view.context,
                FormDatabase::class.java, DATABASE_NAME)
                .build()


        Thread(Runnable {
            val forms = formDatabase.daoAccess().getAllForms()
            val arrayListForm = ArrayList(forms)
            listAdapter = FormAdapter(view.context, R.layout.form_item_layout, arrayListForm)

            val mainHandler = Handler(activity!!.mainLooper)
            mainHandler.post({
                listForms.adapter = listAdapter
            })
        }).start()
    }

}// Required empty public constructor
