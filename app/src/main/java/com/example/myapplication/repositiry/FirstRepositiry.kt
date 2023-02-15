package com.example.myapplication.repositiry

import com.example.myapplication.model.MainModel


class FirstRepositiry {
    private var firstModelList = mutableListOf<MainModel>()

    fun getListOfText(): MutableList<MainModel> {
        firstModelList.add(MainModel("https://http.cat/100", "Continue"))
        firstModelList.add(MainModel("https://http.cat/101", "Switching Protocols"))
        firstModelList.add(MainModel("https://http.cat/102", "Processing"))
        firstModelList.add(MainModel("https://http.cat/103", "Early Hints"))
        firstModelList.add(MainModel("https://http.cat/200", "OK"))
        firstModelList.add(MainModel("https://http.cat/201", "Created"))
        firstModelList.add(MainModel("https://http.cat/202", "Accepted"))
        return firstModelList
    }
}