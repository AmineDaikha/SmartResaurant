package Models;

public class User {
    private int id;
    private int id_emloyer;
    private String UserName;
    private String PassWord;

    public User(){}

    public User(int id, int id_emloyer, String userName, String passWord) {
        this.id = id;
        this.id_emloyer = id_emloyer;
        UserName = userName;
        PassWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_emloyer() {
        return id_emloyer;
    }

    public void setId_emloyer(int id_emloyer) {
        this.id_emloyer = id_emloyer;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
