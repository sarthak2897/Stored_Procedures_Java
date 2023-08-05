import DBConfig._

import java.sql.{Connection, DriverManager}

object DBConnectionConfig extends App {


  var connection : Connection = _
  try{
    Class.forName(driver)
    connection = DriverManager.getConnection(url,username,password)
    val statement = connection.createStatement()
    val rs = statement.executeQuery("SELECT * FROM actor LIMIT 5")
    while(rs.next()){
      println(rs.getInt("actor_id"))
      println(rs.getString("first_name"))
      println(rs.getString("last_name"))
      println()
    }
  }
  catch{
    case e : Exception => e.printStackTrace()
  }
}
