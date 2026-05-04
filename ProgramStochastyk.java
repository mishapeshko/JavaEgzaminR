package Gielda;

import java.util.Random;

public class ProgramStochastyk extends Program{
    private double n;
    public ProgramStochastyk(double nParametr){
        this.n = nParametr;
    }
    @Override
    public double coMyślisz(double[] historia, int nDni, Kategoria kategoria){
        Random random = new Random();
        double x = random.nextDouble(n);
        boolean większeOdZera = random.nextBoolean();
        return większeOdZera ? (100.0+x) * historia[nDni-1] : (100-x) * historia[nDni-1];
    }
}
