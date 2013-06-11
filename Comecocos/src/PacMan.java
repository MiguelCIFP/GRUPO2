import java.awt.image.BufferedImage;



	public class PacMan extends Personaje{
		
		private BufferedImage img;
		
		public PacMan(Laberinto l, String fichero){
			Super(NombresPersonajes.PACMAN,1);
			try {
				img = ImageIO.read(PacMan.class.getResource(fichero);
			} catch (IOException e) {}
		}
		public BufferedImage getImage(){
			return img;
		}
		public void mover(double velocidad, Direccion nuevaDireccion){
			// El par�metro nuevaDirecci�n representa la direcci�n que tiene que tomar si fuese posible.
			super.mover(velocidad);
			if (PuedeCambiarDireccion=nuevaDireccion){
				nuevaDireccion=setDireccion;
			}
		
			}
		
}
