package MyDatabaseApplication;

public class Login_info_Client {
    private static boolean loggedIn = false;
    private static String username;
    static ClientRunner cln;

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Login_info_Client.loggedIn = loggedIn;
    }

    public static void setUsername(String username) {
        Login_info_Client.username = username;
    }

    public static String getUsername() {
        return username;
    }


    }


