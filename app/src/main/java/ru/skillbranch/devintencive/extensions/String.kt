package ru.skillbranch.devintencive.extensions

fun String.plural(count: Int, forms: HashMap<String, String>): String? {
    return if (count % 10 == 1 && count % 100 != 11) {
        this
    } else if (count%10 in 2..4 && ( (count %100) <10 || (count%100)>=20)) {
        forms["1"]
    } else {
        forms["2"];
    }
}