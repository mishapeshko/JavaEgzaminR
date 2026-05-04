package Gielda;

import java.util.Arrays;

public class Zasób {
    private String nazwa;
    private Kategoria kategoria;
    private double cenaPoczątkowa;
    private int nJednostek; // na rynku dostępnych ( nie najlepsz nazwa )
    private double aktCena;
    private double[] historia = new double[0];
    private int nDniodPoczątku;
    public Zasób(String nazwa, Kategoria kategoria, int nJednostek, double cenaPoczątkowa, Gielda gielda){
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.nJednostek = nJednostek;
        this.cenaPoczątkowa = cenaPoczątkowa;
        this.aktCena = cenaPoczątkowa;
        this.nDniodPoczątku = 1;
        kategoria.dodajZasób(this);
        gielda.dodajZasób(this); // dodac gielde do konstruktora - sensowny pomysl ( bardzo );
    }
    public void zmieńCenęO(double wartość){
        aktCena = aktCena+wartość < 0 ? 0 : aktCena + wartość;
    }
    public double[] podajHistorię(){
        return this.historia;
    }
    public double podajAktCenę(){
        return this.aktCena;
    }
    public int podajLiczbęDni(){
        return this.nDniodPoczątku;
    }
    public int podajLiczbę(){
        return this.nJednostek;
    }
    public Kategoria podajKategorię(){
        return this.kategoria;
    }
    public void zmniejszIlość(int ilość){
        this.nJednostek-=ilość;
    }
    public void zwiększIlość(int ilość){
        this.nJednostek += ilość;
    }
    public void ustalHistorycznąWartość(){
        if(nDniodPoczątku==historia.length){
            historia = Arrays.copyOf(historia, więcej(nDniodPoczątku));
        }
        this.historia[nDniodPoczątku++] = aktCena;
    }
    private int więcej(int n){
        return (3*n)/2+2;
    }
}
