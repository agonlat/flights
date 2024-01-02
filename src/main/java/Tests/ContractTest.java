package Tests;

import com.example.fluganzeigetafel.Contract.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContractTest {
    @Test
    public void testGettersAndSetters() {
        // Create a Contract instance
        Contract contract = new Contract();

        // Test getters and setters for AUKEY
        contract.setAUKEY("AUKEY123");
        Assertions.assertEquals("AUKEY123", contract.getAUKEY());

        // Test getters and setters for DISPO
        contract.setDISPO("DISPO456");
        Assertions.assertEquals("DISPO456", contract.getDISPO());

        // Test getters and setters for DIB
        contract.setDIB("DIB789");
        Assertions.assertEquals("DIB789", contract.getDIB());

        // Test getters and setters for JTP
        contract.setJTP("JTPABC");
        Assertions.assertEquals("JTPABC", contract.getJTP());

        // Test getters and setters for AUSAA
        contract.setAUSAA("AUSAA123");
        Assertions.assertEquals("AUSAA123", contract.getAUSAA());

        // Test getters and setters for AUSAU
        contract.setAUSAU("AUSAU456");
        Assertions.assertEquals("AUSAU456", contract.getAUSAU());

        // Test getters and setters for AUKNL
        contract.setAUKNL("AUKNL789");
        Assertions.assertEquals("AUKNL789", contract.getAUKNL());

        // Test getters and setters for AUKNS
        contract.setAUKNS("AUKNSABC");
        Assertions.assertEquals("AUKNSABC", contract.getAUKNS());

        // Test getters and setters for FGKEY
        contract.setFGKEY("FGKEY123");
        Assertions.assertEquals("FGKEY123", contract.getFGKEY());

        // Test getters and setters for PLKEY
        contract.setPLKEY("PLKEY456");
        Assertions.assertEquals("PLKEY456", contract.getPLKEY());

        // Test getters and setters for ORTFR
        contract.setORTFR("ORTFR789");
        Assertions.assertEquals("ORTFR789", contract.getORTFR());

        // Test getters and setters for ORTTO
        contract.setORTTO("ORTTOABC");
        Assertions.assertEquals("ORTTOABC", contract.getORTTO());

        // Test getters and setters for MENGE
        contract.setMENGE("MENGE123");
        Assertions.assertEquals("MENGE123", contract.getMENGE());

        // Test getters and setters for EINHE
        contract.setEINHE("EINHE456");
        Assertions.assertEquals("EINHE456", contract.getEINHE());

        // Test getters and setters for MENG2
        contract.setMENG2("MENG2123");
        Assertions.assertEquals("MENG2123", contract.getMENG2());

        // Test getters and setters for EINH2
        contract.setEINH2("EINH2456");
        Assertions.assertEquals("EINH2456", contract.getEINH2());

        // Test getters and setters for MENG3
        contract.setMENG3("MENG3789");
        Assertions.assertEquals("MENG3789", contract.getMENG3());

        // Test getters and setters for EINH3
        contract.setEINH3("EINH3ABC");
        Assertions.assertEquals("EINH3ABC", contract.getEINH3());

        // Test getters and setters for MENG4
        contract.setMENG4("MENG4123");
        Assertions.assertEquals("MENG4123", contract.getMENG4());

        // Test getters and setters for EINH4
        contract.setEINH4("EINH4456");
        Assertions.assertEquals("EINH4456", contract.getEINH4());

        // Test getters and setters for UAZPL
        contract.setUAZPL("UAZPL789");
        Assertions.assertEquals("UAZPL789", contract.getUAZPL());

        // Test getters and setters for UAZAK
        contract.setUAZAK("UAZAKABC");
        Assertions.assertEquals("UAZAKABC", contract.getUAZAK());

        // Test getters and setters for AUAGE
        contract.setAUAGE("AUAGE123");
        Assertions.assertEquals("AUAGE123", contract.getAUAGE());

        // Test getters and setters for STTBE
        contract.setSTTBE("STTBE456");
        Assertions.assertEquals("STTBE456", contract.getSTTBE());

        // Test getters and setters for STTEN
        contract.setSTTEN("STTEN789");
        Assertions.assertEquals("STTEN789", contract.getSTTEN());

        // Test getters and setters for ETTBE
        contract.setETTBE("ETTBEABC");
        Assertions.assertEquals("ETTBEABC", contract.getETTBE());

        // Test getters and setters for ETTEN
        contract.setETTEN("ETTEN123");
        Assertions.assertEquals("ETTEN123", contract.getETTEN());

        // Test getters and setters for ATTBE
        contract.setATTBE("ATTBE456");
        Assertions.assertEquals("ATTBE456", contract.getATTBE());

        // Test getters and setters for ATTEN
        contract.setATTEN("ATTEN789");
        Assertions.assertEquals("ATTEN789", contract.getATTEN());

        // Test getters and setters for ATT20
        contract.setATT20("ATT20123");
        Assertions.assertEquals("ATT20123", contract.getATT20());

        // Test getters and setters for AUPIR
        contract.setAUPIR("AUPIR456");
        Assertions.assertEquals("AUPIR456", contract.getAUPIR());

        // Test getters and setters for ZINFO
        contract.setZINFO("ZINFO789");
        Assertions.assertEquals("ZINFO789", contract.getZINFO());

        // Test getters and setters for LUPDN
        contract.setLUPDN("LUPDNABC");
        Assertions.assertEquals("LUPDNABC", contract.getLUPDN());

        // Test getters and setters for LUPDT
        contract.setLUPDT("LUPDT123");
        Assertions.assertEquals("LUPDT123", contract.getLUPDT());

        // Test getters and setters for LUPDV
        contract.setLUPDV("LUPDV456");
        Assertions.assertEquals("LUPDV456", contract.getLUPDV());

        // Test getters and setters for KEYLK
        contract.setKEYLK("KEYLK789");
        Assertions.assertEquals("KEYLK789", contract.getKEYLK());

        // Test getters and setters for KEYLE
        contract.setKEYLE("KEYLEABC");
        Assertions.assertEquals("KEYLEABC", contract.getKEYLE());

        // Test getters and setters for KEYLF
        contract.setKEYLF("KEYLF123");
        Assertions.assertEquals("KEYLF123", contract.getKEYLF());

        // Test getters and setters for XAU
        contract.setXAU("XAU456");
        Assertions.assertEquals("XAU456", contract.getXAU());

        // Test getters and setters for AUDAT
        contract.setAUDAT("AUDAT789");
        Assertions.assertEquals("AUDAT789", contract.getAUDAT());

        // Test getters and setters for AUABF
        contract.setAUABF("AUABFABC");
        Assertions.assertEquals("AUABFABC", contract.getAUABF());

        // Test getters and setters for MITAR
        contract.setMITAR("MITAR123");
        Assertions.assertEquals("MITAR123", contract.getMITAR());

        // Test getters and setters for FDAEN
        contract.setFDAEN("FDAEN456");
        Assertions.assertEquals("FDAEN456", contract.getFDAEN());

        // Test getters and setters for FLAGS
        contract.setFLAGS("FLAGS789");
        Assertions.assertEquals("FLAGS789", contract.getFLAGS());

        // Test getters and setters for CINFO
        contract.setCINFO("CINFOABC");
        Assertions.assertEquals("CINFOABC", contract.getCINFO());

        // Test getters and setters for MAD
        contract.setMAD("MAD123");
        Assertions.assertEquals("MAD123", contract.getMAD());

        // Test getters and setters for STLIK
        contract.setSTLIK("STLIK456");
        Assertions.assertEquals("STLIK456", contract.getSTLIK());

        // Test getters and setters for PKART
        contract.setPKART("PKART789");
        Assertions.assertEquals("PKART789", contract.getPKART());

        // Test getters and setters for PKL
        contract.setPKL("PKLABC");
        Assertions.assertEquals("PKLABC", contract.getPKL());

        // Test getters and setters for PKLAS
        contract.setPKLAS("PKLAS123");
        Assertions.assertEquals("PKLAS123", contract.getPKLAS());

        // Test getters and setters for PKLEA
        contract.setPKLEA("PKLEA456");
        Assertions.assertEquals("PKLEA456", contract.getPKLEA());

        // Test getters and setters for PKNAM
        contract.setPKNAM("PKNAM789");
        Assertions.assertEquals("PKNAM789", contract.getPKNAM());

        // Test getters and setters for FELFK
        contract.setFELFK("FELFKABC");
        Assertions.assertEquals("FELFKABC", contract.getFELFK());
    }
}

