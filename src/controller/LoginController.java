package controller;

import java.sql.SQLException;

public interface LoginController {
    
    public boolean validate(String user, String password) throws SQLException;
    
}
