package com.example.eduardo.lab1

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull


@Entity
class Form {
    @PrimaryKey(autoGenerate = true)
    lateinit var id: Integer
    lateinit var name: String
    lateinit var date: String
    lateinit var category: String
    lateinit var comment: String
}