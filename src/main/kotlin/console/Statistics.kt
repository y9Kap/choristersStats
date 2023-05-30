package console

import database.ObjectTable
import org.jetbrains.exposed.sql.Database
import types.Date
import types.Form
import types.States

suspend fun startStatistics(db: Database) {
    val objectTable = ObjectTable(db)

}