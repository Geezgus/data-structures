import com.github.geezgus.datastructure.BinarySearchTree;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //region Load parameters
        IOParams params;
        try {
            params = new IOParams(new File("src/res/params"));
            System.out.println("Parameter file open successfully.");
        } catch (FileNotFoundException e) {
            System.err.printf("Could not read %s.%n", "src/res/params");
            return;
        }
        //endregion

        //region Prepare tree
        BinarySearchTree<Player> tree = new BinarySearchTree<>((o1, o2) -> {
            if (params.ascending) return o1.getField(params.orderBy).compareTo(o2.getField(params.orderBy));
            else return o2.getField(params.orderBy).compareTo(o1.getField(params.orderBy));
        });
        tree.maxElementsToString = params.limit;
        //endregion

        //region Read input
        try (FileReader fr = new FileReader(params.inPath)) {
            BufferedReader bufferedReader = new BufferedReader(fr);

            String headRow = bufferedReader.readLine();
            String[] columnNames = headRow.split(",");

            //region Load tree
            while (true) {
                String row = bufferedReader.readLine();
                if (row == null) break;

                String[] columnValues = row.split(",(?=(?:[^\"\\n]*\"[^\"\\n]*\")*[^\"\\n]*$)");

                Player player = new Player();
                for (int i = 0; i < columnValues.length; i++) {
                    String column = columnNames[i];

                    player.setField(column, columnValues[i]);
                }
                tree.add(player);
            }
            System.out.println("Tree successfully loaded.");
            //endregion

            System.out.println("Input file read successfully.");
        } catch (IOException e) {
            System.err.printf("Could not read %s.%n", params.inPath);
            return;
        }
        //endregion

        //region Limit results
        String[] splitTree = tree.toString().split("\n");
        String[] results = new String[params.limit];
        for (int i = 0; i < splitTree.length && i < results.length; i++) {
            results[i] = splitTree[i];
        }
        //endregion

        //region Write output
        try (FileWriter fw = new FileWriter(params.outPath)) {
            fw.write(getCsvHeadRow(params.fields));

            for (String result : results) {
                fw.write(getCsvRow(result, params.fields));
                fw.write('\n');
            }

            fw.flush();
            System.out.println("Output file written successfully.");
        } catch (IOException e) {
            System.err.printf("Could not write %s.%n", params.outPath);
            return;
        }
        //endregion
    }

    private static String getCsvHeadRow(String[] fieldNames) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fieldNames.length; i++) {
            sb.append(fieldNames[i]);

            if (i < fieldNames.length - 1) {
                sb.append(",");
            }
        }

        sb.append('\n');

        return sb.toString();
    }

    private static String getCsvRow(String playerString, String[] fieldNames) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fieldNames.length; i++) {
            Pattern pattern = Pattern.compile(Pattern.quote(fieldNames[i])+": '(.*?)'");
            Matcher matcher = pattern.matcher(playerString);

            if (matcher.find()) {
                sb.append(matcher.group(1));
            }

            if (i < fieldNames.length - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}