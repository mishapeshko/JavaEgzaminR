package Gielda;

import java.util.Random;

public class ProgramLosowy extends Program{
    @Override
    public double coMyślisz(double[] historia, int nDni, Kategoria kategoria){
        Random random = new Random();
        return historia[random.nextInt(nDni)];
    }
}
