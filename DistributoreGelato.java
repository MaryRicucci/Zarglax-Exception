public class DistributoreGelato {
    private int altezza, flavourIndex,  maxaltezza;
    private double temperatura;
    //SCRIVERE I GUSTI DI GELATO
    private String[] gustiGelato = new String[30];

    public DistributoreGelato(int a, int maxaltezza) {
        altezza = a;
        flavourIndex = 0;
        this.maxaltezza = maxaltezza;

    }

    public void AumentaAltezza(int x) throws GelatoOverloadException {
        altezza = altezza + x;
        if (altezza == maxaltezza) {
            CompressioneCriogenica();
            throw new GelatoOverloadException("Il distributore di gelato è troppo grande!");
        }
    }


    public String CambioSapore(int index) {
        flavourIndex = index;
        return gustiGelato[flavourIndex];
    }
    /*
    Con il 15% di probabilità, una tempesta di zucchero spaziale congela il distributore, fermandolo per 4 secondi.
     Si deve lanciare CosmicSugarStormException.
*/

    public void CosmicSugarStorm () throws CosmicSugarStormException{//chiamato dal main se la probabilita accade
        try {
            Thread.sleep (4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new CosmicSugarStormException("La tempesta cosmica di zucchero ha investito il distributore!");
    }


    public boolean ControllaTemperatura (double tmin) throws ThermoDynamicViolationException {
        boolean f = false ; //permette la fine della simulazione
        if (temperatura <= tmin) {
            f = true ;
            throw new ThermoDynamicViolationException("Il distributore di gelato ha causato la ribellione degli alieni/nI gelati sono diventati armi da guerra e hanno" +
                    "permesso di attaccare il governo di Garlax");
        }
        return f ;
    }

    public int getAltezza() {
        return altezza;
    }

    public void ModalitaZarglax () throws RebellionException{
        for (int i = 10 ; i>0; i--) {
            System.out.println(i);
        }
        throw new RebellionException("Il distributore è esploso!\nLa temperatura è scesa troppo e i gelati sono diventati delle armi!");

    }

    private void CompressioneCriogenica() {
        altezza = altezza / 2;

    }
}