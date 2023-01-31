package com.example.myapplication.repositiry

import com.example.myapplication.model.FirstModel

class FirstRepositiry {
    private var firstModelList = mutableListOf<FirstModel>()

    fun getListOfText(): MutableList<FirstModel> {
        firstModelList.add(FirstModel("https://http.cat/100", "Continue"))
        firstModelList.add(FirstModel("https://http.cat/101", "Switching Protocols"))
        firstModelList.add(FirstModel("https://http.cat/102", "Processing"))
        firstModelList.add(FirstModel("https://http.cat/103", "Early Hints"))
        firstModelList.add(FirstModel("https://http.cat/200", "OK"))
        firstModelList.add(FirstModel("https://http.cat/201", "Created"))
        firstModelList.add(FirstModel("https://http.cat/202", "Accepted"))
        return firstModelList
    }
}