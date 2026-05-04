package Gielda;

import java.util.Arrays;
import java.util.Random;

public class Gielda {
    private Zasób[] zasoby = new Zasób[0];
    private int nZasobów;
    private Gracz[] gracze = new Gracz[0];
    private int nGraczy = 0;
    public void sesjaKupna(){
        for(int i = 0; i<nGraczy;i++){
            gracze[i].kupnoZasobów(this);
        }
        fluktuacja();
    }
    public void sesjaSprzedaży(){
        for(int i = 0; i<nGraczy;i++){
            gracze[i].sprzedażZasobów(this);
        }
    }
    public void fluktuacja(){
        Random random = new Random();
        for(int i = 0; i < nZasobów; i++){
            boolean wiekszaOdZera = random.nextBoolean();
            double wartość = random.nextDouble(5);
            if(wiekszaOdZera){
                zasoby[i].zmieńCenęO(wartość);
            }
            else{
                zasoby[i].zmieńCenęO(-wartość);
            }
            zasoby[i].ustalHistorycznąWartość();
        }
    }
    public void zarejestrujMnie(Gracz gracz){
        dodajGracza(gracz);
        gracz.ustalNrRejestracji(nGraczy++);
    }
    private void dodajGracza(Gracz gracz){
        if(gracze.length==nGraczy){
            gracze = Arrays.copyOf(gracze, więcej(nGraczy));
        }
        gracze[nGraczy++] = gracz;
    }
    private int więcej(int n){
        return (3*n)/2+2;
    }
    public void dodajZasób(Zasób zasób){
        if(nZasobów==zasoby.length){
            zasoby = Arrays.copyOf(zasoby, więcej(nZasobów));
        }
        zasoby[nZasobów++] = zasób;
    }
    public Zasób[] podajZasoby(){
        return this.zasoby;
    }
    public int podajNZasobów(){
        return this.nZasobów;
    }
    public void zmniejszZasób(Zasób zasób, int ilość){
        zasób.zmniejszIlość(ilość);
    }
    public void dodajIlość(Zasób zasób, int ilość){
        zasób.zwiększIlość(ilość);
    }
}
