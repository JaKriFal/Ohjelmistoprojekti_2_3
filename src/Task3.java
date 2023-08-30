import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rand = new Random();
        //tässä käytetään mielivaltaista datasettiä, voidaan vaikka hahmottaa että jokainen datasetin piste vastaa jotain ikähaarukkaa,
        //Koodi toimii mielivaltaisilla ikähaarukoilla ja oppilaiden määrällä.
        //Halusin tunkea feikkidataan väkisin tuon yhden nollan ikäluokan koska se vähän vaikeutti hommaa.
        int[] dataset = {2,5,3,0,2,1,7,8,4,2,6,9,12,1,2,0,0,0,1};

        double sum = 0;

        for (int i : dataset) {
            sum += i;
        }

        //lasketaan kuinka suuri osuus kukin ikäluokka on luokan kokonaismäärästä
        double[] percentages = new double[dataset.length];
        for (int i = 0 ; i < dataset.length ; i++) {
            percentages[i] = dataset[i] / sum;
        }

        double[] targets = new double[dataset.length];

        int[] hits = new int[dataset.length];

        for (int i : hits) {
            i = 0;
        }

        //targets taulukossa on rajat joita vastaan satunnaislukuja tarkistetaan
        targets[0] = percentages[0];
        for (int i = 1 ; i < dataset.length ; i++) {
            targets[i] = targets[i-1] + percentages[i];
        }

        //arvotaan satunnaisluku välillä 0-1 ja lisätään oppilaita hits-taulukkoon
        for(int i = 0; i < 1000 ; i++) {
            double test = rand.nextDouble();

            if (test > 0 && test < targets[0]) {
                hits[0] += 1;
            } else {
                for (int j = 1; j < dataset.length; j++) {
                    if (test > targets[j-1] && test < targets[j]) {
                        hits[j] += 1;
                    }}}}
        //printataan eri ikähaarukoiden (simuloidut) oppilasmäärät, tuntuis tuottavan ihan järkevää settiä!
        for (int i = 0 ; i < hits.length ; i++) {
            System.out.println((18+i) +  ":" +hits[i]);
        }


    }

}
