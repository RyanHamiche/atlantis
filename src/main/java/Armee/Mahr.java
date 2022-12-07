package Armee;

/**
 * Décrivez votre classe Humain ici.
 *
 * @author Mohamed IRAZZI feat. Ryan HAMICHE
 * @version 0.0.1
 */
public class Mahr extends Humain
{
	private Monture monture;
	
	public Mahr() {
		super();
	}
	
    public Monture getMonture(){
        return this.monture;
    }
    /**
     * Designez l'unique compagnon de cet humain.
     *
     * @param  proprio L'humain qui sera le proprietaire de cette monture
     */
    public void setCompagnon(Monture animal)
    {
    	super.varNonNull(animal);
        this.monture = animal;
        if(!this.equals(animal.getProprietaire())){
            animal.setProprietaire(this);
        }
    }

}
