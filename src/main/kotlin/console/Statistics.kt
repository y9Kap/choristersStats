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
        val favoriteLesson = readlnOrNull()
        println("Pet: ")
        val pet = readlnOrNull()
        println("Foreign language: ")
        val foreignLanguage = readlnOrNull()
        println("Hobby: ")
        val hobby = readlnOrNull()
        println("Favorite game: ")
        val favoriteGame = readlnOrNull()
        println("Favorite book: ")
        val favoriteBook = readlnOrNull()
        println("Favorite hero: ")
        val favoriteHero = readlnOrNull()
        println("Favorite film: ")
        val favoriteFilm = readlnOrNull()
        println("Favorite number: ")
        val favoriteNumber = readlnOrNull()?.toLong()
        println("Hated number: ")
        val hatedNumber = readlnOrNull()?.toLong()
        println("Favorite day: ")
        val favoriteDay = readlnOrNull()
        println("Hated day: ")
        val hatedDay = readlnOrNull()
        println("Favorite fruit: ")
        val favoriteFruit = readlnOrNull()
        println("Temperature of tea: ")
        val temperatureOfTea = readlnOrNull()
        println("Favorite pet: ")
        val favoritePet = readlnOrNull()
        println("State of mind: ")
        val stateOfMind = readlnOrNull()?.let { States(it) }
        println("Favorite historical event: ")
        val favoriteHistoricalEvent = readlnOrNull()
        println("Like sleep: ")
        val likeSleep = readlnOrNull()
        println("Like working: ")
        val likeWorking = readlnOrNull()
        println("Work of dream: ")
        val workOfDream = readlnOrNull()
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