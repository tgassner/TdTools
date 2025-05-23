package at.transparentdesign.tdtools.writer;

import at.transparentdesign.tdtools.satz.Bmd55SatzartIBUBuchungssatz;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static at.transparentdesign.tdtools.satz.SatzArtDefinitionen.AUSGANGSRECHNUNG_SPALTEN_HEADER;

public class AusgangsrechnungWriter {

    public void write(List<Bmd55SatzartIBUBuchungssatz> satzArten, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(AUSGANGSRECHNUNG_SPALTEN_HEADER)
                .setDelimiter(';')
                .setRecordSeparator("\r\n")
                .get();

        try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)){
            for (Bmd55SatzartIBUBuchungssatz satzArt : satzArten) {
                // Write each person's data to the CSV file
                csvPrinter.printRecord(
                        satzArt.getSatzart(),
                        satzArt.getKonto(),
                        satzArt.getBuchdatFormated(),
                        satzArt.getGkto(),
                        satzArt.getBelegnr(),
                        satzArt.getBelegdatFormated(),
                        satzArt.getMwst(),
                        satzArt.getSteucod(),
                        satzArt.getBucod(),
                        satzArt.getBetrag(),
                        satzArt.getSteuer(),
                        satzArt.getSkonto(),
                        satzArt.getText(),
                        satzArt.getSymbol(),
                        satzArt.getExtbelegnr(),
                        satzArt.getKost(),
                        ""
                );
            }
        } catch (IOException e) {
            throw ExceptionUtils.asRuntimeException(e);
        }
    }
}
