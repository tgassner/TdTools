package at.transparentdesign.tdtools.satz;

import java.util.*;

public class SatzArtDefinitionen {
    public static final List<FiBuRecordFields> AUSGANGSRECHNUNG_SPALTEN;
    public static final String[] AUSGANGSRECHNUNG_SPALTEN_HEADER;
    static {
        AUSGANGSRECHNUNG_SPALTEN = List.of(
                FiBuRecordFields.SATZART,
                FiBuRecordFields.KONTO,
                FiBuRecordFields.BUCHDAT,
                FiBuRecordFields.GKTO,
                FiBuRecordFields.BELEGNR,
                FiBuRecordFields.BELEGDAT,
                FiBuRecordFields.MWST,
                FiBuRecordFields.STEUCOD,
                FiBuRecordFields.BUCOD,
                FiBuRecordFields.BETRAG,
                FiBuRecordFields.STEUER,
                FiBuRecordFields.SKONTO,
                FiBuRecordFields.TEXT,
                FiBuRecordFields.SYMBOL,
                FiBuRecordFields.EXTBELEGNR,
                FiBuRecordFields.KOST,
                FiBuRecordFields.FILIALE);


        List<String> header = new ArrayList<>();
        for (FiBuRecordFields field : AUSGANGSRECHNUNG_SPALTEN) {
            header.add(field.getNtcsBookingheaderElement());
        }

        AUSGANGSRECHNUNG_SPALTEN_HEADER = header.toArray(new String[0]);
    }
}
