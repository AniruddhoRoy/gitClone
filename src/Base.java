
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
abstract class Base {
    private final int MaxStringLen = 40;
    private String orginal_string, hash;
    protected String address="";

    Base(String source_code) {
        orginal_string = source_code;
        hash = Crypto.calculateHash(address+source_code);
    }

    Base(String source_code, String address) {
        orginal_string = source_code;
        this.address = address;
        hash = Crypto.calculateHash(address+source_code);
    }



    String getHash() {
        return hash;
    }
    String trancOrginalString(){
        if (orginal_string.length() > MaxStringLen) {
            return orginal_string.substring(0, MaxStringLen) + "...";
        } else {
            return orginal_string;
        }
    }

    public abstract String toString();
}