package Armee;

public abstract class Humain {
	   // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int age;
    private String fonction;
    private Regiment regiment;
    private String nom;
    private String prenom;
    
	/**
     * Constructeur d'objets de classe Humain
     */
    public Humain(String nom, String prenom)
    {
    	if(nom == null || prenom == null)
    	{
    		throw new IllegalArgumentException("Veuillez vérifier les paramètres");
    	}
        // initialisation des variables d'instance
        this.nom = nom;
        this.prenom = prenom;
        this.age = 0;
        this.fonction = "Aucun";
    }
    
    public Humain()
    {
        this.nom = "John";
        this.prenom = "Doe";
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
			if(this.regiment != null) this.regiment.expulser(this);
			this.setRegiment(nouvRegiment);
			this.regiment.getTroupe().add(this);
			
		}
	}

	protected void varNonNull(Object obj) {
		if(obj == null) {
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
    public void obtenirFonction(int age, String fct)
    {
    	if(age >= 18) {
	        this.age = age;
	        this.fonction = fct;
    	}
    	else if (age >= 0) {
    		this.age = age;
    	}
    }
    
    public void obtenirFonction(int age)
    {
    	if(age >= 40) {
	        this.age = age;
	        this.fonction = "Senior";
    	}
    	else if(age >= 35) {
	        this.age = age;
	        this.fonction = "Vétéran";
    	}
    	else if(age >= 30) {
	        this.age = age;
	        this.fonction = "Officier";
    	}
    	else if(age >= 22) {
	        this.age = age;
	        this.fonction = "Chevalier";
    	}
    	else if(age >= 18) {
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
    
    public String getNom()
    {	
        return this.nom;
    }
    
    public String getPrenom()
    {
        return this.prenom;
    }
   
}


