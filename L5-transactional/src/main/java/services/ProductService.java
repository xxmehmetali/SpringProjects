package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.Random;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    // transaction will start here and end here. between { and }.
    // Transactional will only work with RuntimeExceptions. Not with checked exceptions.
    @Transactional
    public void addOneProduct() {
        int identifier = new Random().nextInt(1000);
        productRepository.addProduct("product" + String.valueOf(identifier));
        throw new RuntimeException("Runtime EXCEPTION occured :((((((");
    }

    // Transactional will NOT work here.
    // Even though you have error, the query will not be rollbacked.
    // Because method had checked exception. It doesn't matter if you send the exception to upper methods with "throws" keyword.
    // this circumstance is also enough for not to rollback changes.
    @Transactional
    public void addOneProduct2() {
        try {
            int identifier = new Random().nextInt(1000);
            productRepository.addProduct("product" + String.valueOf(identifier));
            throw new Exception("Runtime EXCEPTION occured :((((((");
        } catch (Exception e) {

        }
    }

    // This configuration reverses the running mechanism of transactional.
    @Transactional(noRollbackFor = RuntimeException.class, rollbackFor = Exception.class)
    public void addOneProduct3() throws Exception {
        int identifier = new Random().nextInt(1000);
        productRepository.addProduct("product" + String.valueOf(identifier));
        throw new Exception("Runtime EXCEPTION occured :((((((");
    }

    // You will see a new product in database because the exception is not thrown out of the method.
    // Due to transaction manager uses aop, transaction manager can not see the exception, because it is handled in the method and method just works as nothing happened.
    // In order transaction manager to handle the transaction, it has to see the exception.
    // aspect is at the around of the method. Aspect cannot see the inside of the method.
    // So you have to throw the error via throws or by not handling the error (for runtimeexceptions).
    @Transactional
    public void addOneProduct4() {
        int identifier = new Random().nextInt(1000);
        productRepository.addProduct("product" + String.valueOf(identifier));
        try {
            throw new RuntimeException("Runtime EXCEPTION occured :((((((");
        } catch (Exception e) {

        }
    }

}
