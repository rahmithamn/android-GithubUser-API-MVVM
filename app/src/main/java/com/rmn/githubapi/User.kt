package com.rmn.githubapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var username: String,
    var follower: Int,
    var following: Int,
    var photo: String
) : Parcelable