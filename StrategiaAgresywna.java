package Gielda;

public class StrategiaAgresywna extends Strategia{
    private double parametr;
    public StrategiaAgresywna(double parametr){
        this.parametr = parametr;
    }
    @Override
    public boolean czyKupuję(Zasób zasób, double budżet){
        if(zasób.podajLiczbęDni() > 1) {
            double maksymalnaCena = zasób.podajHistorię()[zasób.podajLiczbęDni() - 2] * (1.0 - this.parametr / 100.0);
            if (zasób.podajHistorię()[zasób.podajLiczbęDni() - 1] < maksymalnaCena) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
    @Override
    public int ileKupuję(Zasób zasób, double budżet){
        int ile = (int)(budżet / zasób.podajAktCenę());
        if(ile > zasób.podajLiczbę() / 2){
            return zasób.podajLiczbę() / 2;
        }
        else{
            return ile;
        }
    }
    @Override
    public boolean czySprzedaję(Zasób zasób, double cenaZakupu, Program[] programy){
        int licznik = 0;
        for(Program p : programy){
            if(p.coMyślisz(zasób.podajHistorię(), zasób.podajLiczbęDni(), zasób.podajKategorię()) < cenaZakupu){
                licznik++;
            }
        }
        return licznik > 0;
    }
}
