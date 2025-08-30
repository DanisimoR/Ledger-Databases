package net.quiltservertools.ledger.databases.databases

import com.github.quiltservertools.ledger.Ledger
import net.minecraft.util.Identifier
import org.sqlite.SQLiteDataSource
import java.nio.file.Path
import kotlin.io.path.pathString

object SQLite : LedgerDatabase {
    override fun getDataSource(savePath: Path) = SQLiteDataSource().apply {
        url = "jdbc:sqlite:${savePath.resolve("ledger.sqlite").pathString}"
    }

    override fun getDatabaseIdentifier(): Identifier = Ledger.identifier(Ledger.DEFAULT_DATABASE)
}
