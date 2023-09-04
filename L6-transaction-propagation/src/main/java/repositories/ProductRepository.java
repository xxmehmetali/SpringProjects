package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addProduct(String name){
        // THIS METHOD WILL HAVE A NEW TRANSACTION IF THERE IS NO TRANSACTION COMING FROM WHERE IT IS CALLED
        // IN THIS CASE THIS METHOD WILL NOT HAVE A NEW TRANSACTION BECAUSE THERE IS A TRANSACTION FROM addTenProducts() METHOD.
        String sql = "INSERT INTO products VALUES(NULL, ?)";
        jdbcTemplate.update(sql, name);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProduct2(String name){
        //IT IS NOT CONSIDERED IF THERE IS ALREADY A TRANSACTION FROM WHERE THIS METHOD IS CALLED.
        //IT HAS Propagation.REQUIRES_NEW PROPAGATION. SO IT WILL CREATE A NEW TRANSACTION FOR THIS METHOD ANYWAY.
        //MEANS IT WILL BE IMMIDEATELY COMMITTED IF ALL THE CODE IN THIS METHOD IS RUNNED SUCCESSFULLY
        String sql = "INSERT INTO products VALUES(NULL, ?)";
        jdbcTemplate.update(sql, name);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    /** THIS METHOD CAN BE CALLED IF ONLY THERE IS ALREADY A TRANSACTION WHERE THIS METHOD IS CALLED */
    //IN THIS CASE THERE HAS TO BE A TRANSACTION ON addTenProducts3()
    public void addProduct3(String name){
        String sql = "INSERT INTO products VALUES(NULL, ?)";
        jdbcTemplate.update(sql, name);
    }
}
