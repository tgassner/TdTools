package at.transparentdesign.tdtools.satz;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NtscFiBuRecord {

    private int satzart;
    private int konto;
    private LocalDate buchdatum;
    private int gkonto;
    private int belegnr;
    private LocalDate belegdatum;
    private int kost;
    private int kotraeger;
    private double komenge;
    private int komengenr;
    private double kovariator;
    private int koperiode;
    private int komonteiler;
    private double prozent;
    private int steuercode;
    private int ebkennz;
    private int buchcode;
    private double betrag;
    private double steuer;
    private double skonto;
    private double opbetrag;
    private int periode;
    private int kursnr;
    private int fwkurs;
    private int fwfaktor;
    private double fwbetrag;
    private double fwsteuer;
    private double fwskonto;
    private double fwopbetr;
    private int landkz;
    private int lkzkurs;
    private int lkzfaktor;
    private String text;
    private String buchsymbol;
    private String extbelegnr;
    private String zesskz;
    private int zziel;
    private double skontopz;
    private int skontotage;
    private double skontopz2;
    private int skontotage2;
    private LocalDate valutadatum;
    private LocalDate wechseldatum;
    private int vertnr;
    private double provpz;
    private int auftkz;
    private int auftnr;
    private int zmart;
    private int zmbericht;
    private double menge;
    private int benutzer;
    private int buchart;
    private int buchkz;
    private int mahnz;
    private LocalDate leistdat;
    private int uvaPeriode;
    private String uidnr;
    private int steuerart;
    private int korekonto;
    private int erZahlbank;
    private int bauSteucod;
    private double vstAbzugpz;
    private int zvMahnsp;
    private int erSteukorrKz;
    private String gegenbuchkz;
    private String verbuchkz;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

    public int getSatzart() {
        return satzart;
    }

    public NtscFiBuRecord setSatzart(int satzart) {
        this.satzart = satzart;
        return this;
    }

    public int getKonto() {
        return konto;
    }

    public NtscFiBuRecord setKonto(int konto) {
        this.konto = konto;
        return this;
    }

    public LocalDate getBuchdatum() {
        return buchdatum;
    }

    public NtscFiBuRecord setBuchdatum(LocalDate buchdatum) {
        this.buchdatum = buchdatum;
        return this;
    }

    public int getGkonto() {
        return gkonto;
    }

    public NtscFiBuRecord setGkonto(int gkonto) {
        this.gkonto = gkonto;
        return this;
    }

    public int getBelegnr() {
        return belegnr;
    }

    public NtscFiBuRecord setBelegnr(int belegnr) {
        this.belegnr = belegnr;
        return this;
    }

    public LocalDate getBelegdatum() {
        return belegdatum;
    }

    public NtscFiBuRecord setBelegdatum(LocalDate belegdatum) {
        this.belegdatum = belegdatum;
        return this;
    }

    public int getKost() {
        return kost;
    }

    public NtscFiBuRecord setKost(int kost) {
        this.kost = kost;
        return this;
    }

    public int getKotraeger() {
        return kotraeger;
    }

    public NtscFiBuRecord setKotraeger(int kotraeger) {
        this.kotraeger = kotraeger;
        return this;
    }

    public double getKomenge() {
        return komenge;
    }

    public NtscFiBuRecord setKomenge(double komenge) {
        this.komenge = komenge;
        return this;
    }

    public int getKomengenr() {
        return komengenr;
    }

    public NtscFiBuRecord setKomengenr(int komengenr) {
        this.komengenr = komengenr;
        return this;
    }

    public double getKovariator() {
        return kovariator;
    }

    public NtscFiBuRecord setKovariator(double kovariator) {
        this.kovariator = kovariator;
        return this;
    }

    public int getKoperiode() {
        return koperiode;
    }

    public NtscFiBuRecord setKoperiode(int koperiode) {
        this.koperiode = koperiode;
        return this;
    }

    public int getKomonteiler() {
        return komonteiler;
    }

    public NtscFiBuRecord setKomonteiler(int komonteiler) {
        this.komonteiler = komonteiler;
        return this;
    }

    public double getProzent() {
        return prozent;
    }

    public NtscFiBuRecord setProzent(double prozent) {
        this.prozent = prozent;
        return this;
    }

    public int getSteuercode() {
        return steuercode;
    }

    public NtscFiBuRecord setSteuercode(int steuercode) {
        this.steuercode = steuercode;
        return this;
    }

    public int getEbkennz() {
        return ebkennz;
    }

    public NtscFiBuRecord setEbkennz(int ebkennz) {
        this.ebkennz = ebkennz;
        return this;
    }

    public int getBuchcode() {
        return buchcode;
    }

    public NtscFiBuRecord setBuchcode(int buchcode) {
        this.buchcode = buchcode;
        return this;
    }

    public double getBetrag() {
        return betrag;
    }

    public NtscFiBuRecord setBetrag(double betrag) {
        this.betrag = betrag;
        return this;
    }

    public double getSteuer() {
        return steuer;
    }

    public NtscFiBuRecord setSteuer(double steuer) {
        this.steuer = steuer;
        return this;
    }

    public double getSkonto() {
        return skonto;
    }

    public NtscFiBuRecord setSkonto(double skonto) {
        this.skonto = skonto;
        return this;
    }

    public double getOpbetrag() {
        return opbetrag;
    }

    public NtscFiBuRecord setOpbetrag(double opbetrag) {
        this.opbetrag = opbetrag;
        return this;
    }

    public int getPeriode() {
        return periode;
    }

    public NtscFiBuRecord setPeriode(int periode) {
        this.periode = periode;
        return this;
    }

    public int getKursnr() {
        return kursnr;
    }

    public NtscFiBuRecord setKursnr(int kursnr) {
        this.kursnr = kursnr;
        return this;
    }

    public int getFwkurs() {
        return fwkurs;
    }

    public NtscFiBuRecord setFwkurs(int fwkurs) {
        this.fwkurs = fwkurs;
        return this;
    }

    public int getFwfaktor() {
        return fwfaktor;
    }

    public NtscFiBuRecord setFwfaktor(int fwfaktor) {
        this.fwfaktor = fwfaktor;
        return this;
    }

    public double getFwbetrag() {
        return fwbetrag;
    }

    public NtscFiBuRecord setFwbetrag(double fwbetrag) {
        this.fwbetrag = fwbetrag;
        return this;
    }

    public double getFwsteuer() {
        return fwsteuer;
    }

    public NtscFiBuRecord setFwsteuer(double fwsteuer) {
        this.fwsteuer = fwsteuer;
        return this;
    }

    public double getFwskonto() {
        return fwskonto;
    }

    public NtscFiBuRecord setFwskonto(double fwskonto) {
        this.fwskonto = fwskonto;
        return this;
    }

    public double getFwopbetr() {
        return fwopbetr;
    }

    public NtscFiBuRecord setFwopbetr(double fwopbetr) {
        this.fwopbetr = fwopbetr;
        return this;
    }

    public int getLandkz() {
        return landkz;
    }

    public NtscFiBuRecord setLandkz(int landkz) {
        this.landkz = landkz;
        return this;
    }

    public int getLkzkurs() {
        return lkzkurs;
    }

    public NtscFiBuRecord setLkzkurs(int lkzkurs) {
        this.lkzkurs = lkzkurs;
        return this;
    }

    public int getLkzfaktor() {
        return lkzfaktor;
    }

    public NtscFiBuRecord setLkzfaktor(int lkzfaktor) {
        this.lkzfaktor = lkzfaktor;
        return this;
    }

    public String getText() {
        return text;
    }

    public NtscFiBuRecord setText(String text) {
        this.text = text;
        return this;
    }

    public String getBuchsymbol() {
        return buchsymbol;
    }

    public NtscFiBuRecord setBuchsymbol(String buchsymbol) {
        this.buchsymbol = buchsymbol;
        return this;
    }

    public String getExtbelegnr() {
        return extbelegnr;
    }

    public NtscFiBuRecord setExtbelegnr(String extbelegnr) {
        this.extbelegnr = extbelegnr;
        return this;
    }

    public String getZesskz() {
        return zesskz;
    }

    public NtscFiBuRecord setZesskz(String zesskz) {
        this.zesskz = zesskz;
        return this;
    }

    public int getZziel() {
        return zziel;
    }

    public NtscFiBuRecord setZziel(int zziel) {
        this.zziel = zziel;
        return this;
    }

    public double getSkontopz() {
        return skontopz;
    }

    public NtscFiBuRecord setSkontopz(double skontopz) {
        this.skontopz = skontopz;
        return this;
    }

    public int getSkontotage() {
        return skontotage;
    }

    public NtscFiBuRecord setSkontotage(int skontotage) {
        this.skontotage = skontotage;
        return this;
    }

    public double getSkontopz2() {
        return skontopz2;
    }

    public NtscFiBuRecord setSkontopz2(double skontopz2) {
        this.skontopz2 = skontopz2;
        return this;
    }

    public int getSkontotage2() {
        return skontotage2;
    }

    public NtscFiBuRecord setSkontotage2(int skontotage2) {
        this.skontotage2 = skontotage2;
        return this;
    }

    public LocalDate getValutadatum() {
        return valutadatum;
    }

    public NtscFiBuRecord setValutadatum(LocalDate valutadatum) {
        this.valutadatum = valutadatum;
        return this;
    }

    public LocalDate getWechseldatum() {
        return wechseldatum;
    }

    public NtscFiBuRecord setWechseldatum(LocalDate wechseldatum) {
        this.wechseldatum = wechseldatum;
        return this;
    }

    public int getVertnr() {
        return vertnr;
    }

    public NtscFiBuRecord setVertnr(int vertnr) {
        this.vertnr = vertnr;
        return this;
    }

    public double getProvpz() {
        return provpz;
    }

    public NtscFiBuRecord setProvpz(double provpz) {
        this.provpz = provpz;
        return this;
    }

    public int getAuftkz() {
        return auftkz;
    }

    public NtscFiBuRecord setAuftkz(int auftkz) {
        this.auftkz = auftkz;
        return this;
    }

    public int getAuftnr() {
        return auftnr;
    }

    public NtscFiBuRecord setAuftnr(int auftnr) {
        this.auftnr = auftnr;
        return this;
    }

    public int getZmart() {
        return zmart;
    }

    public NtscFiBuRecord setZmart(int zmart) {
        this.zmart = zmart;
        return this;
    }

    public int getZmbericht() {
        return zmbericht;
    }

    public NtscFiBuRecord setZmbericht(int zmbericht) {
        this.zmbericht = zmbericht;
        return this;
    }

    public double getMenge() {
        return menge;
    }

    public NtscFiBuRecord setMenge(double menge) {
        this.menge = menge;
        return this;
    }

    public int getBenutzer() {
        return benutzer;
    }

    public NtscFiBuRecord setBenutzer(int benutzer) {
        this.benutzer = benutzer;
        return this;
    }

    public int getBuchart() {
        return buchart;
    }

    public NtscFiBuRecord setBuchart(int buchart) {
        this.buchart = buchart;
        return this;
    }

    public int getBuchkz() {
        return buchkz;
    }

    public NtscFiBuRecord setBuchkz(int buchkz) {
        this.buchkz = buchkz;
        return this;
    }

    public int getMahnz() {
        return mahnz;
    }

    public NtscFiBuRecord setMahnz(int mahnz) {
        this.mahnz = mahnz;
        return this;
    }

    public LocalDate getLeistdat() {
        return leistdat;
    }

    public NtscFiBuRecord setLeistdat(LocalDate leistdat) {
        this.leistdat = leistdat;
        return this;
    }

    public int getUvaPeriode() {
        return uvaPeriode;
    }

    public NtscFiBuRecord setUvaPeriode(int uvaPeriode) {
        this.uvaPeriode = uvaPeriode;
        return this;
    }

    public String getUidnr() {
        return uidnr;
    }

    public NtscFiBuRecord setUidnr(String uidnr) {
        this.uidnr = uidnr;
        return this;
    }

    public int getSteuerart() {
        return steuerart;
    }

    public NtscFiBuRecord setSteuerart(int steuerart) {
        this.steuerart = steuerart;
        return this;
    }

    public int getKorekonto() {
        return korekonto;
    }

    public NtscFiBuRecord setKorekonto(int korekonto) {
        this.korekonto = korekonto;
        return this;
    }

    public int getErZahlbank() {
        return erZahlbank;
    }

    public NtscFiBuRecord setErZahlbank(int erZahlbank) {
        this.erZahlbank = erZahlbank;
        return this;
    }

    public int getBauSteucod() {
        return bauSteucod;
    }

    public NtscFiBuRecord setBauSteucod(int bauSteucod) {
        this.bauSteucod = bauSteucod;
        return this;
    }

    public double getVstAbzugpz() {
        return vstAbzugpz;
    }

    public NtscFiBuRecord setVstAbzugpz(double vstAbzugpz) {
        this.vstAbzugpz = vstAbzugpz;
        return this;
    }

    public int getZvMahnsp() {
        return zvMahnsp;
    }

    public NtscFiBuRecord setZvMahnsp(int zvMahnsp) {
        this.zvMahnsp = zvMahnsp;
        return this;
    }

    public int getErSteukorrKz() {
        return erSteukorrKz;
    }

    public NtscFiBuRecord setErSteukorrKz(int erSteukorrKz) {
        this.erSteukorrKz = erSteukorrKz;
        return this;
    }

    public String getGegenbuchkz() {
        return gegenbuchkz;
    }

    public NtscFiBuRecord setGegenbuchkz(String gegenbuchkz) {
        this.gegenbuchkz = gegenbuchkz;
        return this;
    }

    public String getVerbuchkz() {
        return verbuchkz;
    }

    public NtscFiBuRecord setVerbuchkz(String verbuchkz) {
        this.verbuchkz = verbuchkz;
        return this;
    }

    public String getBuchdatFormated() {
        LocalDate lDate = getBuchdatum();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    public String getBelegdatFormated() {
        LocalDate lDate = getBelegdatum();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    ;

    public String getValutadatumFormated() {
        LocalDate lDate = getValutadatum();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    ;

    public String getWechseldatumFormated() {
        LocalDate lDate = getWechseldatum();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    ;

    public String getLeistdatFormated() {
        LocalDate lDate = getLeistdat();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "Satzart0FIBUBuchungssatz{" + "satzart=" + satzart +
                ", konto=" + konto +
                ", buchdat=" + buchdatum +
                ", gkto=" + gkonto +
                ", belegnr=" + belegnr +
                ", belegdat=" + belegdatum +
                ", kost=" + kost +
                ", kotraeger=" + kotraeger +
                ", komenge=" + komenge +
                ", komengenr=" + komengenr +
                ", kovariator=" + kovariator +
                ", koperiode=" + koperiode +
                ", komonteiler=" + komonteiler +
                ", mwst=" + prozent +
                ", steucod=" + steuercode +
                ", ebkennz=" + ebkennz +
                ", bucod=" + buchcode +
                ", betrag=" + betrag +
                ", steuer=" + steuer +
                ", skonto=" + skonto +
                ", opbetrag=" + opbetrag +
                ", periode=" + periode +
                ", kursnr=" + kursnr +
                ", fwkurs=" + fwkurs +
                ", fwfaktor=" + fwfaktor +
                ", fwbetrag=" + fwbetrag +
                ", fwsteuer=" + fwsteuer +
                ", fwskonto=" + fwskonto +
                ", fwopbetr=" + fwopbetr +
                ", landkz=" + landkz +
                ", lkzkurs=" + lkzkurs +
                ", lkzfaktor=" + lkzfaktor +
                ", text='" + text + '\'' +
                ", symbol='" + buchsymbol + '\'' +
                ", extbelegnr='" + extbelegnr + '\'' +
                ", zesskz='" + zesskz + '\'' +
                ", zziel=" + zziel +
                ", skontopz=" + skontopz +
                ", skontotage=" + skontotage +
                ", skontopz2=" + skontopz2 +
                ", skontotage2=" + skontotage2 +
                ", valutadatum=" + valutadatum +
                ", wechseldatum=" + wechseldatum +
                ", vertnr=" + vertnr +
                ", provpz=" + provpz +
                ", auftkz=" + auftkz +
                ", auftnr=" + auftnr +
                ", zmart=" + zmart +
                ", zmbericht=" + zmbericht +
                ", menge=" + menge +
                ", benutzer=" + benutzer +
                ", buchart=" + buchart +
                ", buchkz=" + buchkz +
                ", mahnz=" + mahnz +
                ", leistdat=" + leistdat +
                ", uvaPeriode=" + uvaPeriode +
                ", uidnr='" + uidnr + '\'' +
                ", steuerart=" + steuerart +
                ", korekonto=" + korekonto +
                ", erZahlbank=" + erZahlbank +
                ", bauSteucod=" + bauSteucod +
                ", vstAbzugpz=" + vstAbzugpz +
                ", zvMahnsp=" + zvMahnsp +
                ", erSteukorrKz=" + erSteukorrKz +
                ", gegenbuchkz='" + gegenbuchkz + '\'' +
                ", verbuchkz='" + verbuchkz + '\'' +
                '}';
    }
}