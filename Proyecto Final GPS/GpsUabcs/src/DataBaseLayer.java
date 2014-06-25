import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DataBaseLayer
{
	
	private String sql;
	private Connection conn;
	private Statement stm;
	////
	private ResultSet rs;//va a trater los registro de la base de datos
	/////
	
	private String server = "localhost";
	private String db = "gps";
	private String user="root";
	private String pwd="rosasgonzalez738";
	
	private Grafo ok = new Grafo();

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
	
	
	public ArrayList<FormEvent> resultQueryExec(String sql)
	{//recorra la lista
		
		ArrayList<FormEvent> list = new ArrayList<FormEvent>();
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()){
				
				FormEvent item = new FormEvent(this);
				
				item.setId(rs.getInt("id"));
				item.setDato(rs.getString("dato"));
				item.setX(rs.getDouble("x"));
				item.setY(rs.getDouble("y"));
				
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Lugares> resultQueryExecLugares()
	{		
		ArrayList<Lugares> lista=new ArrayList<Lugares>();
		try {
			rs = stm.executeQuery("select * from lugares");				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {	
			
			while(rs.next()){							
										
				lista.add(new Lugares(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),rs.getString("imagen")));					
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}	
	///
	public ArrayList<Nodo> resultQueryExecNodo()
	{		
		ArrayList<Nodo> lista=new ArrayList<Nodo>();
		try {
			rs = stm.executeQuery("select * from nodo");				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {	
			
			while(rs.next()){							
										
				lista.add(new Nodo(rs.getInt("id"),rs.getString("dato"),rs.getDouble("x"),rs.getDouble("y")));					
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}	
	
	//
	public ArrayList<Liga> resultQueryExecLiga(ArrayList<Nodo> e )
	{	
		ArrayList<Liga> listas=new ArrayList<Liga>();
		
		
		try {
			rs = stm.executeQuery("select * from ligas");				
		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {	
			
			while(rs.next()){	
				
				
				Liga l = new Liga();
				l.setPeso(rs.getInt("peso"));
				
				for(Nodo f : e  ){
					if(f.getId()==rs.getInt("origen"))
					{
						l.setOrigen(f);
					}
					if(f.getId()==rs.getInt("destino")){
						l.setDestino(f);
					}					
				}				
				listas.add(l);									
			}

			rs.close();
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}	
		return listas;
	}
	//eliminar un nodo
	public void delete(int id)//metodo se elimina un registro completo
	{
		try {
			stm.executeUpdate("delete from nodo where id='"+id+"'");				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//////
	public void update(int id,String datod, String xd, String yd)
	{
		try {
			stm.executeUpdate("update nodo set nombre = '"+datod+"' where id='"+id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/////
	
	
	
	
	
}
