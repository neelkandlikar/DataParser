import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


      String output =  Utils.readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<ElectionResults> results = Utils.parse2016ElectionResults(output);
        System.out.println(results);



    }
}
