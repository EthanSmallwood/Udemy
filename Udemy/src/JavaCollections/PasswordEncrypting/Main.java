package JavaCollections.PasswordEncrypting;

public class Main {
    public static void main(String[] args) {
        int pw= 8021;//password
        Password password = new Password(pw);//call the class and stores password
        password.storePassword();//stores password output line

        password.letMeIn(pw);//tests the password
    }
}
