package Gielda;

public class ProgramKategoryczny extends Program{
    @Override
    public double coMyślisz(double[] historia, int nDni, Kategoria kategoria){ // zinterpretowalem to jako aktualna cene, co nie jest uoszczególowione
        Zasób[] zasoby = kategoria.podajZasoby();
        double suma = 0;
        int ilość = kategoria.podajNZasobów();
        for(int i = 0; i<ilość;i++){
            suma += zasoby[i].podajAktCenę();
        }
        return (double)(suma / (double)ilość);
    }
}
