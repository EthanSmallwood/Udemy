package JavaCollections.PasswordEncrypting;

public class Password {
    private static final int key=894513; //encryption key
    private final int encryptedPassword;// holds a never changing password
    static{
        System.out.println("Password Encryption");// runs before everything outputting the message
    }
    public Password(int password) {
        this.encryptedPassword =encryptDecrypt(password);//saves password after encrypting the password with the key
    }

    public int encryptDecrypt(int password){
        return password^ key;
    }//encrypts the password

    public void storePassword(){ System.out.println("Saving password as "+this.encryptedPassword); }// output message

    public boolean letMeIn(int password){
        if (encryptDecrypt(password) == this.encryptedPassword){ //checks to see if passwords are the same
            System.out.println("WELCOME");//confirmation message
            return true;
        }else{
            System.out.println("Nope you can not come in");//cancel message
            return false;
        }
    }
}
