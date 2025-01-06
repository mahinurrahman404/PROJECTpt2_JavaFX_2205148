package MyDatabaseApplication;

public class Login_info {
    private static boolean loggedIn = false;

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Login_info.loggedIn = loggedIn;
    }
}

