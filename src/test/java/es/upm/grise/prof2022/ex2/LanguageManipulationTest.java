package es.upm.grise.prof2022.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.imageio.stream.IIOByteBuffer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageManipulationTest {

	@Test
	public void testCaminoCatch() throws Exception{
		Colaborator c = mock(Colaborator.class);
		LanguageManipulation lm = new LanguageManipulation(c);

		doThrow(new CannotFindPropertyFileOrWrongFileException()).when(c).load("Italian-strings.properties");
		assertThrows(CannotFindPropertyFileOrWrongFileException.class, () -> lm.getText("key", Language.Italian));

		verify(c, times(1)).load("Italian-strings.properties");
	}

	@Test
	public void testCaminoPrimerIf() throws Exception{
		Colaborator c = mock(Colaborator.class);
		LanguageManipulation lm = new LanguageManipulation(c);

		when(c.getProperty("key")).thenReturn(null);
		assertThrows(NonExistingKeyException.class, () -> lm.getText("key", Language.English));
	}

	@Test
	public void testCaminoSegundoIf() throws Exception{
		Colaborator c = mock(Colaborator.class);
		LanguageManipulation lm = new LanguageManipulation(c);

		when(c.getProperty("key")).thenReturn(null);
		assertEquals("This Key does not exist or it has not been yet translated", lm.getText("key", Language.Spanish));
	}
}
