package bridges.Entity;

// 用户实体类
public class UserEntity {

    private String userName;
    private String passWord;
    private String nickName;

    public UserEntity(String userName, String passWord, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
    }

    public UserEntity(){

    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
