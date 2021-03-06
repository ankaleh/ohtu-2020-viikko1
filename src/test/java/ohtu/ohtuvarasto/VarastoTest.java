package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastoYritetaanLuodaNegatiivisellaTilavuudella() {
        Varasto varasto1 = new Varasto(-10);
        assertEquals(0, varasto1.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto1.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktorillaKaksiParametriaToimii() {
        Varasto varasto1 = new Varasto(20, 10);
        Varasto varasto2 = new Varasto(0, -10);
        Varasto varasto3 = new Varasto(10, 20);
        assertEquals(10, varasto1.getSaldo(), vertailuTarkkuus);
        assertEquals(20, varasto1.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
        assertEquals(10, varasto3.getTilavuus(), vertailuTarkkuus);
        assertEquals(10, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
        // saldon pitäisi olla sama kun lisätty määrä
    }

    @Test
    public void negatiivinenLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(-8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        // saldon pitäisi olla sama kun lisätty määrä
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);

    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void negatiivinenOttaminenEiMuutaSaldoa() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(-2);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void varastoonYritetaanLaittaaLiikaaTavaraa() {
	varasto.lisaaVarastoon(15);

    assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void varastostaYritetaanOttaaEnemmanKuinSiellaOn() {
	varasto.lisaaVarastoon(5);

	double saatuMaara = varasto.otaVarastosta(10);

	assertEquals(5, saatuMaara, vertailuTarkkuus);

    }

    @Test
    public void toStringPalauttaaOikeanTekstin() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }

}
