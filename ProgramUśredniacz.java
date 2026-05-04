package Gielda;

public class ProgramUśredniacz extends Program{
    private int k;
    public ProgramUśredniacz(int kPoprzednichDni){
        this.k = kPoprzednichDni;
    }
    @Override
    public double coMyślisz(double[] historia, int nDni, Kategoria kategoria){
        double suma = 0;
        for(int l = nDni-1; l>=nDni-this.k; l--){
            suma += historia[l];
        }
        return (double)(suma / (double)this.k);
    }
}
