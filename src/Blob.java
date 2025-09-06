import java.io.Serializable;

public class Blob implements Serializable {
    private final int MaxStringLen = 40;
    private String orginal_string, hash;
    protected String address="";
    Blob(){

    }

    Blob(String source_code) {
        this.orginal_string = source_code;
        hash = Crypto.calculateHash(address+source_code);
    }
    Blob(String source_code,String address) {
        this.orginal_string = source_code;
        this.address = address;
        hash = Crypto.calculateHash(address+source_code);
    }
    String getHash() {
        return hash;
    }
    String getOrginal_string(){
        return orginal_string;
    }
    String trancOrginalString(){
        if (orginal_string.length() > MaxStringLen) {
            return orginal_string.substring(0, MaxStringLen) + "...";
        } else {
            return orginal_string;
        }
    }

    @Override
    public String toString() {
        String s = String.format("""
                ======================================================
                orginal String:%s
                hash :%s
                address:%s
                ======================================================
                """,trancOrginalString(),this.getHash(),address) ;
        return s;
    }
}
