package Gielda;

import java.util.Arrays;

public class Biotech extends Kategoria{
    private Zasób[] zasoby = new Zasób[0];
    private int nZasobów = 0;
    @Override
    public Zasób[] podajZasoby(){
        return this.zasoby;
    }
    public void dodajZasób(Zasób zasób){
        if(nZasobów==zasoby.length){
            zasoby = Arrays.copyOf(zasoby, więcej(nZasobów));
        }
        zasoby[nZasobów++] = zasób;
    }
    private int więcej(int n){
        return (3*n)/2+2;
    }
    public int podajNZasobów(){
        return this.nZasobów;
    }
}
