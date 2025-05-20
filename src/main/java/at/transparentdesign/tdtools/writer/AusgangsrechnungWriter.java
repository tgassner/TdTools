package at.transparentdesign.tdtools.writer;

import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatz;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static at.transparentdesign.tdtools.satz.SatzArtDefinitionen.AUSGANGSRECHNUNG_SPALTEN_HEADER;

public class AusgangsrechnungWriter {

    public void write(List<Satzart0FIBUBuchungssatz> satzArten) throws IOException {
        FileWriter fileWriter = new FileWriter("c:\\temp\\aaa.csv"); // TODO!!

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(AUSGANGSRECHNUNG_SPALTEN_HEADER)
                .setDelimiter(';')
                .setRecordSeparator("\r\n")
                .get();

        try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)){
            for (Satzart0FIBUBuchungssatz satzArt : satzArten) {
                // Write each person's data to the CSV file
                csvPrinter.printRecord(
                        satzArt.getSatzart(),
                        satzArt.getKonto(),
                        satzArt.getGkto(),
                        satzArt.getBelegnr(),
                        satzArt.getBelegdat(),
                        satzArt.getSymbol(),
                        satzArt.getBucod(),
                        satzArt.getMwst(),
                        satzArt.getSteucod(),
                        satzArt.getBetrag(),
                        satzArt.getSteuer(),
                        satzArt.getText(),
                        satzArt.getKost(), //Kostenstelle?!?
                        "" //Filiale ?!?
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
