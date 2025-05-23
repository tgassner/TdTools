package at.transparentdesign.tdtools.parser;

import at.transparentdesign.tdtools.satz.Bmd55SatzartIBUBuchungssatz;
import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatzFields;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Satzart0FIBUBuchungssatzParser {
    public Bmd55SatzartIBUBuchungssatz parse(String record) {
        Bmd55SatzartIBUBuchungssatz bmd55SatzartIBUBuchungssatz = new Bmd55SatzartIBUBuchungssatz();

        bmd55SatzartIBUBuchungssatz.setSatzart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SATZART));
        bmd55SatzartIBUBuchungssatz.setKonto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KONTO));
        bmd55SatzartIBUBuchungssatz.setBuchdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.BUCHDAT));
        bmd55SatzartIBUBuchungssatz.setGkto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.GKTO));
        bmd55SatzartIBUBuchungssatz.setBelegnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BELEGNR));
        bmd55SatzartIBUBuchungssatz.setBelegdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.BELEGDAT));
        bmd55SatzartIBUBuchungssatz.setKost(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOST));
        bmd55SatzartIBUBuchungssatz.setUnused1(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.UNUSED1));
        bmd55SatzartIBUBuchungssatz.setKotraeger(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOTRAEGER));
        bmd55SatzartIBUBuchungssatz.setKomenge(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.KOMENGE));
        bmd55SatzartIBUBuchungssatz.setKomengenr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOMENGENR));
        bmd55SatzartIBUBuchungssatz.setKovariator(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.KOVARIATOR));
        bmd55SatzartIBUBuchungssatz.setKoperiode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOPERIODE));
        bmd55SatzartIBUBuchungssatz.setKomonteiler(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOMONTEILER));
        bmd55SatzartIBUBuchungssatz.setMwst(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.MWST));
        bmd55SatzartIBUBuchungssatz.setSteucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.STEUCOD));
        bmd55SatzartIBUBuchungssatz.setEbkennz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.EBKENNZ));
        bmd55SatzartIBUBuchungssatz.setBucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCOD));
        bmd55SatzartIBUBuchungssatz.setBetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.BETRAG));
        bmd55SatzartIBUBuchungssatz.setSteuer(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.STEUER));
        bmd55SatzartIBUBuchungssatz.setSkonto(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTO));
        bmd55SatzartIBUBuchungssatz.setOpbetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.OPBETRAG));
        bmd55SatzartIBUBuchungssatz.setPeriode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.PERIODE));
        bmd55SatzartIBUBuchungssatz.setKursnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KURSNR));
        bmd55SatzartIBUBuchungssatz.setFwkurs(parseIntValue(record, Satzart0FIBUBuchungssatzFields.FWKURS));
        bmd55SatzartIBUBuchungssatz.setFwfaktor(parseIntValue(record, Satzart0FIBUBuchungssatzFields.FWFAKTOR));
        bmd55SatzartIBUBuchungssatz.setFwbetrag(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWBETRAG));
        bmd55SatzartIBUBuchungssatz.setFwsteuer(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWSTEUER));
        bmd55SatzartIBUBuchungssatz.setFwskonto(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWSKONTO));
        bmd55SatzartIBUBuchungssatz.setFwopbetr(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.FWOPBETR));
        bmd55SatzartIBUBuchungssatz.setLandkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LANDKZ));
        bmd55SatzartIBUBuchungssatz.setLkzkurs(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LKZKURS));
        bmd55SatzartIBUBuchungssatz.setLkzfaktor(parseIntValue(record, Satzart0FIBUBuchungssatzFields.LKZFAKTOR));
        bmd55SatzartIBUBuchungssatz.setText(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.TEXT));
        bmd55SatzartIBUBuchungssatz.setSymbol(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.SYMBOL));
        bmd55SatzartIBUBuchungssatz.setExtbelegnr(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.EXTBELEGNR));
        bmd55SatzartIBUBuchungssatz.setZesskz(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.ZESSKZ));
        bmd55SatzartIBUBuchungssatz.setZziel(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZZIEL));
        bmd55SatzartIBUBuchungssatz.setSkontopz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTOPZ));
        bmd55SatzartIBUBuchungssatz.setSkontotage(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SKONTOTAGE));
        bmd55SatzartIBUBuchungssatz.setSkontopz2(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.SKONTOPZ2));
        bmd55SatzartIBUBuchungssatz.setSkontotage2(parseIntValue(record, Satzart0FIBUBuchungssatzFields.SKONTOTAGE2));
        bmd55SatzartIBUBuchungssatz.setValutadatum(parseDateValue(record, Satzart0FIBUBuchungssatzFields.VALUTADATUM));
        bmd55SatzartIBUBuchungssatz.setWechseldatum(parseDateValue(record, Satzart0FIBUBuchungssatzFields.WECHSELDATUM));
        bmd55SatzartIBUBuchungssatz.setVertnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.VERTNR));
        bmd55SatzartIBUBuchungssatz.setProvpz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.PROVPZ));
        bmd55SatzartIBUBuchungssatz.setAuftkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.AUFTKZ));
        bmd55SatzartIBUBuchungssatz.setAuftnr(parseIntValue(record, Satzart0FIBUBuchungssatzFields.AUFTNR));
        bmd55SatzartIBUBuchungssatz.setZmart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZMART));
        bmd55SatzartIBUBuchungssatz.setZmbericht(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZMBERICHT));
        bmd55SatzartIBUBuchungssatz.setMenge(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.MENGE));
        bmd55SatzartIBUBuchungssatz.setBenutzer(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BENUTZER));
        bmd55SatzartIBUBuchungssatz.setBuchart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCHART));
        bmd55SatzartIBUBuchungssatz.setBuchkz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BUCHKZ));
        bmd55SatzartIBUBuchungssatz.setMahnz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.MAHNZ));
        bmd55SatzartIBUBuchungssatz.setLeistdat(parseDateValue(record, Satzart0FIBUBuchungssatzFields.LEISTDAT));
        bmd55SatzartIBUBuchungssatz.setUvaPeriode(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UVA_PERIODE));
        bmd55SatzartIBUBuchungssatz.setUidnr(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.UIDNR));
        bmd55SatzartIBUBuchungssatz.setSteuerart(parseIntValue(record, Satzart0FIBUBuchungssatzFields.STEUERART));
        bmd55SatzartIBUBuchungssatz.setKorekonto(parseIntValue(record, Satzart0FIBUBuchungssatzFields.KOREKONTO));
        bmd55SatzartIBUBuchungssatz.setErZahlbank(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ER_ZAHLBANK));
        bmd55SatzartIBUBuchungssatz.setBauSteucod(parseIntValue(record, Satzart0FIBUBuchungssatzFields.BAU_STEUCOD));
        bmd55SatzartIBUBuchungssatz.setUnused2(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UNUSED2));
        bmd55SatzartIBUBuchungssatz.setVstAbzugpz(parseDoubleValue(record, Satzart0FIBUBuchungssatzFields.VST_ABZUGPZ));
        bmd55SatzartIBUBuchungssatz.setZvMahnsp(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ZV_MAHNSP));
        bmd55SatzartIBUBuchungssatz.setErSteukorrKz(parseIntValue(record, Satzart0FIBUBuchungssatzFields.ER_STEUKORR_KZ));
        bmd55SatzartIBUBuchungssatz.setGegenbuchkz(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.GEGENBUCHKZ));
        bmd55SatzartIBUBuchungssatz.setVerbuchkz(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.VERBUCHKZ));
        bmd55SatzartIBUBuchungssatz.setUnused3(parseIntValue(record, Satzart0FIBUBuchungssatzFields.UNUSED3));
        bmd55SatzartIBUBuchungssatz.setUnused4(parseStringValueTrim(record, Satzart0FIBUBuchungssatzFields.UNUSED4));

        return bmd55SatzartIBUBuchungssatz;
    }

    private double parseDoubleValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        int intVal = parseIntValue(record, satzart0FIBUBuchungssatzFields);
        return ((double)intVal) / 100.0;
    }

    private LocalDate parseDateValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        String str = parseStringValueTrim(record, satzart0FIBUBuchungssatzFields);
        try {
            return LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private int parseIntValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields)  {
        String strValue = parseStringValueTrim(record, satzart0FIBUBuchungssatzFields);

        boolean negativ = false;
        
        if (StringUtils.endsWithAny(strValue, "-", "+")) {
            negativ = StringUtils.equals(StringUtils.substring(strValue, -1), "-");
            strValue = StringUtils.chop(strValue);
        }

        if (!NumberUtils.isParsable(strValue)) {
            return 0;
        }
        
        int intValue = Integer.parseInt(strValue);
        if (negativ) {
            intValue *= -1;
        }
        return intValue;
    }

    private String parseStringValueTrim(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        return StringUtils.trim(parseStringValue(record, satzart0FIBUBuchungssatzFields));
    }

    private String parseStringValue(String record, Satzart0FIBUBuchungssatzFields satzart0FIBUBuchungssatzFields) {
        return StringUtils.substring(record, satzart0FIBUBuchungssatzFields.getStartPosBmd55() - 1, satzart0FIBUBuchungssatzFields.getEndPosBmd55());
    }
}
