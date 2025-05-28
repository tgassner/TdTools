package at.transparentdesign.tdtools.parser;

import at.transparentdesign.tdtools.satz.Bmd55FiBuRecord;
import at.transparentdesign.tdtools.satz.FiBuRecordFields;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Satzart0FiBuBuchungssatzParser {
    public Bmd55FiBuRecord parse(String record) {
        Bmd55FiBuRecord bmd55FiBuRecord = new Bmd55FiBuRecord();

        bmd55FiBuRecord.setSatzart(parseIntValue(record, FiBuRecordFields.SATZART));
        bmd55FiBuRecord.setKonto(parseIntValue(record, FiBuRecordFields.KONTO));
        bmd55FiBuRecord.setBuchdat(parseDateValue(record, FiBuRecordFields.BUCHDAT));
        bmd55FiBuRecord.setGkto(parseIntValue(record, FiBuRecordFields.GKTO));
        bmd55FiBuRecord.setBelegnr(parseIntValue(record, FiBuRecordFields.BELEGNR));
        bmd55FiBuRecord.setBelegdat(parseDateValue(record, FiBuRecordFields.BELEGDAT));
        bmd55FiBuRecord.setKost(parseIntValue(record, FiBuRecordFields.KOST));
        bmd55FiBuRecord.setUnused1(parseStringValueTrim(record, FiBuRecordFields.UNUSED1));
        bmd55FiBuRecord.setKotraeger(parseIntValue(record, FiBuRecordFields.KOTRAEGER));
        bmd55FiBuRecord.setKomenge(parseDoubleValue(record, FiBuRecordFields.KOMENGE));
        bmd55FiBuRecord.setKomengenr(parseIntValue(record, FiBuRecordFields.KOMENGENR));
        bmd55FiBuRecord.setKovariator(parseDoubleValue(record, FiBuRecordFields.KOVARIATOR));
        bmd55FiBuRecord.setKoperiode(parseIntValue(record, FiBuRecordFields.KOPERIODE));
        bmd55FiBuRecord.setKomonteiler(parseIntValue(record, FiBuRecordFields.KOMONTEILER));
        bmd55FiBuRecord.setMwst(parseDoubleValue(record, FiBuRecordFields.MWST));
        bmd55FiBuRecord.setSteucod(parseIntValue(record, FiBuRecordFields.STEUCOD));
        bmd55FiBuRecord.setEbkennz(parseIntValue(record, FiBuRecordFields.EBKENNZ));
        bmd55FiBuRecord.setBucod(parseIntValue(record, FiBuRecordFields.BUCOD));
        bmd55FiBuRecord.setBetrag(parseDoubleValue(record, FiBuRecordFields.BETRAG));
        bmd55FiBuRecord.setSteuer(parseDoubleValue(record, FiBuRecordFields.STEUER));
        bmd55FiBuRecord.setSkonto(parseDoubleValue(record, FiBuRecordFields.SKONTO));
        bmd55FiBuRecord.setOpbetrag(parseDoubleValue(record, FiBuRecordFields.OPBETRAG));
        bmd55FiBuRecord.setPeriode(parseIntValue(record, FiBuRecordFields.PERIODE));
        bmd55FiBuRecord.setKursnr(parseIntValue(record, FiBuRecordFields.KURSNR));
        bmd55FiBuRecord.setFwkurs(parseIntValue(record, FiBuRecordFields.FWKURS));
        bmd55FiBuRecord.setFwfaktor(parseIntValue(record, FiBuRecordFields.FWFAKTOR));
        bmd55FiBuRecord.setFwbetrag(parseDoubleValue(record, FiBuRecordFields.FWBETRAG));
        bmd55FiBuRecord.setFwsteuer(parseDoubleValue(record, FiBuRecordFields.FWSTEUER));
        bmd55FiBuRecord.setFwskonto(parseDoubleValue(record, FiBuRecordFields.FWSKONTO));
        bmd55FiBuRecord.setFwopbetr(parseDoubleValue(record, FiBuRecordFields.FWOPBETR));
        bmd55FiBuRecord.setLandkz(parseIntValue(record, FiBuRecordFields.LANDKZ));
        bmd55FiBuRecord.setLkzkurs(parseIntValue(record, FiBuRecordFields.LKZKURS));
        bmd55FiBuRecord.setLkzfaktor(parseIntValue(record, FiBuRecordFields.LKZFAKTOR));
        bmd55FiBuRecord.setText(parseStringValueTrim(record, FiBuRecordFields.TEXT));
        bmd55FiBuRecord.setSymbol(parseStringValueTrim(record, FiBuRecordFields.SYMBOL));
        bmd55FiBuRecord.setExtbelegnr(parseStringValueTrim(record, FiBuRecordFields.EXTBELEGNR));
        bmd55FiBuRecord.setZesskz(parseStringValueTrim(record, FiBuRecordFields.ZESSKZ));
        bmd55FiBuRecord.setZziel(parseIntValue(record, FiBuRecordFields.ZZIEL));
        bmd55FiBuRecord.setSkontopz(parseDoubleValue(record, FiBuRecordFields.SKONTOPZ));
        bmd55FiBuRecord.setSkontotage(parseIntValue(record, FiBuRecordFields.SKONTOTAGE));
        bmd55FiBuRecord.setSkontopz2(parseDoubleValue(record, FiBuRecordFields.SKONTOPZ2));
        bmd55FiBuRecord.setSkontotage2(parseIntValue(record, FiBuRecordFields.SKONTOTAGE2));
        bmd55FiBuRecord.setValutadatum(parseDateValue(record, FiBuRecordFields.VALUTADATUM));
        bmd55FiBuRecord.setWechseldatum(parseDateValue(record, FiBuRecordFields.WECHSELDATUM));
        bmd55FiBuRecord.setVertnr(parseIntValue(record, FiBuRecordFields.VERTNR));
        bmd55FiBuRecord.setProvpz(parseDoubleValue(record, FiBuRecordFields.PROVPZ));
        bmd55FiBuRecord.setAuftkz(parseIntValue(record, FiBuRecordFields.AUFTKZ));
        bmd55FiBuRecord.setAuftnr(parseIntValue(record, FiBuRecordFields.AUFTNR));
        bmd55FiBuRecord.setZmart(parseIntValue(record, FiBuRecordFields.ZMART));
        bmd55FiBuRecord.setZmbericht(parseIntValue(record, FiBuRecordFields.ZMBERICHT));
        bmd55FiBuRecord.setMenge(parseDoubleValue(record, FiBuRecordFields.MENGE));
        bmd55FiBuRecord.setBenutzer(parseIntValue(record, FiBuRecordFields.BENUTZER));
        bmd55FiBuRecord.setBuchart(parseIntValue(record, FiBuRecordFields.BUCHART));
        bmd55FiBuRecord.setBuchkz(parseIntValue(record, FiBuRecordFields.BUCHKZ));
        bmd55FiBuRecord.setMahnz(parseIntValue(record, FiBuRecordFields.MAHNZ));
        bmd55FiBuRecord.setLeistdat(parseDateValue(record, FiBuRecordFields.LEISTDAT));
        bmd55FiBuRecord.setUvaPeriode(parseIntValue(record, FiBuRecordFields.UVA_PERIODE));
        bmd55FiBuRecord.setUidnr(parseStringValueTrim(record, FiBuRecordFields.UIDNR));
        bmd55FiBuRecord.setSteuerart(parseIntValue(record, FiBuRecordFields.STEUERART));
        bmd55FiBuRecord.setKorekonto(parseIntValue(record, FiBuRecordFields.KOREKONTO));
        bmd55FiBuRecord.setErZahlbank(parseIntValue(record, FiBuRecordFields.ER_ZAHLBANK));
        bmd55FiBuRecord.setBauSteucod(parseIntValue(record, FiBuRecordFields.BAU_STEUCOD));
        bmd55FiBuRecord.setUnused2(parseIntValue(record, FiBuRecordFields.UNUSED2));
        bmd55FiBuRecord.setVstAbzugpz(parseDoubleValue(record, FiBuRecordFields.VST_ABZUGPZ));
        bmd55FiBuRecord.setZvMahnsp(parseIntValue(record, FiBuRecordFields.ZV_MAHNSP));
        bmd55FiBuRecord.setErSteukorrKz(parseIntValue(record, FiBuRecordFields.ER_STEUKORR_KZ));
        bmd55FiBuRecord.setGegenbuchkz(parseStringValueTrim(record, FiBuRecordFields.GEGENBUCHKZ));
        bmd55FiBuRecord.setVerbuchkz(parseStringValueTrim(record, FiBuRecordFields.VERBUCHKZ));
        bmd55FiBuRecord.setUnused3(parseIntValue(record, FiBuRecordFields.UNUSED3));
        bmd55FiBuRecord.setUnused4(parseStringValueTrim(record, FiBuRecordFields.UNUSED4));

        return bmd55FiBuRecord;
    }

    private double parseDoubleValue(String record, FiBuRecordFields fiBuRecordFields) {
        int intVal = parseIntValue(record, fiBuRecordFields);
        return ((double)intVal) / 100.0;
    }

    private LocalDate parseDateValue(String record, FiBuRecordFields fiBuRecordFields) {
        String str = parseStringValueTrim(record, fiBuRecordFields);
        try {
            return LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private int parseIntValue(String record, FiBuRecordFields fiBuRecordFields)  {
        String strValue = parseStringValueTrim(record, fiBuRecordFields);

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

    private String parseStringValueTrim(String record, FiBuRecordFields fiBuRecordFields) {
        return StringUtils.trim(parseStringValue(record, fiBuRecordFields));
    }

    private String parseStringValue(String record, FiBuRecordFields fiBuRecordFields) {
        return StringUtils.substring(record, fiBuRecordFields.getStartPosBmd55() - 1, fiBuRecordFields.getEndPosBmd55());
    }
}
