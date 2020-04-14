package kedia.pk.kakcho

import com.google.gson.annotations.SerializedName

class Hero {
    @SerializedName("name")
    var name:String = ""

    var realname:String =""
    var team:String = ""
    var firstappearance:String = ""
    var createdby:String = ""
    var publisher:String = ""
    var imageurl:String = ""
    var bio:String = ""
}