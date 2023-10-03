package pr31;

import java_pro_homeworks.pr31.Encryptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptorTest {

    @Test
    public void encryptOneWordTest() {
        assertEquals("72olle", Encryptor.encryptWord("Hello"));
        assertEquals("103doo", Encryptor.encryptWord("good"));
        assertEquals("119drlo", Encryptor.encryptWord("world"));
    }

    @Test
    public void encryptEachWordTest() {
        assertEquals("104olle 103doo 119drlo", Encryptor.encryptEachWord("hello good world"));
        assertEquals("", Encryptor.encryptEachWord(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", Encryptor.encryptEachWord("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", Encryptor.encryptEachWord("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", Encryptor.encryptEachWord("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", Encryptor.encryptEachWord("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", Encryptor.encryptEachWord("Thank you Piotr for all your help"));
    }
}
