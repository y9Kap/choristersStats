@file:Suppress("PrivatePropertyName")

package database

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import types.Date
import types.Form
import types.States

class ObjectTable(private val db: Database) : Table() {
    private val BIRTHDAY = varchar("BIRTHDAY", length = 10)
    private val DATE_OF_QUESTIONNAIRE = long("DATE_OF_QUESTIONNAIRE")
    private val FAVORITE_LESSON = varchar("FAVORITE_LESSON", length = 100).nullable()
    private val PET = varchar("PET", length = 50).nullable()
    private val FOREIGN_LANGUAGE = varchar("FOREIGN_LANGUAGE", length = 100).nullable()
    private val HOBBY = varchar("HOBBY", length = 200).nullable()
    private val FAVORITE_GAME = varchar("FAVORITE_GAME", length = 100).nullable()
    private val FAVORITE_BOOK = varchar("FAVORITE_BOOK", length = 300).nullable()
    private val FAVORITE_HERO = varchar("FAVORITE_HERO", length = 250).nullable()
    private val FAVORITE_FILM = varchar("FAVORITE_FILM", length = 250).nullable()
    private val FAVORITE_NUMBER = long("FAVORITE_NUMBER").nullable()
    private val HATED_NUMBER = long("HATED_NUMBER").nullable()
    private val FAVORITE_DAY = varchar("FAVORITE_DAY", length = 50).nullable()
    private val HATED_DAY = varchar("HATED_DAY", length = 50).nullable()
    private val FAVORITE_FRUIT = varchar("FAVORITE_FRUIT", length = 50).nullable()
    private val TEMPERATURE_OF_TEA = varchar("TEMPERATURE_OF_TEA", length = 100).nullable()
    private val FAVORITE_PET = varchar("FAVORITE_PET", length = 100).nullable()
    private val STATE_OF_MIND = varchar("STATE_OF_MIND", length = 50).nullable()
    private val FAVORITE_HISTORICAL_EVENT = varchar("FAVORITE_HISTORICAL_EVENT", length = 300).nullable()
    private val LIKE_SLEEP = varchar("LIKE_SLEEP", length = 50).nullable()
    private val LIKE_WORKING = varchar("LIKE_WORKING", length = 50).nullable()
    private val WORK_OF_DREAM = varchar("WORK_OF_DREAM", length = 300).nullable()

    init {
        transaction(db) {
            SchemaUtils.create(this@ObjectTable)
        }
    }

    suspend fun addObject(form: Form) =
        newSuspendedTransaction(db = db) {
            with(form) {
                insert { statement ->
                    statement[BIRTHDAY] = birthday.dateString
                    statement[DATE_OF_QUESTIONNAIRE] = dateOfQuestionnaire
                    statement[FAVORITE_LESSON] = favoriteLesson
                    statement[PET] = pet
                    statement[FOREIGN_LANGUAGE] = foreignLanguage
                    statement[HOBBY] = hobby
                    statement[FAVORITE_GAME] = favoriteGame
                    statement[FAVORITE_BOOK] = favoriteBook
                    statement[FAVORITE_HERO] = favoriteHero
                    statement[FAVORITE_FILM] = favoriteFilm
                    statement[FAVORITE_NUMBER] = favoriteNumber
                    statement[HATED_NUMBER] = hatedNumber
                    statement[FAVORITE_DAY] = favoriteDay
                    statement[HATED_DAY] = hatedDay
                    statement[FAVORITE_FRUIT] = favoriteFruit
                    statement[TEMPERATURE_OF_TEA] = temperatureOfTea
                    statement[FAVORITE_PET] = favoritePet
                    statement[STATE_OF_MIND] = stateOfMind?.statesOfMind
                    statement[FAVORITE_HISTORICAL_EVENT] = favoriteHistoricalEvent
                    statement[LIKE_SLEEP] = likeSleep
                    statement[LIKE_WORKING] = likeWorking
                    statement[WORK_OF_DREAM] = workOfDream
                }
            }
        }

    suspend fun getObjectsForDateOfQuestionnaire(dateOfQuestionnaire: Long) =
        newSuspendedTransaction(db = db) {
            return@newSuspendedTransaction select { (DATE_OF_QUESTIONNAIRE eq dateOfQuestionnaire) }
                .map { statement ->
                    Form(
                        Date(statement[BIRTHDAY]),
                        statement[DATE_OF_QUESTIONNAIRE],
                        statement[FAVORITE_LESSON],
                        statement[PET],
                        statement[FOREIGN_LANGUAGE],
                        statement[HOBBY],
                        statement[FAVORITE_GAME],
                        statement[FAVORITE_BOOK],
                        statement[FAVORITE_HERO],
                        statement[FAVORITE_FILM],
                        statement[FAVORITE_NUMBER],
                        statement[HATED_NUMBER],
                        statement[FAVORITE_DAY],
                        statement[HATED_DAY],
                        statement[FAVORITE_FRUIT],
                        statement[TEMPERATURE_OF_TEA],
                        statement[FAVORITE_PET],
                        States(statement[STATE_OF_MIND]),
                        statement[FAVORITE_HISTORICAL_EVENT],
                        statement[LIKE_SLEEP],
                        statement[LIKE_WORKING],
                        statement[WORK_OF_DREAM]
                    )
                }
        }

    suspend fun check(date: Date): Boolean =
        newSuspendedTransaction(db = db) {
            val result = select { (BIRTHDAY eq date.dateString ) }.toList()
            return@newSuspendedTransaction result.isEmpty()
        }

}