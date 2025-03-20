import java.util.Random;

public class Main {

    Random random = new Random();
    DistributoreGelato g = new DistributoreGelato(random.nextInt(300 - 1) + 1, random.nextInt(300 - 1) + 1);


    public static void main(String[] args) {
        Random random = new Random();
        DistributoreGelato g = new DistributoreGelato(random.nextInt(300 - 1) + 1, random.nextInt(300 - 1) + 1);
        boolean ON = true;
        int k = random.nextInt(50 - 10) + 10;

        int stranezze = 0  ;
        while (ON) {
            while (stranezze<8) {
                boolean happened = false; //TIENE CONTO DELL'EFFETTIVO AVVENIMENTO DEGLI EVENTI (possono succedere 1/ciclo)
                try {
                    System.out.println("Altezza attuale: "+g.getAltezza());
                    g.AumentaAltezza(k);
                } catch (GelatoOverloadException e) {
                    System.out.println(e.getMessage());
                }

                if (random.nextInt((100 - 1) + 1) <= 20) {
                    happened = true;
                    System.out.println(g.CambioSapore(random.nextInt(29)));
                }

                if ((random.nextInt(100 - 1) + 1 <= 15) && (!happened)) {
                    happened = true;
                    try {
                        g.CosmicSugarStorm();
                    } catch (CosmicSugarStormException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if ((random.nextInt(100 - 1) + 1 <= 5) && (!happened)) {
                    happened = true;
                    try {
                        g.ControllaTemperatura(3.50);
                    } catch (ThermoDynamicViolationException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (!happened) {
                    stranezze++; //tiene conto dei cicli in cui non succede nulla
                }
            }
            try {
                g.ModalitaZarglax();
            } catch (RebellionException e) {
                System.out.println(e.getMessage());
            }
            ON = false;

        }


    }
}