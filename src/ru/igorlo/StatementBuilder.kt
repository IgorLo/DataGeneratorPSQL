package ru.igorlo

import java.lang.StringBuilder

class StatementBuilder {

    companion object {
        fun selectFieldsFromTable(tableName: String, limit: Int = 0, vararg fields: String): String {
            val statementText = StringBuilder()
            statementText.append("SELECT ")
            if (fields.isEmpty()) {
                statementText.append("* ")
            } else {
                statementText.append(fields.joinToString()).append(' ')
            }
            statementText.append("FROM ")
            statementText.append("$tableName ")
            if (limit > 0) {
                statementText.append("LIMIT $limit")
            }
            statementText.append(";")
            return statementText.toString()
        }

        fun insertColumnsInTable(tableName: String, fields: Collection<String>): String {
            val statementText = StringBuilder()
            statementText.append("INSERT INTO $tableName (" + fields.joinToString() + ") VALUES (?" + ",?".repeat(fields.size - 1) + ")")
            return statementText.toString()
        }

        fun deleteAll(tableName: String): String {
            return ("DELETE FROM $tableName WHERE id > 0;")
        }

        fun truncateTable(tableName: String): String? {
            return ("TRUNCATE $tableName;")
        }
    }
}