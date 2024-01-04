package com.example.fluganzeigetafel.Contract;


import com.example.fluganzeigetafel.Contract.Subcontracts.Subcontract;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Contract {
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

    private ArrayList<Subcontract> subcontractList = new ArrayList<>();


    public void setAUKEY(String AUKEY) {
        this.AUKEY = AUKEY;
    }



    public Contract(String AUKEY) {
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

    public Contract() {
        this.rows = new ArrayList<>();
    }


    public Contract(String ATTBE, String ATTEN, String AUAGE, String AUKEY, String AUKNL, String AUKNS, String AUPIR,
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

    private ArrayList<CSVRow> rows;

    public static ArrayList<CSVRow> generateListOfCSVRows(Contract contract) {

            Class<?> clazz = contract.getClass();
            Field[] fields = clazz.getDeclaredFields();
            ArrayList<CSVRow> rows = new ArrayList<>();

            for (Field field : fields) {
                field.setAccessible(true);

                try {

                    if (field.get(contract) != null && !field.get(contract).toString().isEmpty()) {
                        CSVRow row = new CSVRow(field.getName(), field.get(contract).toString());


                        if (!row.getValue().isEmpty() && !row.getValue().contains(";")&& !row.getValue().contains("["))
                        rows.add(row);
                    }


                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }


            return rows;


    }

        public ArrayList<CSVRow> getCSVRows() {
            return rows;
        }


        public ArrayList<Subcontract> getSubContractsList () {
            return this.subcontractList;
        }

        public void deleteSubContract(String uakey) {
        for (Subcontract subcontract : getSubContractsList()) {

            if (subcontract.getUAKEY().trim().equals(uakey.trim())) {

                this.subcontractList.remove(subcontract);
                return;
            }
        }
        }

        public void addSubContractToSubContractList (Subcontract subcontract){
            this.subcontractList.add(subcontract);
        }

    public Subcontract getSubContractByUAKEY(String uakey) {
        for (Subcontract subcontract : this.getSubContractsList()) {
            if (subcontract.getUAKEY().trim().equals(uakey))
                return  subcontract;
        }
        return null;
    }
    }

