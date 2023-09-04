package beans;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class C {
    private String simpleText;

    public C(){
        this.simpleText = "simpleText";
    }

    public String getSimpleText() {
        return simpleText;
    }
}
