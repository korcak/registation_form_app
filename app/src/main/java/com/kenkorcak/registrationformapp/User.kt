package com.kenkorcak.registrationformapp

data class User(
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val password: String
) : java.io.Serializable {

    fun getFullName() = "$title $firstName $lastName"

}
