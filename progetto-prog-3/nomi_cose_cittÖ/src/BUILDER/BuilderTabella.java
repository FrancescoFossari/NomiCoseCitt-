package BUILDER;

public class BuilderTabella implements Builder{
    private int tot;
    private String nome;
    private String cosa;
    private String citta;
    private String frutta;
    private String verbi;
    private String animali;
    private String piante;
    private String cantanti;
    private String nazioni;
    private String mestieri;
    private String celebrita;


    public BuilderTabella() {
    }

    public Builder setTot(int tot) {
        this.tot = tot;
        return this;
    }

    public Builder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Builder setCosa(String cosa) {
        this.cosa = cosa;
        return this;
    }

    public Builder setCitta(String citta) {
        this.citta = citta;
        return this;
    }

    public Builder setFrutta(String frutta) {
        this.frutta = frutta;
        return this;
    }

    public Builder setVerbi(String verbi) {
        this.verbi = verbi;
        return this;
       
    }
    
    public Builder setAnimali(String animali) {
        this.animali = animali;
        return this;
       
    }

    
    public Builder setPiante(String piante) {
        this.piante = piante;
        return this;
    }

    
    public Builder setCantanti(String cantanti) {
        this.cantanti = cantanti;
        return this;
    }


    public Builder setNazioni(String nazioni) {
        this.nazioni = nazioni;
        return this;
       
    }

    
    public Builder setMestieri(String mestieri) {
        this.mestieri = mestieri;
        return this;
    }

    
    public Builder setCelebrita(String celebrita) {
        this.celebrita = celebrita;
        return this;
        
    }


    public Tabella build() {
        return new Tabella(tot,nome,cosa,citta,frutta,verbi,animali,piante,cantanti,nazioni,mestieri,celebrita);
    }
}
