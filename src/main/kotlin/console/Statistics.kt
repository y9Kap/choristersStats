package console

import database.ObjectTable
import org.jetbrains.exposed.sql.Database
import types.Date
import types.Form
import types.States

suspend fun startStatistics(db: Database) {
    val objectTable = ObjectTable(db)
    while (true) {
        var birth = Date("00.00.0000")
        while (true) {
            println("Birthday (yyyy-mm-dd): ")
            val input = readln()
            try {
                val newBirthday = Date(input)
                if (!objectTable.check(newBirthday)) {
                    println("This birthday already exists. Do you want to continue? (д/н)")
                    val confirmation = readln().lowercase()
                    if (confirmation == "д") {
                        break
                    } else continue
                }
                birth = newBirthday
                break
            } catch (e: Exception) {
                println("Invalid date format. Please try again.")
            }
        }
        val birthday = birth
        println("Date of questionnaire: ")
        val dateOfQuestionnaire = readlnOrNull()?.toLong() ?: break
        println("Favorite lesson: ")
        val favoriteLesson = readLine()
        println("Pet: ")
        val pet = readLine()
        println("Foreign language: ")
        val foreignLanguage = readLine()
        println("Hobby: ")
        val hobby = readLine()
        println("Favorite game: ")
        val favoriteGame = readLine()
        println("Favorite book: ")
        val favoriteBook = readLine()
        println("Favorite hero: ")
        val favoriteHero = readLine()
        println("Favorite film: ")
        val favoriteFilm = readLine()
        println("Favorite number: ")
        val favoriteNumber = readLine()?.toLong()
        println("Hated number: ")
        val hatedNumber = readLine()?.toLong()
        println("Favorite day: ")
        val favoriteDay = readLine()
        println("Hated day: ")
        val hatedDay = readLine()
        println("Favorite fruit: ")
        val favoriteFruit = readLine()
        println("Temperature of tea: ")
        val temperatureOfTea = readLine()
        println("Favorite pet: ")
        val favoritePet = readLine()
        println("State of mind: ")
        val stateOfMind = readLine()?.let { States(it) }
        println("Favorite historical event: ")
        val favoriteHistoricalEvent = readLine()
        println("Like sleep: ")
        val likeSleep = readLine()
        println("Like working: ")
        val likeWorking = readLine()
        println("Work of dream: ")
        val workOfDream = readLine()
        objectTable.addObject(Form(
            birthday,
            dateOfQuestionnaire,
            favoriteLesson,
            pet,
            foreignLanguage,
            hobby,
            favoriteGame,
            favoriteBook,
            favoriteHero,
            favoriteFilm,
            favoriteNumber,
            hatedNumber,
            favoriteDay,
            hatedDay,
            favoriteFruit,
            temperatureOfTea,
            favoritePet,
            stateOfMind,
            favoriteHistoricalEvent,
            likeSleep,
            likeWorking,
            workOfDream
        ))
    }
}