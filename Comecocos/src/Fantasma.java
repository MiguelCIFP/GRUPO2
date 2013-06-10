import java.awt.geom.Point2D;


public class Fantasma extends Personaje{

	enum Estado { FANTASMA, HUIR, RETORNAR, ENTRAR, ESPERAR, SALIR }
	
	private Estado estado;
	
	public Fantasma( NombresPersonaje id, Laberinto laberinto) {
		super(id, laberinto);
	}
	
	public void mover(double velocidad, int xObj, int yObj) {
		/*estado ENTRAR, ESPERAR O SALIR*/
		if (this.estado==Estado.ENTRAR){
			
		} 
		else if (this.estado==Estado.ESPERAR ){
			
		}
		else if (this.estado==Estado.SALIR) {
			
		}
		else {
			super.mover(velocidad);
			// cambiar dirección si se puede en función del objetivo
			double min = Double.MAX_VALUE;
			double dis;
			Point2D.Double p=getPosicion();
			Direccion nuevaDireccion=getDireccion();
			
			/*invocamos metodo para ver si se puede cambiar direccion y comprobamos que no sea la contraria
			calculo de distancia al objetivo y adjudicamos nueva direccion*/
			
			if (getDireccion()!=Direccion.ABAJO && puedeCambiarDireccion(Direccion.ARRIBA)) {

				dis=Math.sqrt(Math.pow(xObj-p.x, 2)+Math.pow(yObj-p.y-35, 2));
				if(dis<min){
					min=dis;
					nuevaDireccion=Direccion.ARRIBA;
				}
			
			}
			else if (getDireccion() !=Direccion.ARRIBA && puedeCambiarDireccion(Direccion.ABAJO)) {

				dis=Math.sqrt(Math.pow(xObj-p.x, 2)+Math.pow(yObj-p.y+35, 2));
				if(dis<min){
					min=dis;
					nuevaDireccion=Direccion.ABAJO;
				}
			
			}
			else if (getDireccion() !=Direccion.IZDA && puedeCambiarDireccion(Direccion.DERECHA)) {

				dis=Math.sqrt(Math.pow(xObj-p.x+35, 2)+Math.pow(yObj-p.y, 2));
				if(dis<min){
					min=dis;
					nuevaDireccion=Direccion.DERECHA;
				}
			
			}
			else if (getDireccion() !=Direccion.DERECHA && puedeCambiarDireccion(Direccion.IZDA)) {

				dis=Math.sqrt(Math.pow(xObj-p.x-35, 2)+Math.pow(yObj-p.y, 2));
				if(dis<min){
					min=dis;
					nuevaDireccion=Direccion.IZDA;
				}
			
			}		
			//Antes de cambiar la direccion, comprobamos que sean diferentes
			if (nuevaDireccion!=getDireccion())
				setDireccion(nuevaDireccion);
		}
		
	}
	
	public Estado getEstado(){
		return this.estado;
	}
	
	public void setEstado(Estado estado){
		this.estado=estado;
	}
	
	
}
