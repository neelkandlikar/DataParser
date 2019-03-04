import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResults> parse2016ElectionResults(String data) {
        String[] lines = data.split("\n");
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            ElectionResults e = new ElectionResults();
            if (lines[i].contains("\"")) {
                String[] dataOfLine = lines[i].split("\"");
                String[] firstPart = dataOfLine[0].split(",");
                System.out.println(Arrays.toString(firstPart));
                String[] endPart = dataOfLine[2].split(",");
                System.out.println(Arrays.toString(endPart));

                e.setVotes_dem(Double.parseDouble(firstPart[1]));
                e.setVotes_gop(Double.parseDouble(firstPart[2]));
                e.setTotal_votes(Double.parseDouble(firstPart[3]));
                e.setPer_dem(Double.parseDouble(firstPart[4]));
                e.setPer_gop(Double.parseDouble(firstPart[5]));
                e.setDiff(dataOfLine[1]);
                e.setPer_point_diff(endPart[1]);
                e.setState_abbr(endPart[2]);
                e.setCounty_name(endPart[3]);
                e.setCombined_fips(Integer.parseInt(endPart[4]));
                electionResults.add(e);
            }
            else {
                 String [] lineData = lines[i].split(",");
                e.setVotes_dem(Double.parseDouble(lineData[0]));
                e.setVotes_gop(Double.parseDouble(lineData[1]));
                e.setTotal_votes(Double.parseDouble(lineData[2]));
                e.setPer_dem(Double.parseDouble(lineData[4]));
                e.setPer_gop(Double.parseDouble(lineData[5]));
                e.setDiff(lineData[6]);
                e.setPer_point_diff(lineData[7]);
                e.setState_abbr(lineData[8]);
                e.setCounty_name(lineData[9]);
                e.setCombined_fips(Integer.parseInt(lineData[10]));
                electionResults.add(e);

            }

        }

        return electionResults;
    }


}

