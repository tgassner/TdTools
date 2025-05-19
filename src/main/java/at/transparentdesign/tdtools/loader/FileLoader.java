package at.transparentdesign.tdtools.loader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileLoader {
    List<String> loadFileToLines(Path fileName, boolean removeEmptyLines) throws IOException;
}
