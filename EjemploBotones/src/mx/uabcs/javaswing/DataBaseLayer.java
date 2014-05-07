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
	private ResultSet rs;//objecto guardar resultado de la base de datos
	/////
	
	private String server = "localhost";
	private String db = "progra3";
	private String user="root";
	private String pwd="rosasgonzalez738";
	
	TextPanel textPanel;
	
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
	
	public void delQuery(FormEvent e, String ide){//borrar
		try {		
			String sql = "DELETE"+"FROM trabajador" +"nombre ="+"'"+e.getName()+"',"+
																    "ocupacion ="+"'"+e.getOccupation()+"',"+
																    "tipoEmpleado="+"'"+e.getAgeCategory()+"',"+
																    "edad="+e.getDefaNa()+","+
																    "genero="+"'"+e.getGenero()+"',"+
																    "pais="+"'"+e.getNacion()+"'" + 
																    "Where idTrabajador="+ide+";";
			System.out.println(sql);
			stm.executeUpdate(sql);
		} catch (SQLException t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}
	////////
	public void actQuery(FormEvent e, String ide){//actualizar
		try {
			String sql = "UPDATE trabajador "+ "SET "+"nombre ="+"'"+e.getName()+"',"+
												    "ocupacion ="+"'"+e.getOccupation()+"',"+
												    "tipoEmpleado="+"'"+e.getAgeCategory()+"',"+
												    "edad="+e.getDefaNa()+","+
												    "genero="+"'"+e.getGenero()+"',"+
												    "pais="+"'"+e.getNacion()+"'"+
												    " where idTrabajador="+ide+";";
			System.out.println(sql);
			stm.executeUpdate(sql);
		} catch (SQLException t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

	
	
	public ArrayList<FormEvent> resultQueryExec(String sql){//recorra la lista
	
		ArrayList<FormEvent> list = new ArrayList<FormEvent>();
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()){
				FormEvent item = new FormEvent(this);
				//item.setId(rs.getInt("id"));
				item.setId(rs.getInt("idTrabajador"));
				item.setAgeCategory(rs.getString("tipo_empleado"));
				item.setName(rs.getString("nombre"));
				item.setOccupation(rs.getString("ocupacion"));
				item.setDefaNa(rs.getString("edad"));
				item.setGenero(rs.getString("genero"));
				item.setNacion(rs.getString("pais"));
				
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	

}
