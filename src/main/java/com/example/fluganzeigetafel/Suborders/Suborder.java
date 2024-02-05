package com.example.fluganzeigetafel.Suborders;

import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.Orders.Data.CSVRow;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Represents a Suborder with attributes related to changes, last change date, and creation date.
 */
public class Suborder {

    /**
     * Gets the number of changes made to the Suborder.
     *
     * @return The number of changes.
     */
    public int getChanges() {
        return changes;
    }

    /**
     * Sets the number of changes made to the Suborder.
     *
     * @param changes The number of changes to set.
     */
    public void setChanges(int changes) {
        this.changes = changes;
    }

    /**
     * Gets the last change date and time of the Suborder.
     *
     * @return The last change date and time.
     */
    public LocalDateTime getLastChange() {
        if (lastChange != null)
            lastChange = LocalDateTime.parse(lastChange.toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        return lastChange;
    }

    /**
     * Sets the last change date and time of the Suborder.
     *
     * @param lastChange The last change date and time to set.
     */

    public void setLastChange(LocalDateTime lastChange) {
        this.lastChange = lastChange;
    }

    /**
     * Gets the creation date and time of the Suborder.
     *
     * @return The creation date and time.
     */
    public LocalDateTime getCreationDate() {
        creationDate = LocalDateTime.parse(creationDate.toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        return creationDate;
    }

    /**
     * Gets the formatted string representation of the last change date and time.
     *
     * @return The formatted last change date and time string.
     */
    public String getLastChangeFormatted() {
        if (lastChange != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return lastChange.format(formatter);
        }
        return ""; // or throw an exception or handle the null case as needed
    }

    /**
     * Gets the formatted string representation of the creation date and time.
     *
     * @return The formatted creation date and time string.
     */
    public String getCreationDateFormatted() {
        if (creationDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return creationDate.format(formatter);
        }
        return ""; // or throw an exception or handle the null case as needed
    }

    /**
     * Sets the creation date and time of the Suborder.
     *
     * @param creationDate The creation date and time to set.
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private int changes;
    private LocalDateTime lastChange;
    private LocalDateTime creationDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Suborder that = (Suborder) obj;

        return Objects.equals(UAKEY, that.UAKEY);
    }

    @Override
    public int hashCode() {
        return AUKEY != null ? AUKEY.hashCode() : 0;
    }

    private String ATTBE, ATTEN, AUKEY, CBDFK, ETTBE, ETTEN, INDNR, LUPDN, LUPDT, LUPDV, LZUAU,
            MENGE, STTBE, STTEN, UAKEY, UAPIR, UASAA, UASAU, XUA, ZINFO, DFKEY, ORTFR, ORTTO,
            UAART, UAREE, FGKEY, UAABF, REKEY, SPREK, ATT30, ATT50, ATT55, ATT60, ATT70, ATT75,
            ATTER, UAAGE, EINHE, ATT20, QKB, SAA20, SAAOF, SKA, STT20, URK, RELFK, UAINF,
            ETT30, UAKSL, SPKEY, MENG2, CINFO, ATT40, STLIK, OKEYN, ABI, EBI, SBI, TOURK, EINH2,
            EINH3, EINH4, MENG3, MENG4, XCABA;


    public Suborder(String ATTBE, String ATTEN, String AUKEY, String CBDFK, String ETTBE, String ETTEN,
                    String INDNR, String LUPDN, String LUPDT, String LUPDV, String LZUAU, String MENGE,
                    String STTBE, String STTEN, String UAKEY, String UAPIR, String UASAA, String UASAU,
                    String XUA, String ZINFO, String DFKEY, String ORTFR, String ORTTO, String UAART,
                    String UAREE, String FGKEY, String UAABF, String REKEY, String SPREK, String ATT30,
                    String ATT50, String ATT55, String ATT60, String ATT70, String ATT75, String ATTER,
                    String UAAGE, String EINHE, String ATT20, String QKB, String SAA20, String SAAOF,
                    String SKA, String STT20, String URK, String RELFK, String UAINF, String ETT30,
                    String UAKSL, String SPKEY, String MENG2, String CINFO, String ATT40, String STLIK,
                    String OKEYN, String ABI, String EBI, String SBI, String TOURK,
                    String EINH2, String EINH3, String EINH4, String MENG3, String MENG4, String XCABA) {


        this.ATTBE = ATTBE;
        this.ATTEN = ATTEN;
        this.AUKEY = AUKEY;
        this.CBDFK = CBDFK;
        this.ETTBE = ETTBE;
        this.ETTEN = ETTEN;
        this.INDNR = INDNR;
        this.LUPDN = LUPDN;
        this.LUPDT = LUPDT;
        this.LUPDV = LUPDV;
        this.LZUAU = LZUAU;
        this.MENGE = MENGE;
        this.STTBE = STTBE;
        this.STTEN = STTEN;
        this.UAKEY = UAKEY;
        this.UAPIR = UAPIR;
        this.UASAA = UASAA;
        this.UASAU = UASAU;
        this.XUA = XUA;
        this.ZINFO = ZINFO;
        this.DFKEY = DFKEY;
        this.ORTFR = ORTFR;
        this.ORTTO = ORTTO;
        this.UAART = UAART;
        this.UAREE = UAREE;
        this.FGKEY = FGKEY;
        this.UAABF = UAABF;
        this.REKEY = REKEY;
        this.SPREK = SPREK;
        this.ATT30 = ATT30;
        this.ATT50 = ATT50;
        this.ATT55 = ATT55;
        this.ATT60 = ATT60;
        this.ATT70 = ATT70;
        this.ATT75 = ATT75;
        this.ATTER = ATTER;
        this.UAAGE = UAAGE;
        this.EINHE = EINHE;
        this.ATT20 = ATT20;
        this.QKB = QKB;
        this.SAA20 = SAA20;
        this.SAAOF = SAAOF;
        this.SKA = SKA;
        this.STT20 = STT20;
        this.URK = URK;
        this.RELFK = RELFK;
        this.UAINF = UAINF;
        this.ETT30 = ETT30;
        this.UAKSL = UAKSL;
        this.SPKEY = SPKEY;
        this.MENG2 = MENG2;
        this.CINFO = CINFO;
        this.ATT40 = ATT40;
        this.STLIK = STLIK;
        this.OKEYN = OKEYN;
        this.ABI = ABI;
        this.EBI = EBI;
        this.SBI = SBI;
        this.TOURK = TOURK;
        this.EINH2 = EINH2;
        this.EINH3 = EINH3;
        this.EINH4 = EINH4;
        this.MENG3 = MENG3;
        this.MENG4 = MENG4;
        this.XCABA = XCABA;
    }

    public Suborder() {

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

    public String getAUKEY() {
        return AUKEY;
    }

    public void setAUKEY(String AUKEY) {
        this.AUKEY = AUKEY;
    }

    public String getCBDFK() {
        return CBDFK;
    }

    public void setCBDFK(String CBDFK) {
        this.CBDFK = CBDFK;
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

    public String getINDNR() {
        return INDNR;
    }

    public void setINDNR(String INDNR) {
        this.INDNR = INDNR;
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

    public String getLZUAU() {
        return LZUAU;
    }

    public void setLZUAU(String LZUAU) {
        this.LZUAU = LZUAU;
    }

    public String getMENGE() {
        return MENGE;
    }

    public void setMENGE(String MENGE) {
        this.MENGE = MENGE;
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

    public String getUAKEY() {
        return UAKEY;
    }

    public void setUAKEY(String UAKEY) {
        this.UAKEY = UAKEY;
    }

    public String getUAPIR() {
        return UAPIR;
    }

    public void setUAPIR(String UAPIR) {
        this.UAPIR = UAPIR;
    }

    public String getUASAA() {
        return UASAA;
    }

    public void setUASAA(String UASAA) {
        this.UASAA = UASAA;
    }

    public String getUASAU() {
        return UASAU;
    }

    public void setUASAU(String UASAU) {
        this.UASAU = UASAU;
    }

    public String getXUA() {
        return XUA;
    }

    public void setXUA(String XUA) {
        this.XUA = XUA;
    }

    public String getZINFO() {
        return ZINFO;
    }

    public void setZINFO(String ZINFO) {
        this.ZINFO = ZINFO;
    }

    public String getDFKEY() {
        return DFKEY;
    }

    public void setDFKEY(String DFKEY) {
        this.DFKEY = DFKEY;
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

    public String getUAART() {
        return UAART;
    }

    public void setUAART(String UAART) {
        this.UAART = UAART;
    }

    public String getUAREE() {
        return UAREE;
    }

    public void setUAREE(String UAREE) {
        this.UAREE = UAREE;
    }

    public String getFGKEY() {
        return FGKEY;
    }

    public void setFGKEY(String FGKEY) {
        this.FGKEY = FGKEY;
    }

    public String getUAABF() {
        return UAABF;
    }

    public void setUAABF(String UAABF) {
        this.UAABF = UAABF;
    }

    public String getREKEY() {
        return REKEY;
    }

    public void setREKEY(String REKEY) {
        this.REKEY = REKEY;
    }

    public String getSPREK() {
        return SPREK;
    }

    public void setSPREK(String SPREK) {
        this.SPREK = SPREK;
    }

    public String getATT30() {
        return ATT30;
    }

    public void setATT30(String ATT30) {
        this.ATT30 = ATT30;
    }

    public String getATT50() {
        return ATT50;
    }

    public void setATT50(String ATT50) {
        this.ATT50 = ATT50;
    }

    public String getATT55() {
        return ATT55;
    }

    public void setATT55(String ATT55) {
        this.ATT55 = ATT55;
    }

    public String getATT60() {
        return ATT60;
    }

    public void setATT60(String ATT60) {
        this.ATT60 = ATT60;
    }

    public String getATT70() {
        return ATT70;
    }

    public void setATT70(String ATT70) {
        this.ATT70 = ATT70;
    }

    public String getATT75() {
        return ATT75;
    }

    public void setATT75(String ATT75) {
        this.ATT75 = ATT75;
    }

    public String getATTER() {
        return ATTER;
    }

    public void setATTER(String ATTER) {
        this.ATTER = ATTER;
    }

    public String getUAAGE() {
        return UAAGE;
    }

    public void setUAAGE(String UAAGE) {
        this.UAAGE = UAAGE;
    }

    public String getEINHE() {
        return EINHE;
    }

    public void setEINHE(String EINHE) {
        this.EINHE = EINHE;
    }

    public String getATT20() {
        return ATT20;
    }

    public void setATT20(String ATT20) {
        this.ATT20 = ATT20;
    }

    public String getQKB() {
        return QKB;
    }

    public void setQKB(String QKB) {
        this.QKB = QKB;
    }

    public String getSAA20() {
        return SAA20;
    }

    public void setSAA20(String SAA20) {
        this.SAA20 = SAA20;
    }

    public String getSAAOF() {
        return SAAOF;
    }

    public void setSAAOF(String SAAOF) {
        this.SAAOF = SAAOF;
    }

    public String getSKA() {
        return SKA;
    }

    public void setSKA(String SKA) {
        this.SKA = SKA;
    }

    public String getSTT20() {
        return STT20;
    }

    public void setSTT20(String STT20) {
        this.STT20 = STT20;
    }

    public String getURK() {
        return URK;
    }

    public void setURK(String URK) {
        this.URK = URK;
    }

    public String getRELFK() {
        return RELFK;
    }

    public void setRELFK(String RELFK) {
        this.RELFK = RELFK;
    }

    public String getUAINF() {
        return UAINF;
    }

    public void setUAINF(String UAINF) {
        this.UAINF = UAINF;
    }

    public String getETT30() {
        return ETT30;
    }

    public void setETT30(String ETT30) {
        this.ETT30 = ETT30;
    }

    public String getUAKSL() {
        return UAKSL;
    }

    public void setUAKSL(String UAKSL) {
        this.UAKSL = UAKSL;
    }

    public String getSPKEY() {
        return SPKEY;
    }

    public void setSPKEY(String SPKEY) {
        this.SPKEY = SPKEY;
    }

    public String getMENG2() {
        return MENG2;
    }

    public void setMENG2(String MENG2) {
        this.MENG2 = MENG2;
    }

    public String getCINFO() {
        return CINFO;
    }

    public void setCINFO(String CINFO) {
        this.CINFO = CINFO;
    }

    public String getATT40() {
        return ATT40;
    }

    public void setATT40(String ATT40) {
        this.ATT40 = ATT40;
    }

    public String getSTLIK() {
        return STLIK;
    }

    public void setSTLIK(String STLIK) {
        this.STLIK = STLIK;
    }

    public String getOKEYN() {
        return OKEYN;
    }

    public void setOKEYN(String OKEYN) {
        this.OKEYN = OKEYN;
    }

    public String getABI() {
        return ABI;
    }

    public void setABI(String ABI) {
        this.ABI = ABI;
    }

    public String getEBI() {
        return EBI;
    }

    public void setEBI(String EBI) {
        this.EBI = EBI;
    }

    public String getSBI() {
        return SBI;
    }

    public void setSBI(String SBI) {
        this.SBI = SBI;
    }

    public String getTOURK() {
        return TOURK;
    }

    public void setTOURK(String TOURK) {
        this.TOURK = TOURK;
    }

    public String getEINH2() {
        return EINH2;
    }

    public void setEINH2(String EINH2) {
        this.EINH2 = EINH2;
    }

    public String getEINH3() {
        return EINH3;
    }

    public void setEINH3(String EINH3) {
        this.EINH3 = EINH3;
    }

    public String getEINH4() {
        return EINH4;
    }

    public void setEINH4(String EINH4) {
        this.EINH4 = EINH4;
    }

    public String getMENG3() {
        return MENG3;
    }

    public void setMENG3(String MENG3) {
        this.MENG3 = MENG3;
    }

    public String getMENG4() {
        return MENG4;
    }

    public void setMENG4(String MENG4) {
        this.MENG4 = MENG4;
    }

    public String getXCABA() {
        return XCABA;
    }

    public void setXCABA(String XCABA) {
        this.XCABA = XCABA;
    }


    /**
     * Retrieves a list of CSV rows representing the attributes of the current object.
     *
     * @return ArrayList of CSV rows containing attribute names and corresponding values.
     */
    public ArrayList<CSVRow> getCSVRows() {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<CSVRow> rows = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(this);
                String valueString = (value != null) ? value.toString() : "";

                if ("csvRows".equals(field.getName()) || "changes".equals(field.getName()) || "lastChange".equals(field.getName()) || "creationDate".equals(field.getName())) {
                    continue;
                }

                CSVRow row = new CSVRow(field.getName(), valueString);

                if (!row.getValue().isEmpty() &&
                        !row.getValue().contains(";"))
                    rows.add(row);

            } catch (IllegalAccessException e) {
                ErrorDialog dialog = new ErrorDialog("Internal error. Restart the programm.");
            }
        }

        return rows;
    }

    ArrayList<CSVRow> csvRows = new ArrayList<>();

    public void setRows(ArrayList<CSVRow> rows) {
        this.csvRows = rows;
    }


}