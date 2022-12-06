package Armee;

/**
 * Décrivez votre classe Monture ici.
 *
 * @author Mohamed IRAZZI feat. Ryan HAMICHE
 * @version 0.0.1
 */
public class Monture
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String race;
    private Mahr proprietaire;

    /**
     * Constructeur d'objets de classe Monture
     */
    public Monture(String race)
    {
        // initialisation des variables d'instance
        this.race = race;
    }

    
    public String getRace()
    {
        return this.race;
    }
    
    public Mahr getProprietaire()
    {
        return this.proprietaire;
    }
    /**
     * Designez l'unique propriétaire de cette monture.
     *
     * @param  proprio L'humain qui sera le proprietaire de cette monture
     */
    public void setProprietaire(Mahr proprio)
    {
        this.proprietaire = proprio;
        if(!this.equals(proprio.getMonture())){
            proprio.setCompagnon(this);
        }
    }
}
