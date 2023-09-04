package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
//default propagation is Propagation.REQUIRED
//@Transactional(propagation = Propagation.REQUIRED)
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addTenProducts(){ /** CREATES A TRANSACTION*/
        for (int i=0; i<10; i++){
            productRepository.addProduct("Product"+String.valueOf(i+1));
            if (i==5) throw new RuntimeException(":(((((");
        }
    }/** COMMITS THE TRANSACTION (APPLIES ALL THE DB OPERATIONS IF ANY ERROR DOES NOT OCCURS) */

    @Transactional
    public void addTenProducts2(){ /** CREATES A TRANSACTION*/
        for (int i=0; i<10; i++){
            productRepository.addProduct2("Product"+String.valueOf(i+1));
            if (i==5) throw new RuntimeException(":(((((");
        }
    }/** COMMITS THE TRANSACTION (APPLIES ALL THE DB OPERATIONS IF ANY ERROR DOES NOT OCCURS) */

//    @Transactional
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addTenProducts3(){ /** CREATES A TRANSACTION*/
        for (int i=0; i<10; i++){
            productRepository.addProduct3("Product"+String.valueOf(i+1));
//            if (i==5) throw new RuntimeException(":(((((");
        }
    }/** COMMITS THE TRANSACTION (APPLIES ALL THE DB OPERATIONS IF ANY ERROR DOES NOT OCCURS) */


    //propagation level will be same as on the top of the class (if not declared default is Propagation.REQUIRED).
    public void smtElse(){

    }

    //propagation level is overriden if class has propagation
    @Transactional(propagation = Propagation.MANDATORY)
    public void smtElse2(){

    }
}
