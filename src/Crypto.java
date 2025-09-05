import java.security.MessageDigest;

public class Crypto {
    static String calculateHash(String source) {
        String hash="";
        try {
            // Get SHA-1 digest instance
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Compute hash
            byte[] hashBytes = md.digest((source).getBytes());

            // Convert bytes to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            hash = sb.toString();

        } catch (Exception e) {
            System.out.println("Error in Crypto Hash Function");
        }
        return  hash;
    }
}
