package mx.uabcs.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseLayer//capa de base de datos 
{
	private String sql;
	private Connection conn;
	private Statement stm;
	////
	private ResultSet rs;//va a trater los registro de la base de datos
	/////
	
	private String server = "localhost";
	private String db = "progra3";
	private String user="root";
	private String pwd="rosasgonzalez738";
	

	
	//contructor
	public DataBaseLayer()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");//driver
			conn= DriverManager.getConnection("jdbc:mysql://" + server + "/" +db,user,pwd);//conexion
			stm = conn.createStatement();
			if(conn!=null)
			{
				System.out.println("conexion establecida");
			}
			else
			{
				System.out.println("fallo conexion");
			}
		} catch (ClassNotFoundException e) {//driver
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//paquetes,
		 catch (SQLException e) {//conexion
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//adeonde conectar
		
	}
	////////
	public boolean isConnected(){//saber si la coenxion esta abierta o no esta abierta
		
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	//////
	public void queryExect(String sql){//pasar parametro a la base de datos
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	///////////
	
	public ArrayList<FormEvent> resultQueryExec(String sql){//recorra la lista
	
		ArrayList<FormEvent> list = new ArrayList<FormEvent>();
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()){
				
				FormEvent item = new FormEvent(this);
				
				//item.setId(rs.getInt("id"));
				item.setId(rs.getInt("id"));
				item.setTipo_empleado_id(rs.getInt("tipo_empleado_id"));
				item.setName(rs.getString("nombre"));
				item.setOccupation(rs.getString("ocupacion"));
				item.setEdad(rs.getInt("edad"));
				item.setGender(rs.getString("genero"));
				item.setNacionalidad_id(rs.getInt("nacionalidad_id"));
				
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//////////
	public ArrayList<Nacionalidad> resultQueryExecNacion()
	{		
		ArrayList<Nacionalidad> lista=new ArrayList<Nacionalidad>();
		try {
			rs = stm.executeQuery("select * from nacionalidad");				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {	
			
			while(rs.next()){							
										
				lista.add(new Nacionalidad(rs.getInt("id"),rs.getString("nacion")));					
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}	
	///////
	public ArrayList<Empleado> resultQueryExecEmpleado()
	{	
		ArrayList<Empleado> lista=new ArrayList<Empleado>();
		try {
			rs = stm.executeQuery("select * from tipo_empleado");				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {	
			
			while(rs.next()){							
										
				lista.add(new Empleado(rs.getInt("id"),rs.getString("empleado")));					
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}	
	///////
	public void delete(int id)//metodo se elimina un registro completo
	{
		try {
			stm.executeUpdate("delete from trabajador where id='"+id+"'");				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//////
	public void update(int id,int contrato, String nombre, String ocupacion, int edad, String genero, int nacionalidad)
	{
		try {
			stm.executeUpdate("update trabajador set nombre = '"+nombre+"' where id='"+id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/////
	
	
	
	
	

}
