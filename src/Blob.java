import java.io.Serializable;

public class Blob extends Base implements Serializable {

    Blob(String source_code) {
        super(source_code);
    }
    Blob(String source_code,String address) {
        super(source_code,address);
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
