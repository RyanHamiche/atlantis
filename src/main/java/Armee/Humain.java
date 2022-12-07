package Armee;

public abstract class Humain {
	   // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int age;
    private String fonction;
    private Monture monture;
    private Regiment regiment;
    
	/**
     * Constructeur d'objets de classe Humain
     */
    public Humain()
    {
        // initialisation des variables d'instance
        this.age = 0;
        this.fonction = "Aucun";
    }

    public Regiment getRegiment() {
		return this.regiment;
	}

	protected void setRegiment(Regiment regiment) {
		this.regiment = regiment;
	}

	public void rejoindre(Regiment nouvRegiment) {
		varNonNull(nouvRegiment);
		if(!nouvRegiment.getTroupe().contains(this)) {
			if(this.regiment!=null) this.regiment.expulser(this);
			this.setRegiment(nouvRegiment);
			this.regiment.getTroupe().add(this);
			
		}
	}

	protected void varNonNull(Object obj) {
		if(obj==null) {
			throw new NullPointerException();
		}
	}
	
	public void quitterRegiment() {
		this.regiment.getTroupe().remove(this);
		this.regiment = null;
	}

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void devenirSoldat(int age)
    {
    	if(age>=18) {
	        this.age = age;
	        this.fonction = "Soldat";
    	}
    	else if (age >= 0) {
    		this.age = age;
    	}
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public String getFonction(){
        return this.fonction;
    }
   
}
