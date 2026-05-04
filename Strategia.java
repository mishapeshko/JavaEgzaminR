package Gielda;

public abstract class Strategia {
    public abstract boolean czyKupuję(Zasób zasób, double budżet);
    public abstract int ileKupuję(Zasób zasób, double budżet);
    public abstract boolean czySprzedaję(Zasób zasób, double cenaZakupu, Program[] programy);
}
