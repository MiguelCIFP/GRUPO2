
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
			if (){
				
			}
		}
		
	}
	
	public Estado getEstado(){
		return this.estado;
	}
	
	public void setEstado(Estado estado){
		this.estado=estado;
	}
	
	
}
