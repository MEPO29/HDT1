import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioGrupo1Test {
	

	/**
	 * Evalua el método nextStation
	 */
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
	
	/**
	 * Evalua el método prevStation
	 */
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
	/**
	 * Evalua el método SaveStation y getSavedStation
	 */
	@Test
	void testSave_GetSavedStation() {
		RadioGrupo1 radio = new RadioGrupo1();
		radio.saveStation(1, 88.1);
		double estacion = radio.getSavedStation(1);
		assertEquals(88.1, estacion, 0.001, "No se guardo la estación");
		assertEquals(88.1, radio.getStation(), 0.001, "No se cambio a la estación");
		assertEquals(false, radio.getFrequency(), "No se cambio a FM luego de acceder a la estación guardada");
		
		radio.saveStation(3, 550);
		estacion = radio.getSavedStation(3);
		assertEquals(550, estacion, 0.001, "No se guardo la estación");
		assertEquals(550, radio.getStation(), 0.001, "No se cambio a la estación");
		assertEquals(true, radio.getFrequency(), "No se cambio a AM luego de acceder a la estación guardada");
		
		try {
			radio.saveStation(20, 0);
			fail("No tiró excepción al intentar acceder a índice fuera de rango");
		} catch (Exception e) {}
		
		
	}

}
