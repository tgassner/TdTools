package at.transparentdesign.tdtools.satz;

public enum Satzart0FIBUBuchungssatzFields {

    SATZART(1, "satzart", "satzart", 1, 1),
    KONTO(2, "konto", "konto", 2, 10),
    BUCHDAT(3, "buchdat", "buchdatum", 11, 18),
    GKTO(4, "gkto", "gkonto", 19, 27),
    BELEGNR(5, "belegnr", "belegnr", 28, 36),
    BELEGDAT(6, "belegdat", "belegdatum", 37, 44),
    KOST(7, "kost", "kost", 45, 53),
    UNUSED1(8, "unused1", "ToDo", 54, 54),
    KOTRAEGER(9, "kotraeger", "ToDo", 55, 63),
    KOMENGE(10, "komenge", "ToDo", 64, 81),
    KOMENGENR(11, "komengenr", "ToDo", 82, 85),
    KOVARIATOR(12, "kovariator", "ToDo", 86, 90),
    KOPERIODE(13, "koperiode", "ToDo", 91, 96),
    KOMONTEILER(14, "komonteiler", "ToDo", 97, 98),
    MWST(15, "mwst", "prozent", 99, 103),
    STEUCOD(16, "steucod", "steuercode", 104, 105),
    EBKENNZ(17, "ebkennz", "ToDo", 106, 106),
    BUCOD(18, "bucod", "buchcode", 107, 107),
    BETRAG(19, "betrag", "betrag", 108, 125),
    STEUER(20, "steuer", "steuer", 126, 143),
    SKONTO(21, "skonto", "skonto", 144, 161),
    OPBETRAG(22, "opbetrag", "ToDo", 162, 179),
    PERIODE(23, "periode", "ToDo", 180, 181),
    KURSNR(24, "kursnr", "ToDo", 182, 185),
    FWKURS(25, "fwkurs", "ToDo", 186, 198),
    FWFAKTOR(26, "fwfaktor", "ToDo", 199, 204),
    FWBETRAG(27, "fwbetrag", "ToDo", 205, 222),
    FWSTEUER(28, "fwsteuer", "ToDo", 223, 240),
    FWSKONTO(29, "fwskonto", "ToDo", 241, 258),
    FWOPBETR(30, "fwopbetr", "ToDo", 259, 276),
    LANDKZ(31, "landkz", "ToDo", 277, 280),
    LKZKURS(32, "lkzkurs", "ToDo", 281, 293),
    LKZFAKTOR(33, "lkzfaktor", "ToDo", 294, 299),
    TEXT(34, "text", "text", 300, 317),
    SYMBOL(35, "symbol", "buchsymbol", 318, 319),
    EXTBELEGNR(36, "extbelegnr", "extbelegnr", 320, 331),
    ZESSKZ(37, "zesskz", "ToDo", 332, 332),
    ZZIEL(38, "zziel", "ToDo", 333, 338),
    SKONTOPZ(39, "skontopz", "ToDo", 339, 343),
    SKONTOTAGE(40, "skontotage", "ToDo", 344, 347),
    SKONTOPZ2(41, "skontopz2", "ToDo", 348, 352),
    SKONTOTAGE2(42, "skontotage2", "ToDo", 353, 356),
    VALUTADATUM(43, "valutadatum", "ToDo", 357, 364),
    WECHSELDATUM(44, "wechseldatum", "ToDo", 365, 372),
    VERTNR(45, "vertnr", "ToDo", 373, 378),
    PROVPZ(46, "provpz", "ToDo", 379, 384),
    AUFTKZ(47, "auftkz", "ToDo", 385, 386),
    AUFTNR(48, "auftnr", "ToDo", 387, 395),
    ZMART(49, "zmart", "ToDo", 396, 396),
    ZMBERICHT(50, "zmbericht", "ToDo", 397, 397),
    MENGE(51, "menge", "ToDo", 398, 415),
    BENUTZER(52, "benutzer", "ToDo", 416, 417),
    BUCHART(53, "buchart", "ToDo", 418, 419),
    BUCHKZ(54, "buchkz", "ToDo", 420, 421),
    MAHNZ(55, "mahnz", "ToDo", 422, 425),
    LEISTDAT(56, "leistdat", "ToDo", 426, 433),
    UVA_PERIODE(57, "uva-periode", "ToDo", 434, 439),
    UIDNR(58, "uidnr", "ToDo", 440, 454),
    STEUERART(59, "steuerart", "ToDo", 455, 456),
    KOREKONTO(60, "korekonto", "ToDo", 457, 465),
    ER_ZAHLBANK(61, "er-zahlbank", "ToDo", 466, 467),
    BAU_STEUCOD(62, "bau-steucod", "ToDo", 468, 469),
    UNUSED2(63, "unused2", "ToDo", 470, 470),
    VST_ABZUGPZ(64, "vst-abzugpz", "ToDo", 471, 474),
    ZV_MAHNSP(65, "zv-mahnsp", "ToDo", 475, 475),
    ER_STEUKORR_KZ(66, "er-steukorr-kz", "ToDo", 476, 476),
    GEGENBUCHKZ(67, "gegenbuchkz", "ToDo", 477, 477),
    VERBUCHKZ(68, "verbuchkz", "ToDo", 478, 478),
    UNUSED3(69, "unused3", "ToDo", 479, 479),
    UNUSED4(70, "unused4", "ToDo", 480, 480),
    FILIALE(71, "", "filiale", -1, -1);


    /*




    private satzart;
    private konto;
    private buchdat;
    private gkto;
    private belegnr;
    private belegdat;
    private kost;
    private unused1;
    private kotraeger;
    private komenge;
    private komengenr;
    private kovariator;
    private koperiode;
    private komonteiler;
    private mwst;
    private steucod;
    private ebkennz;
    private bucod;
    private betrag;
    private steuer;
    private skonto;
    private opbetrag;
    private periode;
    private kursnr;
    private fwkurs;
    private fwfaktor;
    private fwbetrag;
    private fwsteuer;
    private fwskonto;
    private fwopbetr;
    private landkz;
    private lkzkurs;
    private lkzfaktor;
    private text;
    private symbol;
    private extbelegnr;
    private zesskz;
    private zziel;
    private skontopz;
    private skontotage;
    private skontopz2;
    private skontotage2;
    private valutadatum;
    private wechseldatum;
    private vertnr;
    private provpz;
    private auftkz;
    private auftnr;
    private zmart;
    private zmbericht;
    private menge;
    private benutzer;
    private buchart;
    private buchkz;
    private mahnz;
    private leistdat;
    private uva-periode;
    private uidnr;
    private steuerart;
    private korekonto;
    private er-zahlbank;
    private bau-steucod;
    private unused2;
    private vst-abzugpz;
    private zv-mahnsp;
    private er-steukorr-kz;
    private gegenbuchkz;
    private verbuchkz;
    private unused3;
    private unused4;

     */

    private final int id;
    private final String bmd55headerElement;
    private final String ntcsBookingheaderElement;
    private final int startPosBmd55;
    private final int endPosBmd55;

    Satzart0FIBUBuchungssatzFields(int id, String bmd55headerElement, String ntcsBookingheaderElement, int startPosBmd55, int endPos) {
        this.id = id;
        this.bmd55headerElement = bmd55headerElement;
        this.ntcsBookingheaderElement = ntcsBookingheaderElement;
        this.startPosBmd55 = startPosBmd55;
        this.endPosBmd55 = endPos;
    }

    public int getId() {
        return id;
    }

    public String getBmd55headerElement() {
        return bmd55headerElement;
    }

    public int getStartPosBmd55() {
        return startPosBmd55;
    }

    public int getEndPosBmd55() {
        return endPosBmd55;
    }

    public int getLength() {
        return (endPosBmd55 - startPosBmd55) + 1;
    }

    public String getNtcsBookingheaderElement() {
        return ntcsBookingheaderElement;
    }

    /*
    public List<Satzart0FIBUBuchungssatzFields> getValues(){
            List<Satzart0FIBUBuchungssatzFields>
    }
    */


}
