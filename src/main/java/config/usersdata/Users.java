package config.usersdata;

/**
 * Class to manage users
 *
 * @author saurabhsrivastava
 */
public class Users {

    /**
     * User properties
     */
    private String username;
    private String userProfileID;
    private String userPassword;
    private String userProvider;

    /**
     * Initialise user data
     *
     * @param username      - username that you have picked
     * @param userProfileID - this can be found in the URL of profile page
     * @param userPassword  - the password you have set
     * @param userProvider  - the email id provider
     */
    private Users(String username, String userProfileID, String userPassword, String userProvider) {
        this.username = username;
        this.userProfileID = userProfileID;
        this.userPassword = userPassword;
        this.userProvider = userProvider;
    }

    /**
     * Method to get username
     *
     * @return - the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to get profile id
     *
     * @return - the profile id
     */
    public String getUserProfileID() {
        return userProfileID;
    }

    /**
     * Method to get password
     *
     * @return - the password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Method to get provider
     *
     * @return - the provider
     */
    public String getUserProvider() {
        return userProvider;
    }

    /**
     * Method to get the complete login ID
     *
     * @return - the complete login ID
     */
    public String getCompleteLoginID() {
        return username + "@" + userProvider;
    }

    /**
     * List of users
     */
    public static Users TEST_DUMMY_USER = new Users("testd8005", "67648516i", "Dummy%124", "gmail.com");
}
