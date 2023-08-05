import DBConfig._

import java.sql.{CallableStatement, Connection, DriverManager, ResultSet}

object SP extends App{

  var connection : Connection = _
  private val actorId = 1
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    //Plain SP call
    //val statement: CallableStatement = connection.prepareCall("call films_count_by_actor()")
    //SP call with parameters
    val statement = connection.prepareCall("call films_count_per_actor(?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
    statement.setInt(1, actorId)
    val rs: ResultSet = statement.executeQuery()
    if (rs.next()) {
      rs.beforeFirst()
      while (rs.next()) {
        println(rs.getString("first_name") + "\t"
          + rs.getString("last_name") + "\t" + rs.getInt("no_of_films"))
      }
    }
    else throw new Exception(s"Actor Id : ${actorId} entered not found")
  }
  catch{
    case e : Exception => e.printStackTrace()
  }
  finally {
    connection.close()
  }
}
