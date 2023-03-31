package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Atomicy : all or nothing
    // Suppose you have 2 account and need to transfer $100 from first to second.
    // You get the money from first account (-100)
    // try to put money in second account (FAIL)
    // flow ends.
    // You ended up losing $100. If you encounter any error while flow is on, you have to revert everything.
    // You can not split flow. This is atomicy.
    public void addProduct(String name){
        String sql = "INSERT INTO products VALUES(NULL, ?)";
        jdbcTemplate.update(sql, name);
    }
}
