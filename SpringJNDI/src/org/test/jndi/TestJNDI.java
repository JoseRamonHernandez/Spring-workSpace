package org.test.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TestJNDI {

	public static void main(String[] args) {
		
		try
		{
			
			//REALIZAR CONEXION CON JDNI
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("jdbc/Oracle");
			Connection connection = dataSource.getConnection();
			
			//QUERY
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id")+", "+rs.getString("name"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}
		
	}
	
}
