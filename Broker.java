package Gielda;

public abstract class Broker extends Gracz{
    public abstract void zglaszamSię(Klient klient);
    public abstract void ustalNrRejestracji(int numer);
    public abstract void dodajProgram(Program program);
}
