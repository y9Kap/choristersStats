import console.startStatistics
import org.jetbrains.exposed.sql.Database

suspend fun main() {
    val databaseUrl = System.getenv("DATABASE_URL") ?: error("Please provide a database url")
    val databaseUser = System.getenv("DATABASE_USER") ?: ""
    val databasePassword = System.getenv("DATABASE_PASSWORD") ?: ""

    val database = Database.connect(
        databaseUrl,
        user = databaseUser,
        password = databasePassword
    )

    startStatistics(database)
}
