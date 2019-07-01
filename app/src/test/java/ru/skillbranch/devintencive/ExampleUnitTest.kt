package ru.skillbranch.devintencive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintencive.extensions.TimeUnit
import ru.skillbranch.devintencive.extensions.add
import ru.skillbranch.devintencive.extensions.humanizeDiff
import ru.skillbranch.devintencive.models.BaseMessage
import ru.skillbranch.devintencive.models.Chat
import ru.skillbranch.devintencive.models.User
import ru.skillbranch.devintencive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun test_users() {
        val user = User("1")
        val user2 = User("2", "John", "Week")
        val user3 = User("3", "John", "Silver", null, lastVisit = Date(), isOnline = true)



        println("$user $user2 $user3")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Fedor Gorsky")


        print("${user}")
    }


    @Test
    fun test_abstract_factory() {

        val user = User.makeUser("Fedor Gorsky3")
        val textMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "any message", type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "any url", type = "image")

        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())
    }

    @Test
    fun test_initials() {
        val firstName = "Fedor"
        val lastName = "Gorsky"
        println(Utils.toInitials(firstName, lastName))
        println(Utils.toInitials(firstName, null))
        println(Utils.toInitials(null, lastName))
        println(Utils.toInitials(null, null))
    }

    @Test
    fun transliterate() {
        println(Utils.transliteration("Горский Федор"))
        println(Utils.transliteration("Иван Стереотипов")) //Ivan Stereotipov
        println(Utils.transliteration("Amazing Петр", "_")) //Amazing_Petr
    }

    @Test
    fun testBuilder() {
        val user = User.firstName("Fedor")
            .lastName("Gorsky")
            .avatar("Ya.ru")
            .rating(555)
            .respect(11)
            .lastVisit(Date())
            .isOnline(true)
            .build()

        println(user)
    }

    @Test
    fun test_date() {
//        println(Date().add(-2, TimeUnit.SECOND).humanizeDiff(Date())) //несколько секунд назад
//        println(Date().add(-2, TimeUnit.HOUR).humanizeDiff()) //2 часа назад
//        println(Date().add(-5, TimeUnit.DAY).humanizeDiff()) //5 дней назад
//        println(Date().add(-400, TimeUnit.DAY).humanizeDiff()) //более года назад

        var time = Date()
        var time1 = time.clone()

        println(time.add(-2, TimeUnit.MINUTE).humanizeDiff()) //через 2 минуты
        println("====================")
        println(time.add(2, TimeUnit.MINUTE).humanizeDiff()) //через 2 минуты

//        println(Date().add(400, TimeUnit.DAY).humanizeDiff()) //более чем через года
//        println(Date().add(7, TimeUnit.DAY).humanizeDiff()) //через 7 дней
    }
}
