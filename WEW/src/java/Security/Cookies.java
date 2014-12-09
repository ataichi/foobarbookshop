package Security;

import java.util.Hashtable;
import javax.servlet.http.Cookie;

public class Cookies {

    public Hashtable cookieTable(Cookie[] cookies) {
        Hashtable cookieTable = new Hashtable();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookieTable.put(cookies[i].getName(), cookies[i]);
            }
        }
        return cookieTable;
    }
}
