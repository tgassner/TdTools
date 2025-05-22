package at.transparentdesign.tdtools.satz;

import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Satzart0FIBUBuchungssatz {

    private int satzart;
    private int konto;
    private LocalDate buchdat;
    private int gkto;
    private int belegnr;
    private LocalDate belegdat;
    private int kost;
    private String unused1;
    private int kotraeger;
    private double komenge;
    private int komengenr;
    private double kovariator;
    private int koperiode;
    private int komonteiler;
    private double mwst;
    private int steucod;
    private int ebkennz;
    private int bucod;
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
    private String symbol;
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

    public Satzart0FIBUBuchungssatz setSatzart(int satzart) {
        this.satzart = satzart;
        return this;
    }

    public int getKonto() {
        return konto;
    }

    public Satzart0FIBUBuchungssatz setKonto(int konto) {
        this.konto = konto;
        return this;
    }

    public LocalDate getBuchdat() {
        return buchdat;
    }

    public Satzart0FIBUBuchungssatz setBuchdat(LocalDate buchdat) {
        this.buchdat = buchdat;
        return this;
    }

    public int getGkto() {
        return gkto;
    }

    public Satzart0FIBUBuchungssatz setGkto(int gkto) {
        this.gkto = gkto;
        return this;
    }

    public int getBelegnr() {
        return belegnr;
    }

    public Satzart0FIBUBuchungssatz setBelegnr(int belegnr) {
        this.belegnr = belegnr;
        return this;
    }

    public LocalDate getBelegdat() {
        return belegdat;
    }

    public Satzart0FIBUBuchungssatz setBelegdat(LocalDate belegdat) {
        this.belegdat = belegdat;
        return this;
    }

    public int getKost() {
        return kost;
    }

    public Satzart0FIBUBuchungssatz setKost(int kost) {
        this.kost = kost;
        return this;
    }

    public String getUnused1() {
        return unused1;
    }

    public Satzart0FIBUBuchungssatz setUnused1(String unused1) {
        this.unused1 = unused1;
        return this;
    }

    public int getKotraeger() {
        return kotraeger;
    }

    public Satzart0FIBUBuchungssatz setKotraeger(int kotraeger) {
        this.kotraeger = kotraeger;
        return this;
    }

    public double getKomenge() {
        return komenge;
    }

    public Satzart0FIBUBuchungssatz setKomenge(double komenge) {
        this.komenge = komenge;
        return this;
    }

    public int getKomengenr() {
        return komengenr;
    }

    public Satzart0FIBUBuchungssatz setKomengenr(int komengenr) {
        this.komengenr = komengenr;
        return this;
    }

    public double getKovariator() {
        return kovariator;
    }

    public Satzart0FIBUBuchungssatz setKovariator(double kovariator) {
        this.kovariator = kovariator;
        return this;
    }

    public int getKoperiode() {
        return koperiode;
    }

    public Satzart0FIBUBuchungssatz setKoperiode(int koperiode) {
        this.koperiode = koperiode;
        return this;
    }

    public int getKomonteiler() {
        return komonteiler;
    }

    public Satzart0FIBUBuchungssatz setKomonteiler(int komonteiler) {
        this.komonteiler = komonteiler;
        return this;
    }

    public double getMwst() {
        return mwst;
    }

    public Satzart0FIBUBuchungssatz setMwst(double mwst) {
        this.mwst = mwst;
        return this;
    }

    public int getSteucod() {
        return steucod;
    }

    public Satzart0FIBUBuchungssatz setSteucod(int steucod) {
        this.steucod = steucod;
        return this;
    }

    public int getEbkennz() {
        return ebkennz;
    }

    public Satzart0FIBUBuchungssatz setEbkennz(int ebkennz) {
        this.ebkennz = ebkennz;
        return this;
    }

    public int getBucod() {
        return bucod;
    }

    public Satzart0FIBUBuchungssatz setBucod(int bucod) {
        this.bucod = bucod;
        return this;
    }

    public double getBetrag() {
        return betrag;
    }

    public Satzart0FIBUBuchungssatz setBetrag(double betrag) {
        this.betrag = betrag;
        return this;
    }

    public double getSteuer() {
        return steuer;
    }

    public Satzart0FIBUBuchungssatz setSteuer(double steuer) {
        this.steuer = steuer;
        return this;
    }

    public double getSkonto() {
        return skonto;
    }

    public Satzart0FIBUBuchungssatz setSkonto(double skonto) {
        this.skonto = skonto;
        return this;
    }

    public double getOpbetrag() {
        return opbetrag;
    }

    public Satzart0FIBUBuchungssatz setOpbetrag(double opbetrag) {
        this.opbetrag = opbetrag;
        return this;
    }

    public int getPeriode() {
        return periode;
    }

    public Satzart0FIBUBuchungssatz setPeriode(int periode) {
        this.periode = periode;
        return this;
    }

    public int getKursnr() {
        return kursnr;
    }

    public Satzart0FIBUBuchungssatz setKursnr(int kursnr) {
        this.kursnr = kursnr;
        return this;
    }

    public int getFwkurs() {
        return fwkurs;
    }

    public Satzart0FIBUBuchungssatz setFwkurs(int fwkurs) {
        this.fwkurs = fwkurs;
        return this;
    }

    public int getFwfaktor() {
        return fwfaktor;
    }

    public Satzart0FIBUBuchungssatz setFwfaktor(int fwfaktor) {
        this.fwfaktor = fwfaktor;
        return this;
    }

    public double getFwbetrag() {
        return fwbetrag;
    }

    public Satzart0FIBUBuchungssatz setFwbetrag(double fwbetrag) {
        this.fwbetrag = fwbetrag;
        return this;
    }

    public double getFwsteuer() {
        return fwsteuer;
    }

    public Satzart0FIBUBuchungssatz setFwsteuer(double fwsteuer) {
        this.fwsteuer = fwsteuer;
        return this;
    }

    public double getFwskonto() {
        return fwskonto;
    }

    public Satzart0FIBUBuchungssatz setFwskonto(double fwskonto) {
        this.fwskonto = fwskonto;
        return this;
    }

    public double getFwopbetr() {
        return fwopbetr;
    }

    public Satzart0FIBUBuchungssatz setFwopbetr(double fwopbetr) {
        this.fwopbetr = fwopbetr;
        return this;
    }

    public int getLandkz() {
        return landkz;
    }

    public Satzart0FIBUBuchungssatz setLandkz(int landkz) {
        this.landkz = landkz;
        return this;
    }

    public int getLkzkurs() {
        return lkzkurs;
    }

    public Satzart0FIBUBuchungssatz setLkzkurs(int lkzkurs) {
        this.lkzkurs = lkzkurs;
        return this;
    }

    public int getLkzfaktor() {
        return lkzfaktor;
    }

    public Satzart0FIBUBuchungssatz setLkzfaktor(int lkzfaktor) {
        this.lkzfaktor = lkzfaktor;
        return this;
    }

    public String getText() {
        return text;
    }

    public Satzart0FIBUBuchungssatz setText(String text) {
        this.text = text;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public Satzart0FIBUBuchungssatz setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getExtbelegnr() {
        return extbelegnr;
    }

    public Satzart0FIBUBuchungssatz setExtbelegnr(String extbelegnr) {
        this.extbelegnr = extbelegnr;
        return this;
    }

    public String getZesskz() {
        return zesskz;
    }

    public Satzart0FIBUBuchungssatz setZesskz(String zesskz) {
        this.zesskz = zesskz;
        return this;
    }

    public int getZziel() {
        return zziel;
    }

    public Satzart0FIBUBuchungssatz setZziel(int zziel) {
        this.zziel = zziel;
        return this;
    }

    public double getSkontopz() {
        return skontopz;
    }

    public Satzart0FIBUBuchungssatz setSkontopz(double skontopz) {
        this.skontopz = skontopz;
        return this;
    }

    public int getSkontotage() {
        return skontotage;
    }

    public Satzart0FIBUBuchungssatz setSkontotage(int skontotage) {
        this.skontotage = skontotage;
        return this;
    }

    public double getSkontopz2() {
        return skontopz2;
    }

    public Satzart0FIBUBuchungssatz setSkontopz2(double skontopz2) {
        this.skontopz2 = skontopz2;
        return this;
    }

    public int getSkontotage2() {
        return skontotage2;
    }

    public Satzart0FIBUBuchungssatz setSkontotage2(int skontotage2) {
        this.skontotage2 = skontotage2;
        return this;
    }

    public LocalDate getValutadatum() {
        return valutadatum;
    }

    public Satzart0FIBUBuchungssatz setValutadatum(LocalDate valutadatum) {
        this.valutadatum = valutadatum;
        return this;
    }

    public LocalDate getWechseldatum() {
        return wechseldatum;
    }

    public Satzart0FIBUBuchungssatz setWechseldatum(LocalDate wechseldatum) {
        this.wechseldatum = wechseldatum;
        return this;
    }

    public int getVertnr() {
        return vertnr;
    }

    public Satzart0FIBUBuchungssatz setVertnr(int vertnr) {
        this.vertnr = vertnr;
        return this;
    }

    public double getProvpz() {
        return provpz;
    }

    public Satzart0FIBUBuchungssatz setProvpz(double provpz) {
        this.provpz = provpz;
        return this;
    }

    public int getAuftkz() {
        return auftkz;
    }

    public Satzart0FIBUBuchungssatz setAuftkz(int auftkz) {
        this.auftkz = auftkz;
        return this;
    }

    public int getAuftnr() {
        return auftnr;
    }

    public Satzart0FIBUBuchungssatz setAuftnr(int auftnr) {
        this.auftnr = auftnr;
        return this;
    }

    public int getZmart() {
        return zmart;
    }

    public Satzart0FIBUBuchungssatz setZmart(int zmart) {
        this.zmart = zmart;
        return this;
    }

    public int getZmbericht() {
        return zmbericht;
    }

    public Satzart0FIBUBuchungssatz setZmbericht(int zmbericht) {
        this.zmbericht = zmbericht;
        return this;
    }

    public double getMenge() {
        return menge;
    }

    public Satzart0FIBUBuchungssatz setMenge(double menge) {
        this.menge = menge;
        return this;
    }

    public int getBenutzer() {
        return benutzer;
    }

    public Satzart0FIBUBuchungssatz setBenutzer(int benutzer) {
        this.benutzer = benutzer;
        return this;
    }

    public int getBuchart() {
        return buchart;
    }

    public Satzart0FIBUBuchungssatz setBuchart(int buchart) {
        this.buchart = buchart;
        return this;
    }

    public int getBuchkz() {
        return buchkz;
    }

    public Satzart0FIBUBuchungssatz setBuchkz(int buchkz) {
        this.buchkz = buchkz;
        return this;
    }

    public int getMahnz() {
        return mahnz;
    }

    public Satzart0FIBUBuchungssatz setMahnz(int mahnz) {
        this.mahnz = mahnz;
        return this;
    }

    public LocalDate getLeistdat() {
        return leistdat;
    }

    public Satzart0FIBUBuchungssatz setLeistdat(LocalDate leistdat) {
        this.leistdat = leistdat;
        return this;
    }

    public int getUvaPeriode() {
        return uvaPeriode;
    }

    public Satzart0FIBUBuchungssatz setUvaPeriode(int uvaPeriode) {
        this.uvaPeriode = uvaPeriode;
        return this;
    }

    public String getUidnr() {
        return uidnr;
    }

    public Satzart0FIBUBuchungssatz setUidnr(String uidnr) {
        this.uidnr = uidnr;
        return this;
    }

    public int getSteuerart() {
        return steuerart;
    }

    public Satzart0FIBUBuchungssatz setSteuerart(int steuerart) {
        this.steuerart = steuerart;
        return this;
    }

    public int getKorekonto() {
        return korekonto;
    }

    public Satzart0FIBUBuchungssatz setKorekonto(int korekonto) {
        this.korekonto = korekonto;
        return this;
    }

    public int getErZahlbank() {
        return erZahlbank;
    }

    public Satzart0FIBUBuchungssatz setErZahlbank(int erZahlbank) {
        this.erZahlbank = erZahlbank;
        return this;
    }

    public int getBauSteucod() {
        return bauSteucod;
    }

    public Satzart0FIBUBuchungssatz setBauSteucod(int bauSteucod) {
        this.bauSteucod = bauSteucod;
        return this;
    }

    public int getUnused2() {
        return unused2;
    }

    public Satzart0FIBUBuchungssatz setUnused2(int unused2) {
        this.unused2 = unused2;
        return this;
    }

    public double getVstAbzugpz() {
        return vstAbzugpz;
    }

    public Satzart0FIBUBuchungssatz setVstAbzugpz(double vstAbzugpz) {
        this.vstAbzugpz = vstAbzugpz;
        return this;
    }

    public int getZvMahnsp() {
        return zvMahnsp;
    }

    public Satzart0FIBUBuchungssatz setZvMahnsp(int zvMahnsp) {
        this.zvMahnsp = zvMahnsp;
        return this;
    }

    public int getErSteukorrKz() {
        return erSteukorrKz;
    }

    public Satzart0FIBUBuchungssatz setErSteukorrKz(int erSteukorrKz) {
        this.erSteukorrKz = erSteukorrKz;
        return this;
    }

    public String getGegenbuchkz() {
        return gegenbuchkz;
    }

    public Satzart0FIBUBuchungssatz setGegenbuchkz(String gegenbuchkz) {
        this.gegenbuchkz = gegenbuchkz;
        return this;
    }

    public String getVerbuchkz() {
        return verbuchkz;
    }

    public Satzart0FIBUBuchungssatz setVerbuchkz(String verbuchkz) {
        this.verbuchkz = verbuchkz;
        return this;
    }

    public int getUnused3() {
        return unused3;
    }

    public Satzart0FIBUBuchungssatz setUnused3(int unused3) {
        this.unused3 = unused3;
        return this;
    }

    public String getUnused4() {
        return unused4;
    }

    public Satzart0FIBUBuchungssatz setUnused4(String unused4) {
        this.unused4 = unused4;
        return this;
    }

    public String getBuchdatFormated() {
        LocalDate lDate = getBuchdat();
        if (lDate == null) {
            return StringUtils.EMPTY;
        }
        return lDate.format(dateTimeFormatter);
    }

    ;

    public String getBelegdatFormated() {
        LocalDate lDate = getBelegdat();
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
                ", buchdat=" + buchdat +
                ", gkto=" + gkto +
                ", belegnr=" + belegnr +
                ", belegdat=" + belegdat +
                ", kost=" + kost +
                ", unused1='" + unused1 + '\'' +
                ", kotraeger=" + kotraeger +
                ", komenge=" + komenge +
                ", komengenr=" + komengenr +
                ", kovariator=" + kovariator +
                ", koperiode=" + koperiode +
                ", komonteiler=" + komonteiler +
                ", mwst=" + mwst +
                ", steucod=" + steucod +
                ", ebkennz=" + ebkennz +
                ", bucod=" + bucod +
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
                ", symbol='" + symbol + '\'' +
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