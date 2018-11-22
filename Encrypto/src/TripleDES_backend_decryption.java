
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class TripleDES_backend_decryption
{
	SecretKey deskey1,deskey2,deskey3;
	private byte[] textDecrypted1;


	TripleDES_backend_decryption(String key1,String key2,String key3)
	{
		byte[] decodedKey1 = Base64.getDecoder().decode(key1);
		// rebuild key using SecretKeySpec
		deskey1 = new SecretKeySpec(decodedKey1, 0, decodedKey1.length, "DES");

		byte[] decodedKey2 = Base64.getDecoder().decode(key2);
		// rebuild key using SecretKeySpec
		deskey2 = new SecretKeySpec(decodedKey2, 0, decodedKey2.length, "DES");

		byte[] decodedKey3 = Base64.getDecoder().decode(key3);
		// rebuild key using SecretKeySpec
		deskey3 = new SecretKeySpec(decodedKey3, 0, decodedKey3.length, "DES");

	}
	public void readCipher(String text) {
	    textDecrypted1=text.getBytes();
    }
	public void readData() {
        try {
            FileInputStream fin = new FileInputStream("tripleDES_file.txt");
            byte buff[]=new byte[56];

            fin.read(buff);
            textDecrypted1=buff;
            fin.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void decrypt()throws Exception {
		Cipher desCipher1=Cipher.getInstance("DES");
			System.out.println("Inside decryption method");

			//Decryption of text
			desCipher1.init(Cipher.DECRYPT_MODE, deskey3);
			byte[] textDecrypted3 = desCipher1.doFinal(textDecrypted1);

			desCipher1.init(Cipher.DECRYPT_MODE, deskey2);
			byte[] textDecrypted2 = desCipher1.doFinal(textDecrypted3);

			desCipher1.init(Cipher.DECRYPT_MODE, deskey1);
			textDecrypted1 = desCipher1.doFinal(textDecrypted2);

	}
	public String getPlainText() {

        return new String(textDecrypted1);

    }
}
