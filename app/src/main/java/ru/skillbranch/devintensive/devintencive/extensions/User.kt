package ru.skillbranch.devintensive.devintencive.extensions

import ru.skillbranch.devintensive.devintencive.models.User
import ru.skillbranch.devintensive.devintencive.models.UserView
import ru.skillbranch.devintensive.devintencive.utils.Utils

fun User.toUserView() : UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials =  Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще не был" else if (isOnline) "Онлайн" else "Последний раз был ${lastVisit.humanizeDiff()})"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickname = nickName,
        status = status,
        initials = initials
    )
}

