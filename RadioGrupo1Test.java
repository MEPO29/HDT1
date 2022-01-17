import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioGrupo1Test {
	

	@Test
	void testNextStation() {
		RadioGrupo1 radio = new RadioGrupo1();
		radio.nextStation(false);
		assertEquals(540, radio.getStation(), 0.001,"Error en NextStation AM");
		radio.setEstacion((double) 1610);
		radio.nextStation(false);
		assertEquals(530, radio.getStation(), 0.001,"Error en NextStation AM - Limite");
		
		
		radio.switchAMFM();
		radio.nextStation(false);
		assertEquals(88.1, radio.getStation(), 0.001,"Error en NextStation FM");
		radio.setEstacion((double) 107.9);
		radio.nextStation(false);
		assertEquals(87.9, radio.getStation(), 0.001,"Error en NextStation FM - Limite");
	}
	
	@Test
	void testPrevStation() {
		RadioGrupo1 radio = new RadioGrupo1();
		radio.prevStation(false);
		assertEquals(1610, radio.getStation(), 0.001,"Error en PrevStation AM - Limite");
		radio.setEstacion((double) 600);
		radio.prevStation(false);
		assertEquals(590, radio.getStation(), 0.001,"Error en PrevStation AM");
		
		radio.switchAMFM();
		radio.prevStation(false);
		assertEquals(107.9, radio.getStation(), 0.001,"Error en PrevStation FM - Limite");
		radio.setEstacion((double) 100.9);
		radio.prevStation(false);
		assertEquals(100.7, radio.getStation(), 0.001,"Error en PrevStation FM");
		
	}

}
