package at.transparentdesign.tdtools.loader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Bmd55FileLoader implements FileLoader {
    @Override
    public List<String> loadFileToLines(Path fileName, boolean removeEmptyLines) throws IOException {
        try {
            List<String> listRead = Files.readAllLines(fileName, Charset.defaultCharset());
            List<String> filteredList = new ArrayList<>();
            for (String readLine : listRead) {
                if (!removeEmptyLines || StringUtils.isNoneEmpty(readLine)) {
                    filteredList.add(readLine);
                }
            }
            return filteredList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}