package at.transparentdesign.tdtools.parser;

import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatz;
import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatzFields;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Satzart0FIBUBuchungssatzParser {
    public Satzart0FIBUBuchungssatz parse(String record) {
        Satzart0FIBUBuchungssatz satzart0FIBUBuchungssatz = new Satzart0FIBUBuchungssatz();

        satzart0FIBUBuchungssatz.setSatzart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SATZART));
        satzart0FIBUBuchungssatz.setKonto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KONTO));
        satzart0FIBUBuchungssatz.setBuchdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.BUCHDAT));
        satzart0FIBUBuchungssatz.setGkto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.GKTO));
        satzart0FIBUBuchungssatz.setBelegnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BELEGNR));
        satzart0FIBUBuchungssatz.setBelegdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.BELEGDAT));
        satzart0FIBUBuchungssatz.setKost(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOST));
        satzart0FIBUBuchungssatz.setUnused1(parseStringValue(record, Satzart0FIBUBuchungssatzFields.UNUSED1));
        satzart0FIBUBuchungssatz.setKotraeger(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOTRAEGER));
        satzart0FIBUBuchungssatz.setKomenge(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.KOMENGE));
        satzart0FIBUBuchungssatz.setKomengenr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOMENGENR));
        satzart0FIBUBuchungssatz.setKovariator(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.KOVARIATOR));
        satzart0FIBUBuchungssatz.setKoperiode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOPERIODE));
        satzart0FIBUBuchungssatz.setKomonteiler(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOMONTEILER));
        satzart0FIBUBuchungssatz.setMwst(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.MWST));
        satzart0FIBUBuchungssatz.setSteucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.STEUCOD));
        satzart0FIBUBuchungssatz.setEbkennz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.EBKENNZ));
        satzart0FIBUBuchungssatz.setBucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCOD));
        satzart0FIBUBuchungssatz.setBetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.BETRAG));
        satzart0FIBUBuchungssatz.setSteuer(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.STEUER));
        satzart0FIBUBuchungssatz.setSkonto(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTO));
        satzart0FIBUBuchungssatz.setOpbetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.OPBETRAG));
        satzart0FIBUBuchungssatz.setPeriode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.PERIODE));
        satzart0FIBUBuchungssatz.setKursnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KURSNR));
        satzart0FIBUBuchungssatz.setFwkurs(parseIntValue(record, Satzart0FIBUBuchungssatzFields.FWKURS));
        satzart0FIBUBuchungssatz.setFwfaktor(parseIntValue(record, Satzart0FIBUBuchungssatzFields.FWFAKTOR));
        satzart0FIBUBuchungssatz.setFwbetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWBETRAG));
        satzart0FIBUBuchungssatz.setFwsteuer(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWSTEUER));
        satzart0FIBUBuchungssatz.setFwskonto(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWSKONTO));
        satzart0FIBUBuchungssatz.setFwopbetr(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWOPBETR));
        satzart0FIBUBuchungssatz.setLandkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LANDKZ));
        satzart0FIBUBuchungssatz.setLkzkurs(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LKZKURS));
        satzart0FIBUBuchungssatz.setLkzfaktor(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LKZFAKTOR));
        satzart0FIBUBuchungssatz.setText(parseStringValue(record, Satzart0FIBUBuchungssatzFields.TEXT));
        satzart0FIBUBuchungssatz.setSymbol(parseStringValue(record, Satzart0FIBUBuchungssatzFields.SYMBOL));
        satzart0FIBUBuchungssatz.setExtbelegnr(parseStringValue(record, Satzart0FIBUBuchungssatzFields.EXTBELEGNR));
        satzart0FIBUBuchungssatz.setZesskz(parseStringValue(record, Satzart0FIBUBuchungssatzFields.ZESSKZ));
        satzart0FIBUBuchungssatz.setZziel(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZZIEL));
        satzart0FIBUBuchungssatz.setSkontopz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTOPZ));
        satzart0FIBUBuchungssatz.setSkontotage(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SKONTOTAGE));
        satzart0FIBUBuchungssatz.setSkontopz2(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTOPZ2));
        satzart0FIBUBuchungssatz.setSkontotage2(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SKONTOTAGE2));
        satzart0FIBUBuchungssatz.setValutadatum(parseDateValue(record, Satzart0FIBUBuchungssatzFields.VALUTADATUM));
        satzart0FIBUBuchungssatz.setWechseldatum(parseDateValue(record, Satzart0FIBUBuchungssatzFields.WECHSELDATUM));
        satzart0FIBUBuchungssatz.setVertnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.VERTNR));
        satzart0FIBUBuchungssatz.setProvpz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.PROVPZ));
        satzart0FIBUBuchungssatz.setAuftkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.AUFTKZ));
        satzart0FIBUBuchungssatz.setAuftnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.AUFTNR));
        satzart0FIBUBuchungssatz.setZmart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZMART));
        satzart0FIBUBuchungssatz.setZmbericht(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZMBERICHT));
        satzart0FIBUBuchungssatz.setMenge(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.MENGE));
        satzart0FIBUBuchungssatz.setBenutzer(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BENUTZER));
        satzart0FIBUBuchungssatz.setBuchart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCHART));
        satzart0FIBUBuchungssatz.setBuchkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCHKZ));
        satzart0FIBUBuchungssatz.setMahnz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.MAHNZ));
        satzart0FIBUBuchungssatz.setLeistdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.LEISTDAT));
        satzart0FIBUBuchungssatz.setUvaPeriode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UVA_PERIODE));
        satzart0FIBUBuchungssatz.setUidnr(parseStringValue(record, Satzart0FIBUBuchungssatzFields.UIDNR));
        satzart0FIBUBuchungssatz.setSteuerart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.STEUERART));
        satzart0FIBUBuchungssatz.setKorekonto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOREKONTO));
        satzart0FIBUBuchungssatz.setErZahlbank(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ER_ZAHLBANK));
        satzart0FIBUBuchungssatz.setBauSteucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BAU_STEUCOD));
        satzart0FIBUBuchungssatz.setUnused2(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UNUSED2));
        satzart0FIBUBuchungssatz.setVstAbzugpz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.VST_ABZUGPZ));
        satzart0FIBUBuchungssatz.setZvMahnsp(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZV_MAHNSP));
        satzart0FIBUBuchungssatz.setErSteukorrKz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ER_STEUKORR_KZ));
        satzart0FIBUBuchungssatz.setGegenbuchkz(parseStringValue(record, Satzart0FIBUBuchungssatzFields.GEGENBUCHKZ));
        satzart0FIBUBuchungssatz.setVerbuchkz(parseStringValue(record, Satzart0FIBUBuchungssatzFields.VERBUCHKZ));
        satzart0FIBUBuchungssatz.setUnused3(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UNUSED3));
        satzart0FIBUBuchungssatz.setUnused4(parseStringValue(record, Satzart0FIBUBuchungssatzFields.UNUSED4));

        return satzart0FIBUBuchungssatz;
    }

    private double parseDoubleValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        int intVal = parseIntValue(record, satzart0FIBUBuchungssatzFields);
        return ((double)intVal) / 100.0;
    }

    private LocalDate parseDateValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        String str = parseStringValue(record, satzart0FIBUBuchungssatzFields);
        try {
            return LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private int parseIntValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields)  {
        String str = parseStringValue(record, satzart0FIBUBuchungssatzFields);
        if (!NumberUtils.isParsable(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    private String parseStringValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        return StringUtils.substring(record, satzart0FIBUBuchungssatzFields.getStartPos() - 1, satzart0FIBUBuchungssatzFields.getEndPos());
    }

    /*
    public static void main(String[] args) {
        for (Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzField : Satzart0FIBUBuchungssatzFields.values()) {
            System.out.println(satzart0FIBUBuchungssatzField.getId() + " " +  satzart0FIBUBuchungssatzField.toString() + " " + satzart0FIBUBuchungssatzField.getStartPos() + " " + satzart0FIBUBuchungssatzField.getEndPos());
        }
    }
    */

}
