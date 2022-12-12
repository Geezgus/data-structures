import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOParams {
    String inPath = null;
    String outPath = null;
    String[] fields = null;
    String orderBy = null;
    Boolean ascending = null;
    Integer limit = null;

    IOParams(File source) throws FileNotFoundException {
        Scanner in = new Scanner(source);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            if (line.matches("\\[in_path].*")) {
                inPath = line.substring(10).trim();
            }

            if (line.matches("\\[out_path].*")) {
                outPath = line.substring(10).trim();
            }

            if (line.matches("^\\[fields].*")) {
                fields = line.substring(8).trim().split(",\s*");
            }

            if (line.matches("^\\[order_by].*")) {
                orderBy = line.substring(10).trim();
            }

            if (line.matches("^\\[ascending].*")) {
                ascending = Boolean.parseBoolean(line.substring(11).trim());
            }

            if (line.matches("^\\[limit].*")) {
                limit = Integer.parseInt(line.substring(7).trim());
            }
        }
    }
}
