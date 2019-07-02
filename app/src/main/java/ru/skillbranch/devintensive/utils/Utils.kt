package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName:String?) : Pair<String?, String?> {
        var list = fullName?.split(" ")
        val firstName = list?.getOrNull(0)
        val lastName = list?.getOrNull(1)
        return Pair(if(firstName == "" || firstName == " ") null else firstName, if(lastName == "" || lastName == " ") null else lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {

        var lat: String

        //Lower case letters
        lat = payload.replace("а".toRegex(), "a")
        lat = lat.replace("б".toRegex(), "b")
        lat = lat.replace("в".toRegex(), "v")
        lat = lat.replace("г".toRegex(), "g")
        lat = lat.replace("д".toRegex(), "d")
        lat = lat.replace("е".toRegex(), "e")
        lat = lat.replace("ё".toRegex(), "e")
        lat = lat.replace("ж".toRegex(), "zh")
        lat = lat.replace("з".toRegex(), "z")
        lat = lat.replace("и".toRegex(), "i")
        lat = lat.replace("й".toRegex(), "i")
        lat = lat.replace("к".toRegex(), "k")
        lat = lat.replace("л".toRegex(), "l")
        lat = lat.replace("м".toRegex(), "m")
        lat = lat.replace("н".toRegex(), "n")
        lat = lat.replace("о".toRegex(), "o")
        lat = lat.replace("п".toRegex(), "p")
        lat = lat.replace("р".toRegex(), "r")
        lat = lat.replace("с".toRegex(), "s")
        lat = lat.replace("т".toRegex(), "t")
        lat = lat.replace("у".toRegex(), "u")
        lat = lat.replace("ф".toRegex(), "f")
        lat = lat.replace("х".toRegex(), "kh")
        lat = lat.replace("ц".toRegex(), "ts")
        lat = lat.replace("ч".toRegex(), "ch")
        lat = lat.replace("ш".toRegex(), "sh")
        lat = lat.replace("щ".toRegex(), "shch")
        lat = lat.replace("ъ".toRegex(), "ie")
        lat = lat.replace("ы".toRegex(), "y")
        lat = lat.replace("ь".toRegex(), "-")
        lat = lat.replace("э".toRegex(), "e")
        lat = lat.replace("ю".toRegex(), "iu")
        lat = lat.replace("я".toRegex(), "ia")

        //Capital letters
        lat = lat.replace("А".toRegex(), "A")
        lat = lat.replace("Б".toRegex(), "B")
        lat = lat.replace("В".toRegex(), "V")
        lat = lat.replace("Г".toRegex(), "G")
        lat = lat.replace("Д".toRegex(), "D")
        lat = lat.replace("Е".toRegex(), "E")
        lat = lat.replace("Ё".toRegex(), "E")
        lat = lat.replace("Ж".toRegex(), "ZH")
        lat = lat.replace("З".toRegex(), "Z")
        lat = lat.replace("И".toRegex(), "I")
        lat = lat.replace("Л".toRegex(), "I")
        lat = lat.replace("К".toRegex(), "K")
        lat = lat.replace("Л".toRegex(), "L")
        lat = lat.replace("М".toRegex(), "M")
        lat = lat.replace("Н".toRegex(), "N")
        lat = lat.replace("О".toRegex(), "O")
        lat = lat.replace("П".toRegex(), "P")
        lat = lat.replace("Р".toRegex(), "R")
        lat = lat.replace("С".toRegex(), "S")
        lat = lat.replace("Т".toRegex(), "T")
        lat = lat.replace("У".toRegex(), "U")
        lat = lat.replace("Ф".toRegex(), "F")
        lat = lat.replace("Х".toRegex(), "KH")
        lat = lat.replace("Ц".toRegex(), "TS")
        lat = lat.replace("Ч".toRegex(), "CH")
        lat = lat.replace("Ш".toRegex(), "SH")
        lat = lat.replace("Щ".toRegex(), "SHCH")
        lat = lat.replace("Ъ".toRegex(), "IE")
        lat = lat.replace("Ы".toRegex(), "Y")
        lat = lat.replace("Ь".toRegex(), "-")
        lat = lat.replace("Э".toRegex(), "E")
        lat = lat.replace("Ю".toRegex(), "IU")
        lat = lat.replace("Я".toRegex(), "IA")
        lat = lat.replace(" ".toRegex(), divider)
        return lat
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        var char1 = firstName?.getOrNull(0)?.toTitleCase()
        var char2 = lastName?.getOrNull(0)?.toTitleCase()
        var string = StringBuilder()
        string.append(char1)
        string.append(char2)
        var initials = string.toString()
        if (initials.contains("null")) {
            return if (initials.replace("null", "") == "" || initials.replace("null", "") == " ") {
                null.toString()
            }else {
                initials.replace("null", "")
            }
        } else if (initials == "" || initials == " ") {
            return null.toString()
        }
        return initials
    }
}