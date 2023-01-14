import org.example.dao.DataBaseUtility;
import org.example.dao.StockDAO;
import org.example.init.Initializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    void testSingleSuccessTest() {
        String TEST_SQL = "SELECT * FROM db_to_console_program.stock WHERE id = ?;";
        Initializer initializer = new Initializer();
        DataBaseUtility dataBaseUtility = new DataBaseUtility(initializer);
        int id = 1;
        ResultSet resultSet = dataBaseUtility.getResultSet(TEST_SQL, id);
//        try{
//            System.out.println(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("quantity"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    @Test
    void testSingleSuccessTest1() {

    }
    @Test
    void testSingleSuccessTest2() {

    }
}
