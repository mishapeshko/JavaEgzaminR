package Gielda;

import java.util.Random;

public class StrategiaLosowa extends Strategia{
    @Override
    public boolean czyKupuję(Zasób zasób, double budżet){
        Random random = new Random();
        if(random.nextBoolean()){
            return true;
        }
        return false;
    }
    @Override
    public int ileKupuję(Zasób zasób, double budżet){
        Random random = new Random();
        int maksymalnaIlość = (int)(budżet / zasób.podajAktCenę());
        return random.nextInt(maksymalnaIlość);
    }
    @Override
    public boolean czySprzedaję(Zasób zasób, double cenaZakupu, Program[] programy){
        ProgramLosowy losowy = new ProgramLosowy();
        return losowy.coMyślisz(zasób.podajHistorię(), zasób.podajLiczbęDni(), zasób.podajKategorię()) < cenaZakupu;
    }
}
