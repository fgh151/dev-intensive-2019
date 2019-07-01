package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {

    constructor(
        id: String,
        firstName: String?,
        lastName: String?
    ) : this(id = id, firstName = firstName, lastName = lastName, avatar = null)

    constructor(id: String) : this(id, "John", "Doe")

    init {
    }

    companion object Factory {
        private var lastId : Int = -1;
        fun makeUser(fullName:String?) : User {
            lastId++;
            val (firstName , lastName) = Utils.parseFullName(fullName)
            return User(id = "${lastId}", firstName = firstName, lastName = lastName)
        }



        //Builder
        private var name: String? = null;
        private var lName: String? = null
        private var lavatar: String? = null
        private var lrating: Int = 0
        private var lrespect: Int = 0
        private var ldate: Date? = null
        private var lIsOnline: Boolean = false

        fun firstName(value: String) : Factory {
            name = value
            return this
        }

        fun lastName(value: String) : Factory {
            lName = value
            return this
        }

        fun avatar(value: String) : Factory {
            this.lavatar = value
            return this
        }

        fun rating(rating: Int) : Factory {
            lrating = rating
            return this;
        }

        fun respect(respect: Int) : Factory {
            lrespect = respect
            return this;
        }

        fun lastVisit(date : Date?) : Factory {
            ldate = date
            return this
        }

        fun isOnline(online: Boolean = false) : Factory {
            lIsOnline = online
            return this
        }

        fun build() : User {
            lastId++;
            return User(lastId.toString(), name, lName, avatar = lavatar, rating = lrating, respect = lrespect, lastVisit = ldate, isOnline = lIsOnline)
        }


    }




}