package Gielda;

public class ProgramZamrożenieRynku extends Program{
    @Override
    public double coMyślisz(double[] historia, int nDni, Kategoria kategoria){
        return historia[nDni-1];
    }
}
