package appLayer;

import dataLayer.DB_User;

public class User {
    public boolean isValidUserCredentials(String userName, String userPassword) {
        DB_User db_user = new DB_User();
        return db_user.isValidUSerLogin(userName, userPassword);
    }
}
