
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Base64;

public class TripleDES_backend
{
    private SecretKey myDesKey1,myDesKey2,myDesKey3;
    private byte[] textEncrypted3;

    public void encrypt(String user_text) {

		try{
			//for Key 1
		    KeyGenerator keygenerator1 = KeyGenerator.getInstance("DES");
		    myDesKey1 = keygenerator1.generateKey();

		    //For Key 2
		    KeyGenerator keygenerator2 = KeyGenerator.getInstance("DES");
			myDesKey2 = keygenerator2.generateKey();

		    //For Key 3
		    KeyGenerator keygenerator3 = KeyGenerator.getInstance("DES");
			myDesKey3 = keygenerator3.generateKey();

			// get base64 encoded version of the key
			String encodedKey2 = Base64.getEncoder().encodeToString(myDesKey2.getEncoded());
			String encodedKey3 = Base64.getEncoder().encodeToString(myDesKey3.getEncoded());

			// Create the cipher
		    Cipher desCipher1 = Cipher.getInstance("DES/ECB/PKCS5Padding");

			//text to be input by user
		    byte[] text = user_text.getBytes();


		    // Using triple DES algorithm
		    desCipher1.init(Cipher.ENCRYPT_MODE, myDesKey1);
			byte[] textEncrypted1 = desCipher1.doFinal(text);

			desCipher1.init(Cipher.ENCRYPT_MODE, myDesKey2);
		    byte[] textEncrypted2 = desCipher1.doFinal(textEncrypted1);

			String text3=new String(textEncrypted2);
		    desCipher1.init(Cipher.ENCRYPT_MODE, myDesKey3);
		    textEncrypted3 = desCipher1.doFinal(textEncrypted2);

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public String getKey1() {
	    return Base64.getEncoder().encodeToString(myDesKey1.getEncoded());
    }
    public String getKey2() {
        return Base64.getEncoder().encodeToString(myDesKey2.getEncoded());
    }
    public String getKey3() {
        return Base64.getEncoder().encodeToString(myDesKey3.getEncoded());
    }
    public String getCipherText() {
        return new String(textEncrypted3);
    }
    public void getCipherBtye() {
        try {
            FileOutputStream fos = new FileOutputStream("tripleDES_file.txt");
            fos.write(textEncrypted3);
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
