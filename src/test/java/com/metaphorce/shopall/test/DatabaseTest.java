package com.metaphorce.shopall.test;

import com.metaphorce.shopall.database.DatabaseConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class})
public class DatabaseTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void connectionTest() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT 1");
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Connection error");
        }
    }

}
