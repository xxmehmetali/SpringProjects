package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner {

//    this is a way of injecting cat object. But we generally make fields final. So it would cause problem.
//    @Autowired
//    private Cat cat;

//    fix of the problem is following as in constructor:
    private final Cat cat;

    //putting a constructor will solve the problem.
    @Autowired
    public Owner(final Cat cat){
        this.cat = cat;
    }

    //Qualifier and Autowired needed together to inject bean.
    @Qualifier("dogAlice")
    @Autowired
    private Dog dog;

//------------------------------------


    public Cat getCat() {
        return cat;
    }

//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }


    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
