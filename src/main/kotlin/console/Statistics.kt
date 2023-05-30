package console

import database.ObjectTable
import org.jetbrains.exposed.sql.Database

suspend fun startStatistics(db: Database) {
    ObjectTable(db)
}