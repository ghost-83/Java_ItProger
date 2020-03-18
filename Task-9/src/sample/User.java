package sample;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements Serializable {

    private String login;
    private transient String email;
    private transient String password;

    public User(){
    }

    public User(String login){
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        boolean res;
        if(password.length() > 4){
            this.password = md5String(password);
            res = true;
        }

        else res = false;
        return res;
    }

    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login){
        boolean res;
        if(login.length() > 4){
            this.login = login;
            res = true;
        }
        else
            res = false;
        return res;
    }

    public String getEmail() {

        return email;
    }

    public boolean setEmail(String email){
        boolean res;
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            this.email = email;
            res = true;
        }
        else
            res = false;
        return res;
    }

    public static String md5String(String password){
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger(1, digest);
        String md5Hex = bigInteger.toString(16);

        while (md5Hex.length() <32){
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }
}
