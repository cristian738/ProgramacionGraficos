package mx.uabcs.javaswing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {

	public static void main(String[] args) {
		/*
		DataBaseLayer dbl=new DataBaseLayer();
		if(dbl.isConnected()){
			String sql="INSERT INTO trabajador"+
					"(tipo_empleado,nombre,ocupacion,edad,genero,pais)"+
					"VALUES('Fijo','Cristian Manuel', 'Maestro', 20 , 'Masculino','Jamaica')";//insercion
			//dbl.queryExect(sql);
			////
			ResultSet rs = dbl.resultQueryExec("select * from trabajador" );
			try {
				while(rs.next()){
					System.out.println(rs.getString("nombre"));
				}
				rs.close();//cerrar el flujo
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/////
		}
		*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				
			/*	
				ArrayList<Persona> Lista=new ArrayList<Persona>();//crear una colecion(<>tipo de dato)
				
				Lista.add(new Persona(19,"Cristian","Rosas"));
				Lista.add(new Persona(20,"Juan","Glez"));
				Lista.add(new Persona(21,"Nestor","Jojo"));
				Lista.add(new Persona(78,"Koko","Nfl"));
				Lista.add(new Persona(19,"Loki","Thor"));
				
			 //1
				for(int i=0; i<Lista.size();i++)//recorrer lista
				{
					//System.out.println(Lista.get(i).getNombre());
				}
				
			//2	
				/*
				Iterator it=Lista.iterator();//declarar el objecto para hace rle ciclo
				while(it.hasNext())//checar si exsistes un elemento siguiente
				{
					Persona p= ((Persona)it.next());
					System.out.println(p.getNombre()+" "+ p.getApellidos()+" "+p.getEdad());
					
				}
				*/
				
			//3
				/*
				for(Persona p: Lista)//recorrer
				{
					System.out.println(p.getNombre()+" "+ p.getApellidos()+" "+p.getEdad());
				}
				*/
				
				
				//imprimir uno por uno
				//Persona p = Lista.get(0) ;
				//System.out.println(p.getEdad());
				//System.out.println(Lista.get(0).getNombre());
				
			
				
			}
		});	
	}

}
