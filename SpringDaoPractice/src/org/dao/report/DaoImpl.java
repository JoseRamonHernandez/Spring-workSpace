package org.dao.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.modelo.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

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
	
	public void insertReport(Report report)
	{
		String sql = "INSERT INTO REPORT (ID,TIPO,FOLIO,COMENTARIO) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {report.getId(), report.getTipo(), report.getFolio(), report.getComentario()});
		System.out.println("Registro insertado");
		
	}
	
	
	public void updateReport(Report report)
	{
		String sql = "UPDATE REPORT SET TIPO = ? WHERE ID = ?";
		jdbcTemplate.update(sql, new Object[] {report.getTipo(), report.getId()});
		System.out.println("Registro actualizado");
	}
	
	public void deleteReport(Report report)
	{
		String sql = "DELETE FROM REPORT WHERE ID = ?";
		jdbcTemplate.update(sql, new Object[] {report.getId()});
		System.out.println("Registro eliminado");
	}
	
	// QUERY´s : SELECT ALL, SELECT BY ID
	
		public final class ReportMapper implements RowMapper<Report>
		{
			@Override
			public Report mapRow(ResultSet rSet, int row) throws SQLException
			{
				Report report = new Report();
				report.setId(rSet.getInt("id"));
				report.setTipo(rSet.getString("tipo"));
				report.setFolio(rSet.getString("folio"));
				report.setComentario(rSet.getString("comentario"));
				
				return report;
			}
			
			
		}
		public Report getReportById(int id)
		{
			String sql = "SELECT * FROM REPORT WHERE ID = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {id}, new ReportMapper() );
		}
		
		public List<Report> getAllReport()
		{
			String sql = "SELECT * FROM REPORT";
			return jdbcTemplate.query(sql, new ReportMapper());
		}
	
}
