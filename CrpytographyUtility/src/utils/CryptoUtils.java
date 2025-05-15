package utils;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/*****************************************
 * @author - Md. Rashedul Ghani
 * @email - r23ghani@gmail.com
 * @date - 5/15/2025 at 12:12 PM
 ******************************************
 */

public class CryptoUtils {

    private static final String hmacKey = "A82679167E9FE12FF644B996CBCBF00173644";

    public static String generateHash(String data) {
        return calculateHmac(data, hmacKey);
    }

    private static String calculateHmac(String data, String hmacKey) {
        String hmacAlgorithm = "HmacSHA256";
        SecretKeySpec signingKey = new SecretKeySpec(hmacKey.getBytes(), hmacAlgorithm);
        try {
            Mac mac = Mac.getInstance(hmacAlgorithm);
            mac.init(signingKey);
            //return DatatypeConverter.printHexBinary(mac.doFinal(data.getBytes()));
            return HexFormat.of().formatHex(mac.doFinal(data.getBytes()));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            System.out.println("Failed to generate hmac={}"+ e.getMessage());
            throw new RuntimeException(e);
        }
    }
}