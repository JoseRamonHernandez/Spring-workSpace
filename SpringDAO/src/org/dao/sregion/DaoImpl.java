package org.dao.sregion;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.modelo.sregion.S_Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/* MODULO DAO: SOPORTE PARA CONSULTAS JDBC
 * 
 *  JDBC: PLANTILLA DE CONSULTAS YA DEFINIDAS EN JDBC
 *  
 *  */

@Component
public class DaoImpl {

	@Autowired
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	//Getters and Setter of ALL
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	/* REALIZAR LA INYECCION DE DEPENDENCIAS */
	/* ASIGNAR LA CONEXIÓN A JDBCTEMPLATE */
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	// QUERY´s: INSERT; DELETE; UPDATE;
	
	public void insertS_Region(S_Region region)
	{
		String sql = "INSERT INTO S_REGION (ID,NAME) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {region.getId(), region.getName()});
		System.out.println("Registro insertado");
		
	}
	
	
	public void updateS_Region(S_Region region)
	{
		String sql = "UPDATE S_REGION SET NAME = ? WHERE ID = ?";
		jdbcTemplate.update(sql, new Object[] {region.getName(), region.getId()});
		System.out.println("Registro actualizado");
	}
	
	public void deleteS_Region(S_Region region)
	{
		String sql = "DELETE FROM S_REGION WHERE ID = ?";
		jdbcTemplate.update(sql, new Object[] {region.getId()});
		System.out.println("Registro eliminado");
	}
	
	// QUERY´s : SELECT ALL, SELECT BY ID
	
		public final class S_RegionMapper implements RowMapper<S_Region>
		{
			@Override
			public S_Region mapRow(ResultSet rSet, int row) throws SQLException
			{
				S_Region region = new S_Region();
				region.setId(rSet.getInt("id"));
				region.setName(rSet.getString("name"));
				
				return region;
			}
			
			
		}
		public S_Region getS_RegionById(int id)
		{
			String sql = "SELECT * FROM S_REGION WHERE ID = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {id}, new S_RegionMapper() );
		}
		
		public List<S_Region> getAllS_Region()
		{
			String sql = "SELECT * FROM S_REGION";
			return jdbcTemplate.query(sql, new S_RegionMapper());
		}
		
}
