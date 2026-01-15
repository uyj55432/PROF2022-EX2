package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {
	
	@Test
	public void testCaminoCatch() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("key", Language.Italian));
	}

	@Test
	public void testCaminoPrimerIf() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		assertThrows(NonExistingKeyException.class, () -> lm.getText("key", Language.English));
	}

	@Test
	public void testCaminoSegundoIf() throws Exception{
		LanguageManipulation lm = new LanguageManipulation();
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("key", Language.Spanish));
	}
}
