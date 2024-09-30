package com.example.adoptapetapp.data

data class Pet(
    val name: String,
    val age: Int,
    val picture: Int,
    val description: String,
    val gender: String,
    var isClicked:Boolean = false
)
