import utils.CryptoUtils;

public class Main {
    public static void main(String[] args) {

        System.out.println("###################### Testing signature with Hmac ####################");
        String data = "Hello World!";
        String hmac = CryptoUtils.generateHash(data);
        System.out.println("Data:" + data + "\nGenerated Signature: "+ hmac);
    }
}