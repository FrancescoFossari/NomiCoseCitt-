package BUILDER;

public interface Builder {
    public Builder setTot(int tot);
    public Builder setNome(String nome);
    public Builder setCosa(String cosa);
    public Builder setCitta(String citta);
    public Builder setFrutta(String frutta);
    public Builder setVerbi(String verbi);
    public Builder setAnimali(String animali);
    public Builder setPiante(String piante);
    public Builder setCantanti(String cantanti);
    public Builder setNazioni(String nazioni);
    public Builder setMestieri(String mestieri);
    public Builder setCelebrita(String celebrita);

    public Tabella build();
}