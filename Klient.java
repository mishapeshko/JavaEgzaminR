package Gielda;

import java.util.Arrays;

public class Klient {
    private double stanKonta;
    private double aktBudżet; // budżet aktualnego zgloszenia - nie mielismy enum-ów czy kolekcji - zle tak ale nie mielismy tego
    private double maksSpadek;
    private double minWzrost;
    private Kategoria[] kategorie;
    private int nDni;
    private int coZostaloZBudżetu;
    private Zasób[] zasobyKupione = new Zasób[0];
    private double[] cenyTychZasobów = new double[0];
    private int[] ilościZasobów = new int[0];
    private int nZasobów = 0;
    public Klient(double stanKonta){
        this.stanKonta = stanKonta;
    }
    public void zglośSięDo(Broker broker){
        broker.zglaszamSię(this);
    }
    public void ustalBudżet(int budżet){
        this.aktBudżet = budżet;
        this.coZostaloZBudżetu = budżet;
    }
    public void ustalSpadek(double Spadek){
        this.maksSpadek = Spadek;
    }
    public void ustalWzrost(double minWzrost){
        this.minWzrost = minWzrost;
    }
    public void ustalKategorie(Kategoria[] kategorie){
        this.kategorie = kategorie;
    }
    public void nDnii(int nDni){
        this.nDni = nDni;
    }
    public void zmniejszLiczbęDni() {
        this.nDni--;
    }
    public double podajBudżet(){
        return coZostaloZBudżetu;
    }
    public void dodajZasób(Zasób zasób, int ilość){
        if(zasobyKupione.length==nZasobów){
            zasobyKupione = Arrays.copyOf(zasobyKupione, więcej(nZasobów));
        }
        zasobyKupione[nZasobów] = zasób;
        ilościZasobów[nZasobów] = ilość;
        cenyTychZasobów[nZasobów++] = zasób.podajAktCenę();
    }
    private int więcej(int n){
        return (3*n)/2+2;
    }
    public void zmniejszBudżet(int ilość, double cena){
        this.coZostaloZBudżetu -= ilość * cena;
    }
    public int podajNZasobów(){
        return this.nZasobów;
    }
    public Zasób[] podajZasoby(){
        return this.zasobyKupione;
    }
    public double[] podajCeny(){
        return this.cenyTychZasobów;
    }
    public int[] podajIlości(){
        return this.ilościZasobów;
    }
    public void zwiększStanKonta(double suma){
        this.stanKonta += suma;
    }
    public void usuńZasób(int indeks){
        zasobyKupione[indeks] = null;
        ilościZasobów[indeks] = 0;
        cenyTychZasobów[indeks] = 0;
    }
    public int ilePozostalo(){
        return this.nDni;
    }
    public Kategoria[] podajKategorie(){
        return this.kategorie;
    }
    public double podajMinWzrost(){
        return this.minWzrost;
    }
    public double podajMaksSpadek(){
        return this.maksSpadek;
    }
}
