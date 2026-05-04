package Gielda;

public class StrategiaZachowawcza extends Strategia{
    @Override
    public boolean czyKupuję(Zasób zasób, double budzet){
        return true;
    }
    @Override
    public int ileKupuję(Zasób zasób, double budżet){
        if(zasób.podajAktCenę() <= budżet){
            return 1;
        }
        return 0;
    }
    @Override
    public boolean czySprzedaję(Zasób zasób, double cenaZakupu, Program[] programy){
        int licznik = 0;
        for(Program p : programy){
            if(p.coMyślisz(zasób.podajHistorię(), zasób.podajLiczbęDni(), zasób.podajKategorię()) < cenaZakupu){
                licznik++;
            }
        }
        return licznik >= programy.length / 2;
    }
}
