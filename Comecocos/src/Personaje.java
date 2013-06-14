import java.awt.geom.Point2D;


public abstract class Personaje {


		private NombresPersonaje id;
		private Laberinto laberinto;
		private Point2D.Double posicion;
		private Direccion direccion; //Son la clase fantasma y la clase pacman la que cambia la direccion
		private int fil, col, filAnt, filSgt, colAnt, colSgt;
		
		private boolean csd; //si hay distintos sprites para cada direccion
		private int pcs; //n de de pixeles que se desplaza el personaje para cambiar el sprite de la animacion
		private int dsx; //desplazamiento del sprite en la direccion x
		private int dsy;//desplazamiento del sprite en la direccion y 
		
		private int dsxini;
		private int maxdsx;
		
		private double cont=0; 
		private int inc=35;
		
		public Personaje(NombresPersonaje id, Laberinto laberinto,boolean csd, int nsd, int pcs) {
			//nsd el numero sprites que se utilizan para animar el movimiento en cada direccion 
			this.laberinto = laberinto;
			this.id = id;
			this.csd=csd;
			this.pcs=pcs;
			
			posicion = laberinto.getPosIni(id);
			setDireccion(laberinto.getDirIni(id));
			dsx=dsxini=nsd/2*35;
			maxdsx=(nsd-1)*35;
		}
		
		public boolean mover(double velocidad) {
			
			boolean seHaMovido = false;
			//comprueba si puede moverse en esa direccion
			if ((direccion == Direccion.DERECHA) && ((int) posicion.x%19 != 0 || !laberinto.muro(fil, colSgt))) {
				posicion.x += velocidad;
				seHaMovido = true;
			}
			else if ((direccion == Direccion.IZDA) && ((int) posicion.x%19 != 0 || !laberinto.muro(fil, colAnt))) {
				posicion.x -= velocidad;
				seHaMovido = true;
			}
			else if ((direccion == Direccion.ABAJO) && ((int) posicion.y%19 != 0 || !laberinto.muro(filSgt, col))) {
				posicion.y += velocidad;
				seHaMovido = true;
			}
			else if ((direccion == Direccion.ARRIBA) && ((int) posicion.y%19 != 0 || !laberinto.muro(filAnt, col))) {
				posicion.y -= velocidad;
				seHaMovido = true;
			}
			
			//
			if (seHaMovido||(!seHaMovido && dsx!=dsxini)){
				cont+=velocidad;
				if (cont>=pcs){
					cont=0;
					if(dsx==0 || dsx==maxdsx)
						inc*=-1;
					dsx+=inc;
				}
			}
			
			//Comrueba si se ha movido y actualiza las posiciones
			fil = (int) (posicion.getY()/19);
			col = (int) (posicion.getX()/19);
			filAnt = fil-1;
			filSgt = fil+1;
			colAnt = col-1;
			colSgt = col+1;
			
			return seHaMovido;
		}
		
		public int getDsx(){
			return dsx;
		}
		
		public int getDsy(){
			return dsy;
		}
		
		public boolean puedeCambiarDireccion(Direccion direccion){
			//retorna true si el proximo intento de moverse a esa direccion el presonaje se va a encontrar con un muro
			return (int) posicion.x % 19 == 0
						&& (int) posicion.y % 19 == 0
						&& ((direccion == Direccion.DERECHA && !laberinto.muro(fil, colSgt))
							||((direccion == Direccion.IZDA) && !laberinto.muro(fil, colAnt))
							||((direccion == Direccion.ABAJO) && !laberinto.muro(filSgt, col))
							||((direccion == Direccion.ARRIBA) &&!laberinto.muro(filAnt, col)));
		}
		
		public Direccion getDireccion(){
			return direccion;
		}
		
		public Point2D.Double getPosicion(){
			return posicion;
		}
		
		public void setDireccion(Direccion direccion){
			this.direccion = direccion;
			if (csd){
				dsy=direccion.ordinal()*35;
			}
		}
		
		public void reset(){
			posicion = laberinto.getPosIni(id);
			setDireccion(laberinto.getDirIni(id));
			dsx=dsxini;
			cont=0;
			inc=35;
		}
}