package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean2 {
    private String text;


    /**
     * @PostConstruct is related to the spring. If you try to create an instance of Bean2 init method will not run.
     * Bean2 b = new Bean2;
     * System.out.println(b.getText()) -->> null
     */
    @PostConstruct
    private void init(){
        this.text = "Bean2 is set via @PostConstruct";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
