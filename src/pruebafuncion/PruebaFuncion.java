/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafuncion;

import java.sql.*;

/**
 *
 * @author luis
 */
public class PruebaFuncion {
 
   public static void getJugadores(Connection con) throws SQLException {
    Statement stmt = null;
    String query = "select dimeCuantos() FROM DUAL;";
    try {
    stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
        String cuantos = rs.getString(1);
        System.out.println("Existen "+ cuantos +" jugadores en nuestra base de datos");
        System.out.println("***************************************************************");
    }
    }catch (SQLException e ) {printSQLException(e);}
    finally { stmt.close() ;}
};

    private static void printSQLException(SQLException ex) {
       
        ex.printStackTrace(System.err) ;
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        while(t != null) {System.out.println("Causa: " + t ); t = t.getCause();};
    };          

    public static void main(String[] args) {
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdequipos","root","");
        //Statement stmt = con.createStatement();
         System.out.println("Conexión realizada!");
         getJugadores(con);
         System.out.println("Función mysql ejecutada!");
        }catch (SQLException e ) { printSQLException(e) ;};  
     };
   
};
