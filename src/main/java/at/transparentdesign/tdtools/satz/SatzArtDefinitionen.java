package at.transparentdesign.tdtools.satz;

import java.util.*;

public class SatzArtDefinitionen {
    public static final List<Satzart0FIBUBuchungssatzFields> AUSGANGSRECHNUNG_SPALTEN;
    public static final String[] AUSGANGSRECHNUNG_SPALTEN_HEADER;
    static {
        AUSGANGSRECHNUNG_SPALTEN = List.of(
                Satzart0FIBUBuchungssatzFields.SATZART,
                Satzart0FIBUBuchungssatzFields.KONTO,
                Satzart0FIBUBuchungssatzFields.GKTO,
                Satzart0FIBUBuchungssatzFields.BELEGNR,
                Satzart0FIBUBuchungssatzFields.BELEGDAT,
                Satzart0FIBUBuchungssatzFields.SYMBOL,
                Satzart0FIBUBuchungssatzFields.BUCOD,
                Satzart0FIBUBuchungssatzFields.MWST,
                Satzart0FIBUBuchungssatzFields.STEUCOD,
                Satzart0FIBUBuchungssatzFields.BETRAG,
                Satzart0FIBUBuchungssatzFields.STEUER,
                Satzart0FIBUBuchungssatzFields.TEXT,
                Satzart0FIBUBuchungssatzFields.KOST,
                Satzart0FIBUBuchungssatzFields.FILIALE);

        List<String> header = new ArrayList<>();
        for (Satzart0FIBUBuchungssatzFields field : AUSGANGSRECHNUNG_SPALTEN) {
            header.add(field.getNtcsBookingheaderElement());
        }

        AUSGANGSRECHNUNG_SPALTEN_HEADER = header.toArray(new String[0]);
    }
}
