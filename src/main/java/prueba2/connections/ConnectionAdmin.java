package prueba2.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import prueba2.exceptions.GenericException;

public class ConnectionAdmin {

public static Connection tryConnection() throws GenericException {
		
		String url = "jdbc:mysql://localhost/prueba2";
		String user = "root";
		String password = "";
		String driverName = "com.mysql.jdbc.Driver"; //depende del motor 
		//es el paquete donde esta el driver
		//en la dependencia MAVEN
		//en este caso podemos usar los dos paquetes que tienen jdbc. 
		//Usamos el que tiene cj.
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericException("Error obteniendo conexion: "+ e.getMessage(),e);
		}
		
	}
}
