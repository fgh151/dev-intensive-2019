package ru.skillbranch.devintencive.extensions

import ru.skillbranch.devintencive.models.User
import ru.skillbranch.devintencive.models.UserView
import ru.skillbranch.devintencive.utils.Utils

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

