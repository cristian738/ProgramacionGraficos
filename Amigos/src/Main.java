
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Miguel m = new Miguel();
		
		
		
		m.setRelacion(new RelacionInterfaz(){

			@Override
			public void amistad(String mensaje) {
				// TODO Auto-generated method stub
				Jesus i = new Jesus();
				i.escuchar(mensaje);
			
			}
		});
		m.habalr();
		
	}

}
