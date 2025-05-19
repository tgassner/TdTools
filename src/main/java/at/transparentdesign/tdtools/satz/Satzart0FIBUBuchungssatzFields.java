package at.transparentdesign.tdtools.satz;

public enum Satzart0FIBUBuchungssatzFields {

    SATZART(1, "satzart", 1, 1),
    KONTO(2, "konto", 2, 10),
    BUCHDAT(3, "buchdat", 11, 18),
    GKTO(4, "gkto", 19, 27),
    BELEGNR(5, "belegnr", 28, 36),
    BELEGDAT(6, "belegdat", 37, 44),
    KOST(7, "kost", 45, 53),
    UNUSED1(8, "unused1", 54, 54),
    KOTRAEGER(9, "kotraeger", 55, 63),
    KOMENGE(10, "komenge", 64, 81),
    KOMENGENR(11, "komengenr", 82, 85),
    KOVARIATOR(12, "kovariator", 86, 90),
    KOPERIODE(13, "koperiode", 91, 96),
    KOMONTEILER(14, "komonteiler", 97, 98),
    MWST(15, "mwst", 99, 103),
    STEUCOD(16, "steucod", 104, 105),
    EBKENNZ(17, "ebkennz", 106, 106),
    BUCOD(18, "bucod", 107, 107),
    BETRAG(19, "betrag", 108, 125),
    STEUER(20, "steuer", 126, 143),
    SKONTO(21, "skonto", 144, 161),
    OPBETRAG(22, "opbetrag", 162, 179),
    PERIODE(23, "periode", 180, 181),
    KURSNR(24, "kursnr", 182, 185),
    FWKURS(25, "fwkurs", 186, 198),
    FWFAKTOR(26, "fwfaktor", 199, 204),
    FWBETRAG(27, "fwbetrag", 205, 222),
    FWSTEUER(28, "fwsteuer", 223, 240),
    FWSKONTO(29, "fwskonto", 241, 258),
    FWOPBETR(30, "fwopbetr", 259, 276),
    LANDKZ(31, "landkz", 277, 280),
    LKZKURS(32, "lkzkurs", 281, 293),
    LKZFAKTOR(33, "lkzfaktor", 294, 299),
    TEXT(34, "text", 300, 317),
    SYMBOL(35, "symbol", 318, 319),
    EXTBELEGNR(36, "extbelegnr", 320, 331),
    ZESSKZ(37, "zesskz", 332, 332),
    ZZIEL(38, "zziel", 333, 338),
    SKONTOPZ(39, "skontopz", 339, 343),
    SKONTOTAGE(40, "skontotage", 344, 347),
    SKONTOPZ2(41, "skontopz2", 348, 352),
    SKONTOTAGE2(42, "skontotage2", 353, 356),
    VALUTADATUM(43, "valutadatum", 357, 364),
    WECHSELDATUM(44, "wechseldatum", 365, 372),
    VERTNR(45, "vertnr", 373, 378),
    PROVPZ(46, "provpz", 379, 384),
    AUFTKZ(47, "auftkz", 385, 386),
    AUFTNR(48, "auftnr", 387, 395),
    ZMART(49, "zmart", 396, 396),
    ZMBERICHT(50, "zmbericht", 397, 397),
    MENGE(51, "menge", 398, 415),
    BENUTZER(52, "benutzer", 416, 417),
    BUCHART(53, "buchart", 418, 419),
    BUCHKZ(54, "buchkz", 420, 421),
    MAHNZ(55, "mahnz", 422, 425),
    LEISTDAT(56, "leistdat", 426, 433),
    UVA_PERIODE(57, "uva-periode", 434, 439),
    UIDNR(58, "uidnr", 440, 454),
    STEUERART(59, "steuerart", 455, 456),
    KOREKONTO(60, "korekonto", 457, 465),
    ER_ZAHLBANK(61, "er-zahlbank", 466, 467),
    BAU_STEUCOD(62, "bau-steucod", 468, 469),
    UNUSED2(63, "unused2", 470, 470),
    VST_ABZUGPZ(64, "vst-abzugpz", 471, 474),
    ZV_MAHNSP(65, "zv-mahnsp", 475, 475),
    ER_STEUKORR_KZ(66, "er-steukorr-kz", 476, 476),
    GEGENBUCHKZ(67, "gegenbuchkz", 477, 477),
    VERBUCHKZ(68, "verbuchkz", 478, 478),
    UNUSED3(69, "unused3", 479, 479),
    UNUSED4(70, "unused4", 480, 480);


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
    private final String headerElement;
    private final int startPos;
    private final int endPos;

    Satzart0FIBUBuchungssatzFields(int id, String headerElement, int startPos, int endPos) {
        this.id = id;
        this.headerElement = headerElement;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getId() {
        return id;
    }

    public String getHeaderElement() {
        return headerElement;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public int getLength() {
        return (endPos - startPos) + 1;
    }

    /*
    public List<Satzart0FIBUBuchungssatzFields> getValues(){
            List<Satzart0FIBUBuchungssatzFields>
    }
    */


}
