package com.example.fluganzeigetafel.Orders;


import com.example.fluganzeigetafel.Orders.Data.CSVRow;
import com.example.fluganzeigetafel.Suborders.Suborder;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * The Order class represents an order with various attributes and methods to manage and manipulate order information.
 * It includes methods for retrieving and setting attributes like the number of changes, the last change timestamp, etc.
 */
public class Order {
/**
 * Retrieves the number of changes made to the order.
 *
 * @return The number of changes made to the order.
 */
    
    public int getChanges() {
        return changes;
    }
/**
 * Sets the number of changes made to the order.
 *
 * @param changes The number of changes to set.
 */
    public void setChanges(int changes) {
        this.changes = changes;
    }
/**
 * Retrieves the timestamp of the last change made to the order.
 *
 * @return The timestamp of the last change made to the order.
 */
    public LocalDateTime getLastChange() {
        if (lastChange != null)
            lastChange = LocalDateTime.parse(lastChange.toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        return lastChange;
    }
/**
 * Sets the timestamp of the last change made to the order.
 *
 * @param lastChange The timestamp of the last change to set.
 */
    public void setLastChange(LocalDateTime lastChange) {
        this.lastChange = lastChange;
    }
/**
 * Retrieves the timestamp of the creation date of the order.
 *
 * @return The timestamp of the creation date of the order.
 */
    public LocalDateTime getCreationDate() {
        creationDate = LocalDateTime.parse(creationDate.toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        return creationDate;
    }

    /**
 * Retrieves the formatted string representation of the last change timestamp.
 *
 * @return The formatted string representation of the last change timestamp.
 */
    public String getLastChangeFormatted() {
        if (lastChange != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return lastChange.format(formatter);
        }
        return ""; // or throw an exception or handle the null case as needed
    }
/**
 * Retrieves the formatted string representation of the creation date timestamp.
 *
 * @return The formatted string representation of the creation date timestamp.
 */
    // New method to get formatted date string for creationDate
    public String getCreationDateFormatted() {
        if (creationDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return creationDate.format(formatter);
        }
        return ""; // or throw an exception or handle the null case as needed
    }

**
 * Sets the timestamp of the creation date of the order.
 *
 * @param creationDate The timestamp of the creation date to set.
 */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private int changes;
    private LocalDateTime lastChange;
    private LocalDateTime creationDate;






    public String getAUKEY() {
        return AUKEY;
    }

    public String getDISPO() {
        return DISPO;
    }

    public void setDISPO(String DISPO) {
        this.DISPO = DISPO;
    }

    public String getDIB() {
        return DIB;
    }

    public void setDIB(String DIB) {
        this.DIB = DIB;
    }

    public String getJTP() {
        return JTP;
    }

    public void setJTP(String JTP) {
        this.JTP = JTP;
    }

    public String getAUSAA() {
        return AUSAA;
    }

    public void setAUSAA(String AUSAA) {
        this.AUSAA = AUSAA;
    }

    public String getAUSAU() {
        return AUSAU;
    }

    public void setAUSAU(String AUSAU) {
        this.AUSAU = AUSAU;
    }

    public String getAUKNL() {
        return AUKNL;
    }

    public void setAUKNL(String AUKNL) {
        this.AUKNL = AUKNL;
    }

    public String getAUKNS() {
        return AUKNS;
    }

    public void setAUKNS(String AUKNS) {
        this.AUKNS = AUKNS;
    }

    public String getFGKEY() {
        return FGKEY;
    }

    public void setFGKEY(String FGKEY) {
        this.FGKEY = FGKEY;
    }

    public String getPLKEY() {
        return PLKEY;
    }

    public void setPLKEY(String PLKEY) {
        this.PLKEY = PLKEY;
    }

    public String getORTFR() {
        return ORTFR;
    }

    public void setORTFR(String ORTFR) {
        this.ORTFR = ORTFR;
    }

    public String getORTTO() {
        return ORTTO;
    }

    public void setORTTO(String ORTTO) {
        this.ORTTO = ORTTO;
    }

    public String getMENGE() {
        return MENGE;
    }

    public void setMENGE(String MENGE) {
        this.MENGE = MENGE;
    }

    public String getEINHE() {
        return EINHE;
    }

    public void setEINHE(String EINHE) {
        this.EINHE = EINHE;
    }

    public String getMENG2() {
        return MENG2;
    }

    public void setMENG2(String MENG2) {
        this.MENG2 = MENG2;
    }

    public String getEINH2() {
        return EINH2;
    }

    public void setEINH2(String EINH2) {
        this.EINH2 = EINH2;
    }

    public String getMENG3() {
        return MENG3;
    }

    public void setMENG3(String MENG3) {
        this.MENG3 = MENG3;
    }

    public String getEINH3() {
        return EINH3;
    }

    public void setEINH3(String EINH3) {
        this.EINH3 = EINH3;
    }

    public String getMENG4() {
        return MENG4;
    }

    public void setMENG4(String MENG4) {
        this.MENG4 = MENG4;
    }

    public String getEINH4() {
        return EINH4;
    }

    public void setEINH4(String EINH4) {
        this.EINH4 = EINH4;
    }

    public String getUAZPL() {
        return UAZPL;
    }

    public void setUAZPL(String UAZPL) {
        this.UAZPL = UAZPL;
    }

    public String getUAZAK() {
        return UAZAK;
    }

    public void setUAZAK(String UAZAK) {
        this.UAZAK = UAZAK;
    }

    public String getAUAGE() {
        return AUAGE;
    }

    public void setAUAGE(String AUAGE) {
        this.AUAGE = AUAGE;
    }

    public String getSTTBE() {
        return STTBE;
    }

    public void setSTTBE(String STTBE) {
        this.STTBE = STTBE;
    }

    public String getSTTEN() {
        return STTEN;
    }

    public void setSTTEN(String STTEN) {
        this.STTEN = STTEN;
    }

    public String getETTBE() {
        return ETTBE;
    }

    public void setETTBE(String ETTBE) {
        this.ETTBE = ETTBE;
    }

    public String getETTEN() {
        return ETTEN;
    }

    public void setETTEN(String ETTEN) {
        this.ETTEN = ETTEN;
    }

    public String getATTBE() {
        return ATTBE;
    }

    public void setATTBE(String ATTBE) {
        this.ATTBE = ATTBE;
    }

    public String getATTEN() {
        return ATTEN;
    }

    public void setATTEN(String ATTEN) {
        this.ATTEN = ATTEN;
    }

    public String getATT20() {
        return ATT20;
    }

    public void setATT20(String ATT20) {
        this.ATT20 = ATT20;
    }

    public String getAUPIR() {
        return AUPIR;
    }

    public void setAUPIR(String AUPIR) {
        this.AUPIR = AUPIR;
    }

    public String getZINFO() {
        return ZINFO;
    }

    public void setZINFO(String ZINFO) {
        this.ZINFO = ZINFO;
    }

    public String getLUPDN() {
        return LUPDN;
    }

    public void setLUPDN(String LUPDN) {
        this.LUPDN = LUPDN;
    }

    public String getLUPDT() {
        return LUPDT;
    }

    public void setLUPDT(String LUPDT) {
        this.LUPDT = LUPDT;
    }

    public String getLUPDV() {
        return LUPDV;
    }

    public void setLUPDV(String LUPDV) {
        this.LUPDV = LUPDV;
    }

    public String getKEYLK() {
        return KEYLK;
    }

    public void setKEYLK(String KEYLK) {
        this.KEYLK = KEYLK;
    }

    public String getKEYLE() {
        return KEYLE;
    }

    public void setKEYLE(String KEYLE) {
        this.KEYLE = KEYLE;
    }

    public String getKEYLF() {
        return KEYLF;
    }

    public void setKEYLF(String KEYLF) {
        this.KEYLF = KEYLF;
    }

    public String getXAU() {
        return XAU;
    }

    public void setXAU(String XAU) {
        this.XAU = XAU;
    }

    public String getAUDAT() {
        return AUDAT;
    }

    public void setAUDAT(String AUDAT) {
        this.AUDAT = AUDAT;
    }

    public String getAUABF() {
        return AUABF;
    }

    public void setAUABF(String AUABF) {
        this.AUABF = AUABF;
    }

    public String getMITAR() {
        return MITAR;
    }

    public void setMITAR(String MITAR) {
        this.MITAR = MITAR;
    }

    public String getFDAEN() {
        return FDAEN;
    }

    public void setFDAEN(String FDAEN) {
        this.FDAEN = FDAEN;
    }

    public String getFLAGS() {
        return FLAGS;
    }

    public void setFLAGS(String FLAGS) {
        this.FLAGS = FLAGS;
    }

    public String getCINFO() {
        return CINFO;
    }

    public void setCINFO(String CINFO) {
        this.CINFO = CINFO;
    }

    public String getMAD() {
        return MAD;
    }

    public void setMAD(String MAD) {
        this.MAD = MAD;
    }

    public String getSTLIK() {
        return STLIK;
    }

    public void setSTLIK(String STLIK) {
        this.STLIK = STLIK;
    }

    public String getPKART() {
        return PKART;
    }

    public void setPKART(String PKART) {
        this.PKART = PKART;
    }

    public String getPKL() {
        return PKL;
    }

    public void setPKL(String PKL) {
        this.PKL = PKL;
    }

    public String getPKLAS() {
        return PKLAS;
    }

    public void setPKLAS(String PKLAS) {
        this.PKLAS = PKLAS;
    }

    public String getPKLEA() {
        return PKLEA;
    }

    public void setPKLEA(String PKLEA) {
        this.PKLEA = PKLEA;
    }

    public String getPKNAM() {
        return PKNAM;
    }

    public void setPKNAM(String PKNAM) {
        this.PKNAM = PKNAM;
    }

    public String getFELFK() {
        return FELFK;
    }

    public void setFELFK(String FELFK) {
        this.FELFK = FELFK;
    }

    private String AUKEY;
    private String DISPO;
    private String DIB;
    private String JTP;
    private String AUSAA;
    private String AUSAU;
    private String AUKNL;
    private String AUKNS;
    private String FGKEY;
    private String PLKEY;
    private String ORTFR;
    private String ORTTO;
    private String MENGE;
    private String EINHE;
    private String MENG2;
    private String EINH2;
    private String MENG3;
    private String EINH3;
    private String MENG4;
    private String EINH4;
    private String UAZPL;
    private String UAZAK;
    private String AUAGE;
    private String STTBE;
    private String STTEN;
    private String ETTBE;
    private String ETTEN;
    private String ATTBE;
    private String ATTEN;
    private String ATT20;
    private String AUPIR;
    private String ZINFO;
    private String LUPDN;
    private String LUPDT;
    private String LUPDV;
    private String KEYLK;
    private String KEYLE;
    private String KEYLF;
    private String XAU;
    private String AUDAT;
    private String AUABF;
    private String MITAR;
    private String FDAEN;
    private String FLAGS;
    private String CINFO;
    private String MAD;
    private String STLIK;
    private String PKART;
    private String PKL;
    private String PKLAS;
    private String PKLEA;
    private String PKNAM;
    private String FELFK;

    public String getRELFK() {
        return RELFK;
    }

    public void setRELFK(String RELFK) {
        this.RELFK = RELFK;
    }

    private String RELFK;

    private ArrayList<Suborder> suborderList = new ArrayList<>();


    public void setAUKEY(String AUKEY) {
        this.AUKEY = AUKEY;
    }


/**
 * Creates an Order with AUKEY
 *
 * @param AUKEY The unique key of Order
 */
    public Order(String AUKEY) {
        this.ATTBE = "";
        this.ATTEN = "";
        this.AUAGE = "";
        this.AUKEY = AUKEY;
        this.AUKNL = "";
        this.AUKNS = "";
        this.AUPIR = "";
        this.AUSAA = "";
        this.AUSAU = "";
        this.DISPO = "";
        this.EINHE = "";
        this.ETTBE = "";
        this.ETTEN = "";
        this.FGKEY = "";
        this.JTP = "";
        this.KEYLK = "";
        this.KEYLE = "";
        this.KEYLF = "";
        this.LUPDN = "";
        this.LUPDT = "";
        this.LUPDV = "";
        this.MENGE = "";
        this.ORTFR = "";
        this.ORTTO = "";
        this.STTBE = "";
        this.STTEN = "";
        this.UAZAK = "";
        this.UAZPL = "";
        this.XAU = "";
        this.ZINFO = "";
        this.DIB = "";
        this.PLKEY = "";
        this.AUDAT = "";
        this.AUABF = "";
        this.ATT20 = "";
        this.RELFK = "";
        this.CINFO = "";
        this.FDAEN = "";
        this.FLAGS = "";
        this.MITAR = "";
        this.MAD = "";
        this.STLIK = "";
        this.PKART = "";
        this.PKL = "";
        this.PKLAS = "";
        this.PKLEA = "";
        this.PKNAM = "";
        this.PLKEY = "";
        this.EINH2 = "";
        this.EINH3 = "";
        this.EINH4 = "";
        this.MENG2 = "";
        this.MENG3 = "";
        this.MENG4 = "";
        this.FELFK = "";
        rows = new ArrayList<>();
    }

    public Order() {
        this.rows = new ArrayList<>();
    }

/**
 * Creates an Order object with the specified attributes.
 *
 * @param ATTBE Actual Time of Begin
 * @param ATTEN Actual Time of End
 * @param AUAGE Auftraggeber
 * @param AUKEY Autragsschlüssel
 * @param AUKNL Kontrollnummer Landung
 * @param AUKNS Kontrollnummer Start
 * @param AUPIR Problemindikator
 * @param AUSAA Auftragsstatus
 * @param AUSAU Unterstatus
 * @param DISPO Dispositionssystem
 * @param EINHE Einheit f. MENGE
 * @param ETTBE Estm. Time of Begin
 * @param ETTEN Estim. Time of End
 * @param FGKEY Referenz auf Fremddaten
 * @param JTP Job Type
 * @param KEYLK ID-des LK-Informationbroker
 * @param KEYLE ID-des LE-Informationbroker
 * @param KEYLF ID-des LF-Informationbroker
 * @param LUPDN letzter Update
 * @param LUPDT Zeitpunkt des letzten Updates
 * @param LUPDV Veranlasser d. letzten Änderung
 * @param MENGE Menge
 * @param ORTFR 1. Ort (from)
 * @param ORTTO 2. Ort (to)
 * @param STTBE Schedule Time of begin
 * @param STTEN Schedule Time of End
 * @param UAZAK Teilauftragszähler
 * @param UAZPL planm. benötigte TA's
 * @param XAU Änderungszeitstempel
 * @param ZINFO Zusatzinformationen
 * @param DIB Dispositionsbereich
 * @param PLKEY Planungsschlüssel
 * @param AUDAT Tagesdatum des Auftrags
 * @param AUABF Auftragsabfertiger
 * @param ATT20 1. Vorlage zur Disposition
 * @param RELFK wird in KFZ noch verwendet
 * @param CINFO Creator-Info
 * @param FDAEN FD-Änderung
 * @param FLAGS Flags
 * @param MITAR Mitarbeiterkürzel
 * @param MAD Mandant
 * @param STLIK StücklistenKey
 * @param PKART Prozessart
 * @param PKL Prozessklasse
 * @param PKLAS Lastsituation
 * @param PKLEA Leistungsart
 * @param PKNAM Prozessklassename
 */
    public Order(String ATTBE, String ATTEN, String AUAGE, String AUKEY, String AUKNL, String AUKNS, String AUPIR,
                 String AUSAA, String AUSAU, String DISPO, String EINHE, String ETTBE, String ETTEN, String FGKEY,
                 String JTP, String KEYLK, String KEYLE, String KEYLF, String LUPDN, String LUPDT, String LUPDV,
                 String MENGE, String ORTFR, String ORTTO, String STTBE, String STTEN, String UAZAK, String UAZPL,
                 String XAU, String ZINFO, String DIB, String PLKEY, String AUDAT, String AUABF, String ATT20,
                 String RELFK, String CINFO, String FDAEN, String FLAGS, String MITAR, String MAD, String STLIK,
                 String PKART, String PKL, String PKLAS, String PKLEA, String PKNAM, String PLE, String EINH2,
                 String EINH3, String EINH4, String MENG2, String MENG3, String MENG4) {

        this.AUKEY = AUKEY;
        this.DISPO = DISPO;
        this.DIB = DIB;
        this.JTP = JTP;
        this.AUSAA = AUSAA;
        this.AUSAU = AUSAU;
        this.AUKNL = AUKNL;
        this.AUKNS = AUKNS;
        this.FGKEY = FGKEY;
        this.PLKEY = PLKEY;
        this.ORTFR = ORTFR;
        this.ORTTO = ORTTO;
        this.MENGE = MENGE;
        this.EINHE = EINHE;
        this.MENG2 = MENG2;
        this.EINH2 = EINH2;
        this.MENG3 = MENG3;
        this.EINH3 = EINH3;
        this.MENG4 = MENG4;
        this.EINH4 = EINH4;
        this.UAZPL = UAZPL;
        this.UAZAK = UAZAK;
        this.AUAGE = AUAGE;
        this.STTBE = STTBE;
        this.STTEN = STTEN;
        this.ETTBE = ETTBE;
        this.ETTEN = ETTEN;
        this.ATTBE = ATTBE;
        this.ATTEN = ATTEN;
        this.ATT20 = ATT20;
        this.AUPIR = AUPIR;
        this.ZINFO = ZINFO;
        this.LUPDN = LUPDN;
        this.LUPDT = LUPDT;
        this.LUPDV = LUPDV;
        this.KEYLK = KEYLK;
        this.KEYLE = KEYLE;
        this.KEYLF = KEYLF;
        this.XAU = XAU;
        this.AUDAT = AUDAT;
        this.AUABF = AUABF;
        this.MITAR = MITAR;
        this.FDAEN = FDAEN;
        this.FLAGS = FLAGS;
        this.CINFO = CINFO;
        this.MAD = MAD;
        this.STLIK = STLIK;
        this.PKART = PKART;
        this.PKL = PKL;
        this.PKLAS = PKLAS;
        this.PKLEA = PKLEA;
        this.PKNAM = PKNAM;
        this.FELFK = FELFK;

        rows = new ArrayList<>();
    }

/**
 * Sets the list of CSVRows for this Order.
 *
 * @param rows The list of CSVRows to set.
 */
    public void setRows(ArrayList<CSVRow> rows) {
        this.rows = rows;
    }

    private ArrayList<CSVRow> rows;
/**
 * Generates a list of CSVRows based on the attributes of the provided Order.
 *
 * @param order The Order object to generate CSVRows from.
 * @return ArrayList of CSVRows generated from the Order's attributes.
 */
    public static ArrayList<CSVRow> generateListOfCSVRows(Order order) {
        Class<?> clazz = order.getClass();
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<CSVRow> rows = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                // Skip specific fields: changes, lastChange, creationDate
                if ("changes".equals(field.getName()) || "lastChange".equals(field.getName()) || "creationDate".equals(field.getName())) {
                    continue;
                }

                if (field.get(order) != null && !field.get(order).toString().isEmpty()) {
                    CSVRow row = new CSVRow(field.getName(), field.get(order).toString());

                    // Exclude rows with empty values, values containing ';', or values containing '['
                    if (!row.getValue().isEmpty() && !row.getValue().contains(";") && !row.getValue().contains("[")) {
                        rows.add(row);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return rows;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private  String title;
/**
 * Creates an Order with the specified title and argument.
 *
 * @param title The title for the Order.
 * @param arg   The argument for the Order.
 */
    public Order(String title, String arg) {
        this.title = title;
    }

        public ArrayList<CSVRow> getCSVRows() {
            return rows;
        }


        public ArrayList<Suborder> getSubOrdersList() {
            return this.suborderList;
        }

        public void deleteSubOrder(String uakey) {
        for (Suborder suborder : getSubOrdersList()) {

            if (suborder.getUAKEY().trim().equals(uakey.trim())) {

                this.suborderList.remove(suborder);
                return;
            }
        }
        }

        public void addSubOrderToSubOrdersList(Suborder suborder){
            this.suborderList.add(suborder);
        }

    public Suborder getSubOrderByUAKEY(String uakey) {
        for (Suborder suborder : this.getSubOrdersList()) {
            if (suborder.getUAKEY().trim().equals(uakey))
                return suborder;
        }
        return null;
    }
    }

