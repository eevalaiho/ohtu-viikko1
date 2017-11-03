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
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
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
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }


    @Test
    public void ottaminenTesti1() {

    	// varastossa pitäisi olla tilaa 10 - 12 = -2
        assertEquals(0.0, varasto.otaVarastosta(-10), vertailuTarkkuus);
    }
    

    @Test
    public void lisaaTesti1() {

    	double saldo = varasto.getSaldo();
    	varasto.lisaaVarastoon(-10);
    	
    	// varastossa pitäisi olla tilaa 10 - 12 = -2
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaaTesti2() {

    	
    	double value = varasto.getSaldo() + varasto.paljonkoMahtuu();
    	varasto.lisaaVarastoon(varasto.paljonkoMahtuu() + 1);
    	
    	// varastossa pitäisi olla tilaa 10 - 12 = -2
        assertEquals(value, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    //return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    @Test
    public void toStringTesti1() {
    	
    	varasto.lisaaVarastoon(5);
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto.toString());
    }
    
    @Test
    public void konstruktoriTesti1() {
    	
    	//public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
    	Varasto tmp = new Varasto(-1,5);
    	
        assertEquals(0.0,tmp.getTilavuus(),vertailuTarkkuus);
    }   
    
    @Test
    public void konstruktoriTesti2() {
    	
    	//public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
    	Varasto tmp = new Varasto(5,-1);
    	
        assertEquals(0.0,tmp.getSaldo(),vertailuTarkkuus);
    } 
    

    @Test
    public void konstruktoriTesti3() {
    	
    	//public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
    	Varasto tmp = new Varasto(5,2);
    	
        assertEquals(5.0,tmp.getTilavuus(),vertailuTarkkuus);
        assertEquals(2.0,tmp.getSaldo(),vertailuTarkkuus);
       
    } 


    @Test
    public void konstruktoriTesti4() {
    	
    	//public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
    	Varasto tmp = new Varasto(5,2);
    	
        assertEquals(5.0,tmp.getTilavuus(),vertailuTarkkuus);
        assertEquals(2.0,tmp.getSaldo(),vertailuTarkkuus);
       
    } 
    
    
}