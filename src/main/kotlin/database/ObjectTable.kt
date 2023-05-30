@file:Suppress("PrivatePropertyName")

package database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

class ObjectTable(db: Database) : Table() {
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
    private val WORK_OF_DREAM = varchar("LIKE_WORKING", length = 300).nullable()

    init {
        transaction(db) {
            SchemaUtils.create(this@ObjectTable)
        }
    }

}