package at.transparentdesign.tdtools.satz;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NtscSatzartIBUBuchungssatz {

    private int satzart;
    private int konto;
    private LocalDate buchdatum;
    private int gkonto;
    private int belegnr;
    private LocalDate belegdatum;
    private int kost;
    private String unused1;
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
    private int unused2;
    private double vstAbzugpz;
    private int zvMahnsp;
    private int erSteukorrKz;
    private String gegenbuchkz;
    private String verbuchkz;
    private int unused3;
    private String unused4;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

    public int getSatzart() {
        return satzart;
    }

    public NtscSatzartIBUBuchungssatz setSatzart(int satzart) {
        this.satzart = satzart;
        return this;
    }

    public int getKonto() {
        return konto;
    }

    public NtscSatzartIBUBuchungssatz setKonto(int konto) {
        this.konto = konto;
        return this;
    }

    public LocalDate getBuchdatum() {
        return buchdatum;
    }

    public NtscSatzartIBUBuchungssatz setBuchdatum(LocalDate buchdatum) {
        this.buchdatum = buchdatum;
        return this;
    }

    public int getGkonto() {
        return gkonto;
    }

    public NtscSatzartIBUBuchungssatz setGkonto(int gkonto) {
        this.gkonto = gkonto;
        return this;
    }

    public int getBelegnr() {
        return belegnr;
    }

    public NtscSatzartIBUBuchungssatz setBelegnr(int belegnr) {
        this.belegnr = belegnr;
        return this;
    }

    public LocalDate getBelegdatum() {
        return belegdatum;
    }

    public NtscSatzartIBUBuchungssatz setBelegdatum(LocalDate belegdatum) {
        this.belegdatum = belegdatum;
        return this;
    }

    public int getKost() {
        return kost;
    }

    public NtscSatzartIBUBuchungssatz setKost(int kost) {
        this.kost = kost;
        return this;
    }

    public String getUnused1() {
        return unused1;
    }

    public NtscSatzartIBUBuchungssatz setUnused1(String unused1) {
        this.unused1 = unused1;
        return this;
    }

    public int getKotraeger() {
        return kotraeger;
    }

    public NtscSatzartIBUBuchungssatz setKotraeger(int kotraeger) {
        this.kotraeger = kotraeger;
        return this;
    }

    public double getKomenge() {
        return komenge;
    }

    public NtscSatzartIBUBuchungssatz setKomenge(double komenge) {
        this.komenge = komenge;
        return this;
    }

    public int getKomengenr() {
        return komengenr;
    }

    public NtscSatzartIBUBuchungssatz setKomengenr(int komengenr) {
        this.komengenr = komengenr;
        return this;
    }

    public double getKovariator() {
        return kovariator;
    }

    public NtscSatzartIBUBuchungssatz setKovariator(double kovariator) {
        this.kovariator = kovariator;
        return this;
    }

    public int getKoperiode() {
        return koperiode;
    }

    public NtscSatzartIBUBuchungssatz setKoperiode(int koperiode) {
        this.koperiode = koperiode;
        return this;
    }

    public int getKomonteiler() {
        return komonteiler;
    }

    public NtscSatzartIBUBuchungssatz setKomonteiler(int komonteiler) {
        this.komonteiler = komonteiler;
        return this;
    }

    public double getProzent() {
        return prozent;
    }

    public NtscSatzartIBUBuchungssatz setProzent(double prozent) {
        this.prozent = prozent;
        return this;
    }

    public int getSteuercode() {
        return steuercode;
    }

    public NtscSatzartIBUBuchungssatz setSteuercode(int steuercode) {
        this.steuercode = steuercode;
        return this;
    }

    public int getEbkennz() {
        return ebkennz;
    }

    public NtscSatzartIBUBuchungssatz setEbkennz(int ebkennz) {
        this.ebkennz = ebkennz;
        return this;
    }

    public int getBuchcode() {
        return buchcode;
    }

    public NtscSatzartIBUBuchungssatz setBuchcode(int buchcode) {
        this.buchcode = buchcode;
        return this;
    }

    public double getBetrag() {
        return betrag;
    }

    public NtscSatzartIBUBuchungssatz setBetrag(double betrag) {
        this.betrag = betrag;
        return this;
    }

    public double getSteuer() {
        return steuer;
    }

    public NtscSatzartIBUBuchungssatz setSteuer(double steuer) {
        this.steuer = steuer;
        return this;
    }

    public double getSkonto() {
        return skonto;
    }

    public NtscSatzartIBUBuchungssatz setSkonto(double skonto) {
        this.skonto = skonto;
        return this;
    }

    public double getOpbetrag() {
        return opbetrag;
    }

    public NtscSatzartIBUBuchungssatz setOpbetrag(double opbetrag) {
        this.opbetrag = opbetrag;
        return this;
    }

    public int getPeriode() {
        return periode;
    }

    public NtscSatzartIBUBuchungssatz setPeriode(int periode) {
        this.periode = periode;
        return this;
    }

    public int getKursnr() {
        return kursnr;
    }

    public NtscSatzartIBUBuchungssatz setKursnr(int kursnr) {
        this.kursnr = kursnr;
        return this;
    }

    public int getFwkurs() {
        return fwkurs;
    }

    public NtscSatzartIBUBuchungssatz setFwkurs(int fwkurs) {
        this.fwkurs = fwkurs;
        return this;
    }

    public int getFwfaktor() {
        return fwfaktor;
    }

    public NtscSatzartIBUBuchungssatz setFwfaktor(int fwfaktor) {
        this.fwfaktor = fwfaktor;
        return this;
    }

    public double getFwbetrag() {
        return fwbetrag;
    }

    public NtscSatzartIBUBuchungssatz setFwbetrag(double fwbetrag) {
        this.fwbetrag = fwbetrag;
        return this;
    }

    public double getFwsteuer() {
        return fwsteuer;
    }

    public NtscSatzartIBUBuchungssatz setFwsteuer(double fwsteuer) {
        this.fwsteuer = fwsteuer;
        return this;
    }

    public double getFwskonto() {
        return fwskonto;
    }

    public NtscSatzartIBUBuchungssatz setFwskonto(double fwskonto) {
        this.fwskonto = fwskonto;
        return this;
    }

    public double getFwopbetr() {
        return fwopbetr;
    }

    public NtscSatzartIBUBuchungssatz setFwopbetr(double fwopbetr) {
        this.fwopbetr = fwopbetr;
        return this;
    }

    public int getLandkz() {
        return landkz;
    }

    public NtscSatzartIBUBuchungssatz setLandkz(int landkz) {
        this.landkz = landkz;
        return this;
    }

    public int getLkzkurs() {
        return lkzkurs;
    }

    public NtscSatzartIBUBuchungssatz setLkzkurs(int lkzkurs) {
        this.lkzkurs = lkzkurs;
        return this;
    }

    public int getLkzfaktor() {
        return lkzfaktor;
    }

    public NtscSatzartIBUBuchungssatz setLkzfaktor(int lkzfaktor) {
        this.lkzfaktor = lkzfaktor;
        return this;
    }

    public String getText() {
        return text;
    }

    public NtscSatzartIBUBuchungssatz setText(String text) {
        this.text = text;
        return this;
    }

    public String getBuchsymbol() {
        return buchsymbol;
    }

    public NtscSatzartIBUBuchungssatz setBuchsymbol(String buchsymbol) {
        this.buchsymbol = buchsymbol;
        return this;
    }

    public String getExtbelegnr() {
        return extbelegnr;
    }

    public NtscSatzartIBUBuchungssatz setExtbelegnr(String extbelegnr) {
        this.extbelegnr = extbelegnr;
        return this;
    }

    public String getZesskz() {
        return zesskz;
    }

    public NtscSatzartIBUBuchungssatz setZesskz(String zesskz) {
        this.zesskz = zesskz;
        return this;
    }

    public int getZziel() {
        return zziel;
    }

    public NtscSatzartIBUBuchungssatz setZziel(int zziel) {
        this.zziel = zziel;
        return this;
    }

    public double getSkontopz() {
        return skontopz;
    }

    public NtscSatzartIBUBuchungssatz setSkontopz(double skontopz) {
        this.skontopz = skontopz;
        return this;
    }

    public int getSkontotage() {
        return skontotage;
    }

    public NtscSatzartIBUBuchungssatz setSkontotage(int skontotage) {
        this.skontotage = skontotage;
        return this;
    }

    public double getSkontopz2() {
        return skontopz2;
    }

    public NtscSatzartIBUBuchungssatz setSkontopz2(double skontopz2) {
        this.skontopz2 = skontopz2;
        return this;
    }

    public int getSkontotage2() {
        return skontotage2;
    }

    public NtscSatzartIBUBuchungssatz setSkontotage2(int skontotage2) {
        this.skontotage2 = skontotage2;
        return this;
    }

    public LocalDate getValutadatum() {
        return valutadatum;
    }

    public NtscSatzartIBUBuchungssatz setValutadatum(LocalDate valutadatum) {
        this.valutadatum = valutadatum;
        return this;
    }

    public LocalDate getWechseldatum() {
        return wechseldatum;
    }

    public NtscSatzartIBUBuchungssatz setWechseldatum(LocalDate wechseldatum) {
        this.wechseldatum = wechseldatum;
        return this;
    }

    public int getVertnr() {
        return vertnr;
    }

    public NtscSatzartIBUBuchungssatz setVertnr(int vertnr) {
        this.vertnr = vertnr;
        return this;
    }

    public double getProvpz() {
        return provpz;
    }

    public NtscSatzartIBUBuchungssatz setProvpz(double provpz) {
        this.provpz = provpz;
        return this;
    }

    public int getAuftkz() {
        return auftkz;
    }

    public NtscSatzartIBUBuchungssatz setAuftkz(int auftkz) {
        this.auftkz = auftkz;
        return this;
    }

    public int getAuftnr() {
        return auftnr;
    }

    public NtscSatzartIBUBuchungssatz setAuftnr(int auftnr) {
        this.auftnr = auftnr;
        return this;
    }

    public int getZmart() {
        return zmart;
    }

    public NtscSatzartIBUBuchungssatz setZmart(int zmart) {
        this.zmart = zmart;
        return this;
    }

    public int getZmbericht() {
        return zmbericht;
    }

    public NtscSatzartIBUBuchungssatz setZmbericht(int zmbericht) {
        this.zmbericht = zmbericht;
        return this;
    }

    public double getMenge() {
        return menge;
    }

    public NtscSatzartIBUBuchungssatz setMenge(double menge) {
        this.menge = menge;
        return this;
    }

    public int getBenutzer() {
        return benutzer;
    }

    public NtscSatzartIBUBuchungssatz setBenutzer(int benutzer) {
        this.benutzer = benutzer;
        return this;
    }

    public int getBuchart() {
        return buchart;
    }

    public NtscSatzartIBUBuchungssatz setBuchart(int buchart) {
        this.buchart = buchart;
        return this;
    }

    public int getBuchkz() {
        return buchkz;
    }

    public NtscSatzartIBUBuchungssatz setBuchkz(int buchkz) {
        this.buchkz = buchkz;
        return this;
    }

    public int getMahnz() {
        return mahnz;
    }

    public NtscSatzartIBUBuchungssatz setMahnz(int mahnz) {
        this.mahnz = mahnz;
        return this;
    }

    public LocalDate getLeistdat() {
        return leistdat;
    }

    public NtscSatzartIBUBuchungssatz setLeistdat(LocalDate leistdat) {
        this.leistdat = leistdat;
        return this;
    }

    public int getUvaPeriode() {
        return uvaPeriode;
    }

    public NtscSatzartIBUBuchungssatz setUvaPeriode(int uvaPeriode) {
        this.uvaPeriode = uvaPeriode;
        return this;
    }

    public String getUidnr() {
        return uidnr;
    }

    public NtscSatzartIBUBuchungssatz setUidnr(String uidnr) {
        this.uidnr = uidnr;
        return this;
    }

    public int getSteuerart() {
        return steuerart;
    }

    public NtscSatzartIBUBuchungssatz setSteuerart(int steuerart) {
        this.steuerart = steuerart;
        return this;
    }

    public int getKorekonto() {
        return korekonto;
    }

    public NtscSatzartIBUBuchungssatz setKorekonto(int korekonto) {
        this.korekonto = korekonto;
        return this;
    }

    public int getErZahlbank() {
        return erZahlbank;
    }

    public NtscSatzartIBUBuchungssatz setErZahlbank(int erZahlbank) {
        this.erZahlbank = erZahlbank;
        return this;
    }

    public int getBauSteucod() {
        return bauSteucod;
    }

    public NtscSatzartIBUBuchungssatz setBauSteucod(int bauSteucod) {
        this.bauSteucod = bauSteucod;
        return this;
    }

    public int getUnused2() {
        return unused2;
    }

    public NtscSatzartIBUBuchungssatz setUnused2(int unused2) {
        this.unused2 = unused2;
        return this;
    }

    public double getVstAbzugpz() {
        return vstAbzugpz;
    }

    public NtscSatzartIBUBuchungssatz setVstAbzugpz(double vstAbzugpz) {
        this.vstAbzugpz = vstAbzugpz;
        return this;
    }

    public int getZvMahnsp() {
        return zvMahnsp;
    }

    public NtscSatzartIBUBuchungssatz setZvMahnsp(int zvMahnsp) {
        this.zvMahnsp = zvMahnsp;
        return this;
    }

    public int getErSteukorrKz() {
        return erSteukorrKz;
    }

    public NtscSatzartIBUBuchungssatz setErSteukorrKz(int erSteukorrKz) {
        this.erSteukorrKz = erSteukorrKz;
        return this;
    }

    public String getGegenbuchkz() {
        return gegenbuchkz;
    }

    public NtscSatzartIBUBuchungssatz setGegenbuchkz(String gegenbuchkz) {
        this.gegenbuchkz = gegenbuchkz;
        return this;
    }

    public String getVerbuchkz() {
        return verbuchkz;
    }

    public NtscSatzartIBUBuchungssatz setVerbuchkz(String verbuchkz) {
        this.verbuchkz = verbuchkz;
        return this;
    }

    public int getUnused3() {
        return unused3;
    }

    public NtscSatzartIBUBuchungssatz setUnused3(int unused3) {
        this.unused3 = unused3;
        return this;
    }

    public String getUnused4() {
        return unused4;
    }

    public NtscSatzartIBUBuchungssatz setUnused4(String unused4) {
        this.unused4 = unused4;
        return this;
    }

    public String getBuchdatFormated() {
        LocalDate lDate = getBuchdatum();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    ;

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
                ", unused1='" + unused1 + '\'' +
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
                ", unused2=" + unused2 +
                ", vstAbzugpz=" + vstAbzugpz +
                ", zvMahnsp=" + zvMahnsp +
                ", erSteukorrKz=" + erSteukorrKz +
                ", gegenbuchkz='" + gegenbuchkz + '\'' +
                ", verbuchkz='" + verbuchkz + '\'' +
                ", unused3=" + unused3 +
                ", unused4='" + unused4 + '\'' +
                '}';
    }
}