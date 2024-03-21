package com.example.homework1.model
import kotlinx.serialization.Serializable


@Serializable
data class Contact(
    val avatarResId: Int,
    val name: String,
    val address: String,
    val job: String,
    val isChecked:Boolean = false
    )
