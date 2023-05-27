package com.example.jsonplaceholderworking.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val email: String?,
    val id: Int?,
    val name: String?,
    val phone: String?,
    val username: String?,
    val website: String?,
    val address : Address?,
    val company: Company?
) : Parcelable

@Parcelize
data class Address(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipCode: String?,
    val geo: Geo?
) : Parcelable

@Parcelize
data class Company(
    val name: String?,
    val catchPhrase: String?,
    val bs: String?
) : Parcelable

@Parcelize
data class Geo(
    val lat: String?,
    val lng: String?
) : Parcelable