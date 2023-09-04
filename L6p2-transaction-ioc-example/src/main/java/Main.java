import beans.A;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            A a = context.getBean(A.class);
            a.m1();
        }

        /**
            OUTPUT OF THE APPLICATION:
                 class beans.B$$EnhancerBySpringCGLIB$$fa1442a7
                 class beans.A
                 class beans.A$$EnhancerBySpringCGLIB$$e678ba04

         */
    }
}
