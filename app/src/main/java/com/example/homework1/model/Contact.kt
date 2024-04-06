package com.example.homework1.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable



 data class Contact(
    val avatarResId: Int,
    val name: String?,
    val address: String?,
    val job: String?,
    val isChecked:Boolean = false
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(avatarResId)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(job)
        parcel.writeByte(if (isChecked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}



