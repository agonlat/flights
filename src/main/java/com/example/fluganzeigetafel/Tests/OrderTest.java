package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Orders.Order;
import org.junit.Test;
import org.junit.*;

public class OrderTest {
    @Test
    public void testGettersAndSetters() {
        // Create a Contract instance
        Order order = new Order();

        // Test getters and setters for AUKEY
        order.setAUKEY("AUKEY123");
        Assert.assertEquals("AUKEY123", order.getAUKEY());

        // Test getters and setters for DISPO
        order.setDISPO("DISPO456");
        Assert.assertEquals("DISPO456", order.getDISPO());

        // Test getters and setters for DIB
        order.setDIB("DIB789");
        Assert.assertEquals("DIB789", order.getDIB());

        // Test getters and setters for JTP
        order.setJTP("JTPABC");
        Assert.assertEquals("JTPABC", order.getJTP());

        // Test getters and setters for AUSAA
        order.setAUSAA("AUSAA123");
        Assert.assertEquals("AUSAA123", order.getAUSAA());

        // Test getters and setters for AUSAU
        order.setAUSAU("AUSAU456");
        Assert.assertEquals("AUSAU456", order.getAUSAU());

        // Test getters and setters for AUKNL
        order.setAUKNL("AUKNL789");
        Assert.assertEquals("AUKNL789", order.getAUKNL());

        // Test getters and setters for AUKNS
        order.setAUKNS("AUKNSABC");
        Assert.assertEquals("AUKNSABC", order.getAUKNS());

        // Test getters and setters for FGKEY
        order.setFGKEY("FGKEY123");
        Assert.assertEquals("FGKEY123", order.getFGKEY());

        // Test getters and setters for PLKEY
        order.setPLKEY("PLKEY456");
        Assert.assertEquals("PLKEY456", order.getPLKEY());

        // Test getters and setters for ORTFR
        order.setORTFR("ORTFR789");
        Assert.assertEquals("ORTFR789", order.getORTFR());

        // Test getters and setters for ORTTO
        order.setORTTO("ORTTOABC");
        Assert.assertEquals("ORTTOABC", order.getORTTO());

        // Test getters and setters for MENGE
        order.setMENGE("MENGE123");
        Assert.assertEquals("MENGE123", order.getMENGE());

        // Test getters and setters for EINHE
        order.setEINHE("EINHE456");
        Assert.assertEquals("EINHE456", order.getEINHE());

        // Test getters and setters for MENG2
        order.setMENG2("MENG2123");
        Assert.assertEquals("MENG2123", order.getMENG2());

        // Test getters and setters for EINH2
        order.setEINH2("EINH2456");
        Assert.assertEquals("EINH2456", order.getEINH2());

        // Test getters and setters for MENG3
        order.setMENG3("MENG3789");
        Assert.assertEquals("MENG3789", order.getMENG3());

        // Test getters and setters for EINH3
        order.setEINH3("EINH3ABC");
        Assert.assertEquals("EINH3ABC", order.getEINH3());

        // Test getters and setters for MENG4
        order.setMENG4("MENG4123");
        Assert.assertEquals("MENG4123", order.getMENG4());

        // Test getters and setters for EINH4
        order.setEINH4("EINH4456");
        Assert.assertEquals("EINH4456", order.getEINH4());

        // Test getters and setters for UAZPL
        order.setUAZPL("UAZPL789");
        Assert.assertEquals("UAZPL789", order.getUAZPL());

        // Test getters and setters for UAZAK
        order.setUAZAK("UAZAKABC");
        Assert.assertEquals("UAZAKABC", order.getUAZAK());

        // Test getters and setters for AUAGE
        order.setAUAGE("AUAGE123");
        Assert.assertEquals("AUAGE123", order.getAUAGE());

        // Test getters and setters for STTBE
        order.setSTTBE("STTBE456");
        Assert.assertEquals("STTBE456", order.getSTTBE());

        // Test getters and setters for STTEN
        order.setSTTEN("STTEN789");
        Assert.assertEquals("STTEN789", order.getSTTEN());

        // Test getters and setters for ETTBE
        order.setETTBE("ETTBEABC");
        Assert.assertEquals("ETTBEABC", order.getETTBE());

        // Test getters and setters for ETTEN
        order.setETTEN("ETTEN123");
        Assert.assertEquals("ETTEN123", order.getETTEN());

        // Test getters and setters for ATTBE
        order.setATTBE("ATTBE456");
        Assert.assertEquals("ATTBE456", order.getATTBE());

        // Test getters and setters for ATTEN
        order.setATTEN("ATTEN789");
        Assert.assertEquals("ATTEN789", order.getATTEN());

        // Test getters and setters for ATT20
        order.setATT20("ATT20123");
        Assert.assertEquals("ATT20123", order.getATT20());

        // Test getters and setters for AUPIR
        order.setAUPIR("AUPIR456");
        Assert.assertEquals("AUPIR456", order.getAUPIR());

        // Test getters and setters for ZINFO
        order.setZINFO("ZINFO789");
        Assert.assertEquals("ZINFO789", order.getZINFO());

        // Test getters and setters for LUPDN
        order.setLUPDN("LUPDNABC");
        Assert.assertEquals("LUPDNABC", order.getLUPDN());

        // Test getters and setters for LUPDT
        order.setLUPDT("LUPDT123");
        Assert.assertEquals("LUPDT123", order.getLUPDT());

        // Test getters and setters for LUPDV
        order.setLUPDV("LUPDV456");
        Assert.assertEquals("LUPDV456", order.getLUPDV());

        // Test getters and setters for KEYLK
        order.setKEYLK("KEYLK789");
        Assert.assertEquals("KEYLK789", order.getKEYLK());

        // Test getters and setters for KEYLE
        order.setKEYLE("KEYLEABC");
        Assert.assertEquals("KEYLEABC", order.getKEYLE());

        // Test getters and setters for KEYLF
        order.setKEYLF("KEYLF123");
        Assert.assertEquals("KEYLF123", order.getKEYLF());

        // Test getters and setters for XAU
        order.setXAU("XAU456");
        Assert.assertEquals("XAU456", order.getXAU());

        // Test getters and setters for AUDAT
        order.setAUDAT("AUDAT789");
        Assert.assertEquals("AUDAT789", order.getAUDAT());

        // Test getters and setters for AUABF
        order.setAUABF("AUABFABC");
        Assert.assertEquals("AUABFABC", order.getAUABF());

        // Test getters and setters for MITAR
        order.setMITAR("MITAR123");
        Assert.assertEquals("MITAR123", order.getMITAR());

        // Test getters and setters for FDAEN
        order.setFDAEN("FDAEN456");
        Assert.assertEquals("FDAEN456", order.getFDAEN());

        // Test getters and setters for FLAGS
        order.setFLAGS("FLAGS789");
        Assert.assertEquals("FLAGS789", order.getFLAGS());

        // Test getters and setters for CINFO
        order.setCINFO("CINFOABC");
        Assert.assertEquals("CINFOABC", order.getCINFO());

        // Test getters and setters for MAD
        order.setMAD("MAD123");
        Assert.assertEquals("MAD123", order.getMAD());

        // Test getters and setters for STLIK
        order.setSTLIK("STLIK456");
        Assert.assertEquals("STLIK456", order.getSTLIK());

        // Test getters and setters for PKART
        order.setPKART("PKART789");
        Assert.assertEquals("PKART789", order.getPKART());

        // Test getters and setters for PKL
        order.setPKL("PKLABC");
        Assert.assertEquals("PKLABC", order.getPKL());

        // Test getters and setters for PKLAS
        order.setPKLAS("PKLAS123");
        Assert.assertEquals("PKLAS123", order.getPKLAS());

        // Test getters and setters for PKLEA
        order.setPKLEA("PKLEA456");
        Assert.assertEquals("PKLEA456", order.getPKLEA());

        // Test getters and setters for PKNAM
        order.setPKNAM("PKNAM789");
        Assert.assertEquals("PKNAM789", order.getPKNAM());

        // Test getters and setters for FELFK
        order.setFELFK("FELFKABC");
        Assert.assertEquals("FELFKABC", order.getFELFK());
    }
}

