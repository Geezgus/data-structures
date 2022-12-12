import com.github.geezgus.datastructure.BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        IOParams params;
        try {
            params = new IOParams(new File("src/main/params"));
            System.out.println("Parameter file open successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Could not read.");
            return;
        }

        BinarySearchTree<Player> tree = new BinarySearchTree<>((o1, o2) -> {
            if (params.ascending) return o1.getField(params.orderBy).compareTo(o2.getField(params.orderBy));
            else return o2.getField(params.orderBy).compareTo(o1.getField(params.orderBy));
        });

        tree.searchLimit = params.limit;

        //region Add Mock Players To Tree
        Player p1 = new Player()
                .setField("name", "Vini. Jr")
                .setField("birth_date", "2000-07-12")
                .setField("full_name", "Vinícius José Paixão de Oliveira Júnior")
                .setField("age", "22")
                .setField("id", "123");

        Player p2 = new Player()
                .setField("name", "Neymar")
                .setField("birth_date", "1992-02-05")
                .setField("full_name", "Neymar da Silva Santos Júnior")
                .setField("age", "30")
                .setField("id", "789");

        Player p3 = new Player()
                .setField("name", "Richarlison")
                .setField("birth_date", "1997-05-10")
                .setField("full_name", "Richarlison de Andrade")
                .setField("age", "25")
                .setField("id", "456");

        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        //endregion

        String[] results = tree.toString().split("\n");

        try {
            FileWriter fw = new FileWriter(params.outPath);

            fw.write(getCsvHeadRow(params.fields));

            for (String result : results) {
                fw.write(getCsvRow(result, params.fields));
                fw.write('\n');
            }

            fw.flush();
            System.out.println("Output file written successfully.");
        } catch (IOException e) {
            System.err.println("Could not write.");
            return;
        }
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
            Pattern pattern = Pattern.compile(fieldNames[i] + ": '(.*?)'");
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