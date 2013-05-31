
import java.awt.geom.Point2D;


public abstract class Personaje {


		private NombresPersonaje id;
		private Laberinto laberinto;
		private Point2D.Double posicion;
		private Direccion direccion; //Son la clase fantasma y la clase pacman la que cambia la direccion
		private int fil, col, filAnt, filSgt, colAnt, colSgt;
		
		public Personaje(NombresPersonaje id, Laberinto laberinto) {
			this.laberinto = laberinto;
			this.id = id;
			posicion = laberinto.getPosIni(id);
			direccion = laberinto.getDirIni(id);
		}
		
		public boolean mover(double velocidad) {
			//Retorna cierto si se mueve en la pantalla y actualiza la posicion del personaje
			Point2D.Double aux= new Point2D.Double(posicion.x, posicion.y);
			
			//comprueba si puede moverse en esa direccion
			if ((direccion == Direccion.DERECHA) && (posicion.getX()%19 == 0) && laberinto.laberinto[fil][colSgt] != 0)
				posicion.x += velocidad;
			else if ((direccion == Direccion.IZDA) && (posicion.getX()%19 == 0) && laberinto.laberinto[fil][colAnt] != 0)
				posicion.x -= velocidad;
			else if ((direccion == Direccion.ABAJO) && (posicion.getY()%19 == 0) && laberinto.laberinto[filSgt][col] != 0)
				posicion.y += velocidad;
			else if ((direccion == Direccion.ARRIBA) && (posicion.getY()%19 == 0) && laberinto.laberinto[filAnt][col] != 0)
				posicion.y -= velocidad;
			
			//Comrueba si se ha movido y actualiza las posiciones
			boolean seHaMovido = !posicion.equals(aux);
			if(seHaMovido){
				fil = (int) (posicion.getY()/19);
				col = (int) (posicion.getX()/19);
				filAnt = fil-1;
				filSgt = fil+1;
				colAnt = col-1;
				colSgt = col+1;
			}
		}
		
		public boolean muro(Direccion direccion){
			
			// muro==TRUE es que hay muro
			if ((direccion == Direccion.DERECHA) && laberinto.laberinto[fil][colSgt] == 0)
				return true;
			if ((direccion == Direccion.IZDA) && laberinto.laberinto[fil][colAnt] == 0)
				return true;
			if ((direccion == Direccion.ARRIBA) && laberinto.laberinto[filAnt][col] == 0)
				return true;
			if ((direccion == Direccion.ABAJO) && laberinto.laberinto[filSgt][col] == 0)
				return true;
			
			return false;
		}
		
		public Direccion getDireccion(){
			return direccion;
		}
		
		public Point2D.Double getPosicion(){
			return posicion;
		}
		
		public void setDireccion(Direccion direccion){
			this.direccion = direccion;
		}
		
		public void reset(){
			posicion = laberinto.getPosIni(id);
			direccion = laberinto.getDirIni(id);
		}
}
