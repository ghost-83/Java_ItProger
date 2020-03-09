public class User {

    private String login;
    private String email;

    public User(){
    }

    public User(String login, String email){
        if(login.length() > 4)
            this.login = login;
        else
            throw new Error("Login entered incorrectly");
       if( email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
           this.email = email;
       else
           throw new Error("Email entered incorrectly");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        if(login.length() > 4)
            this.login = login;
        else
            throw new Error("Login entered incorrectly");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
            this.email = email;
        else
            throw new Error("Email entered incorrectly");
    }
}
