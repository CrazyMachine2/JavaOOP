package militaryelite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Corps {
    private static final List<String> VALID_CORPS = new ArrayList<>(Arrays.asList("Airforces", "Marines"));
    private String corpName;

    public Corps(String corpName) {
        this.setCorpName(corpName);
    }

    private void setCorpName(String corpName) {
        if(!Corps.VALID_CORPS.contains(corpName)){
            throw new IllegalArgumentException();
        }
        this.corpName = corpName;
    }

    public String getCorpName() {
        return this.corpName;
    }
}
