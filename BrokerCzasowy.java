package Gielda;

import java.util.Arrays;

public class BrokerCzasowy extends Broker{
    private int nrRejestracji;
    private Strategia strategia;
    private Klient[] klienci = new Klient[0];
    private int nKlientów = 0;
    private double stanKonta;
    private Program[] ProgramyStosowane = new Program[0];
    private int nProgramów = 0;
    private int procent = 0;
    public BrokerCzasowy(Gielda gielda, Strategia strategia, int procent){
        gielda.zarejestrujMnie(this);
        this.strategia = strategia;
        this.stanKonta = 0;
    }
    public void ustalNrRejestracji(int numer){
        this.nrRejestracji = numer;
    }
    public void dodajProgram(Program program){
        if(nProgramów == ProgramyStosowane.length){
            ProgramyStosowane = Arrays.copyOf(ProgramyStosowane, więcej(nProgramów));
        }
        ProgramyStosowane[nProgramów++] = program;
    }
    @Override
    public void kupnoZasobów(Gielda gielda){
        Zasób[] zasoby = gielda.podajZasoby();
        int nZasobów = gielda.podajNZasobów();
        for(int i = 0;i<nKlientów;i++){
            Klient aktualny = klienci[i];
            if(aktualny.ilePozostalo() > 0) {
                for (int j = 0; j < nZasobów; j++) {
                    double cena = zasoby[j].podajAktCenę();
                    if (this.strategia.czyKupuję(zasoby[j], aktualny.podajBudżet())) {
                        int ilość = this.strategia.ileKupuję(zasoby[j], aktualny.podajBudżet());
                        gielda.zmniejszZasób(zasoby[j], ilość);
                        aktualny.dodajZasób(zasoby[j], ilość);
                        aktualny.zmniejszBudżet(ilość, cena);
                    }
                }
                aktualny.zmniejszLiczbęDni();
            }
        }
    }
    @Override
    public void sprzedażZasobów(Gielda gielda){
        for(int i = 0; i<nKlientów; i++){
            Klient aktualny = klienci[i];
            Zasób[] zasoby = aktualny.podajZasoby();
            double[] cenyPrzyZakupie = aktualny.podajCeny();
            int[] ilości = aktualny.podajIlości();
            int nZasobów = aktualny.podajNZasobów();
            if(aktualny.ilePozostalo() > 0) {
                for (int j = 0; j < zasoby.length; j++) {
                    if (zasoby[j] != null) {
                        if (this.strategia.czySprzedaję(zasoby[j], cenyPrzyZakupie[j], ProgramyStosowane)) {
                            double suma = zasoby[j].podajAktCenę() * ilości[j];
                            gielda.dodajIlość(zasoby[j], ilości[j]);
                            aktualny.zwiększStanKonta(suma * (1 - this.procent / 100.0));
                            aktualny.usuńZasób(j);
                            this.stanKonta += suma * this.procent;
                        }
                    }
                }
            }
            else if(aktualny.ilePozostalo() == 0){
                for(int j = 0; j < zasoby.length; j++){
                    if(zasoby[j] != null){
                        double suma = zasoby[j].podajAktCenę() * ilości[j];
                        gielda.dodajIlość(zasoby[j], ilości[j]);
                        aktualny.zwiększStanKonta(suma * (1 - this.procent / 100.0));
                        aktualny.usuńZasób(j);
                        this.stanKonta += suma * this.procent;
                    }
                }
            }
        }
    }
    @Override
    public void zglaszamSię(Klient klient){
        dodajKlienta(klient);
    }
    private void dodajKlienta(Klient klient){
        if(nKlientów== klienci.length){
            klienci = Arrays.copyOf(klienci, więcej(nKlientów));
        }
        klienci[nKlientów++] = klient;
    }
    private int więcej(int n){
        return (3*n)/2+2;
    }
}
