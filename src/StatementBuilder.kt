import java.lang.StringBuilder

class StatementBuilder {

    companion object {
        fun selectFieldsFromTable(tableName : String, vararg fields : String) : String {
            val statementText = StringBuilder()
            statementText.append("SELECT ")
            if (fields.isEmpty()){
                statementText.append("* ")
            } else {
                statementText.append(fields.joinToString()).append(' ')
            }
            statementText.append("FROM ")
            statementText.append("$tableName;")
            return statementText.toString()
        }
    }



}