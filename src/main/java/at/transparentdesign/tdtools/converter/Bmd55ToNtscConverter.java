package at.transparentdesign.tdtools.converter;

import at.transparentdesign.tdtools.satz.Bmd55FiBuRecord;
import at.transparentdesign.tdtools.satz.NtscFiBuRecord;

import java.util.ArrayList;
import java.util.List;

public class Bmd55ToNtscConverter {
    public NtscFiBuRecord convert(Bmd55FiBuRecord bmd55FiBuRecord) {
        NtscFiBuRecord ntscFiBuRecord = new NtscFiBuRecord();

        ntscFiBuRecord.setSatzart(bmd55FiBuRecord.getSatzart());
        ntscFiBuRecord.setKonto(bmd55FiBuRecord.getKonto());
        ntscFiBuRecord.setBuchdatum(bmd55FiBuRecord.getBuchdat());
        ntscFiBuRecord.setGkonto(bmd55FiBuRecord.getGkto());
        ntscFiBuRecord.setBelegnr(bmd55FiBuRecord.getBelegnr());
        ntscFiBuRecord.setBelegdatum(bmd55FiBuRecord.getBelegdat());
        ntscFiBuRecord.setKost(bmd55FiBuRecord.getKost());
        ntscFiBuRecord.setKotraeger(bmd55FiBuRecord.getKotraeger());
        ntscFiBuRecord.setKomenge(bmd55FiBuRecord.getKomenge());
        ntscFiBuRecord.setKomengenr(bmd55FiBuRecord.getKomengenr());
        ntscFiBuRecord.setKovariator(bmd55FiBuRecord.getKovariator());
        ntscFiBuRecord.setKoperiode(bmd55FiBuRecord.getKoperiode());
        ntscFiBuRecord.setKomonteiler(bmd55FiBuRecord.getKomonteiler());
        ntscFiBuRecord.setProzent(bmd55FiBuRecord.getMwst());
        ntscFiBuRecord.setSteuercode(bmd55FiBuRecord.getSteucod());

        if (ntscFiBuRecord.getSteuercode() == 0) {
            ntscFiBuRecord.setSteuercode(2);
        }

        ntscFiBuRecord.setEbkennz(bmd55FiBuRecord.getEbkennz());
        ntscFiBuRecord.setBuchcode(bmd55FiBuRecord.getBucod());
        ntscFiBuRecord.setBetrag(bmd55FiBuRecord.getBetrag());
        ntscFiBuRecord.setSteuer(bmd55FiBuRecord.getSteuer());
        ntscFiBuRecord.setSkonto(bmd55FiBuRecord.getSkonto());
        ntscFiBuRecord.setOpbetrag(bmd55FiBuRecord.getOpbetrag());
        ntscFiBuRecord.setPeriode(bmd55FiBuRecord.getPeriode());
        ntscFiBuRecord.setKursnr(bmd55FiBuRecord.getKursnr());
        ntscFiBuRecord.setFwkurs(bmd55FiBuRecord.getFwkurs());
        ntscFiBuRecord.setFwfaktor(bmd55FiBuRecord.getFwfaktor());
        ntscFiBuRecord.setFwbetrag(bmd55FiBuRecord.getFwbetrag());
        ntscFiBuRecord.setFwsteuer(bmd55FiBuRecord.getFwsteuer());
        ntscFiBuRecord.setFwskonto(bmd55FiBuRecord.getFwskonto());
        ntscFiBuRecord.setFwopbetr(bmd55FiBuRecord.getFwopbetr());
        ntscFiBuRecord.setLandkz(bmd55FiBuRecord.getLandkz());
        ntscFiBuRecord.setLkzkurs(bmd55FiBuRecord.getLkzkurs());
        ntscFiBuRecord.setLkzfaktor(bmd55FiBuRecord.getLkzfaktor());
        ntscFiBuRecord.setText(bmd55FiBuRecord.getText());
        ntscFiBuRecord.setBuchsymbol(bmd55FiBuRecord.getSymbol());
        ntscFiBuRecord.setExtbelegnr(bmd55FiBuRecord.getExtbelegnr());
        ntscFiBuRecord.setZesskz(bmd55FiBuRecord.getZesskz());
        ntscFiBuRecord.setZziel(bmd55FiBuRecord.getZziel());
        ntscFiBuRecord.setSkontopz(bmd55FiBuRecord.getSkontopz());
        ntscFiBuRecord.setSkontotage(bmd55FiBuRecord.getSkontotage());
        ntscFiBuRecord.setSkontopz2(bmd55FiBuRecord.getSkontopz2());
        ntscFiBuRecord.setSkontotage2(bmd55FiBuRecord.getSkontotage2());
        ntscFiBuRecord.setValutadatum(bmd55FiBuRecord.getValutadatum());
        ntscFiBuRecord.setWechseldatum(bmd55FiBuRecord.getWechseldatum());
        ntscFiBuRecord.setVertnr(bmd55FiBuRecord.getVertnr());
        ntscFiBuRecord.setProvpz(bmd55FiBuRecord.getProvpz());
        ntscFiBuRecord.setAuftkz(bmd55FiBuRecord.getAuftkz());
        ntscFiBuRecord.setAuftnr(bmd55FiBuRecord.getAuftnr());
        ntscFiBuRecord.setZmart(bmd55FiBuRecord.getZmart());
        ntscFiBuRecord.setZmbericht(bmd55FiBuRecord.getZmbericht());
        ntscFiBuRecord.setMenge(bmd55FiBuRecord.getMenge());
        ntscFiBuRecord.setBenutzer(bmd55FiBuRecord.getBenutzer());
        ntscFiBuRecord.setBuchart(bmd55FiBuRecord.getBuchart());
        ntscFiBuRecord.setBuchkz(bmd55FiBuRecord.getBuchkz());
        ntscFiBuRecord.setMahnz(bmd55FiBuRecord.getMahnz());
        ntscFiBuRecord.setLeistdat(bmd55FiBuRecord.getLeistdat());
        ntscFiBuRecord.setUvaPeriode(bmd55FiBuRecord.getUvaPeriode());
        ntscFiBuRecord.setUidnr(bmd55FiBuRecord.getUidnr());
        ntscFiBuRecord.setSteuerart(bmd55FiBuRecord.getSteuerart());
        ntscFiBuRecord.setKorekonto(bmd55FiBuRecord.getKorekonto());
        ntscFiBuRecord.setErZahlbank(bmd55FiBuRecord.getErZahlbank());
        ntscFiBuRecord.setBauSteucod(bmd55FiBuRecord.getBauSteucod());
        ntscFiBuRecord.setVstAbzugpz(bmd55FiBuRecord.getVstAbzugpz());
        ntscFiBuRecord.setZvMahnsp(bmd55FiBuRecord.getZvMahnsp());
        ntscFiBuRecord.setErSteukorrKz(bmd55FiBuRecord.getErSteukorrKz());
        ntscFiBuRecord.setGegenbuchkz(bmd55FiBuRecord.getGegenbuchkz());
        ntscFiBuRecord.setVerbuchkz(bmd55FiBuRecord.getVerbuchkz());

        return ntscFiBuRecord;
    }

    public List<NtscFiBuRecord> convert(List<Bmd55FiBuRecord> records) {
        List<NtscFiBuRecord> result = new ArrayList<NtscFiBuRecord>();

        for (Bmd55FiBuRecord record : records) {
            result.add(convert(record));
        }

        return result;
    }
}
