package class_basic.account_member;

public class MemberService {
    private String id;
    private String password;

    public boolean login(String id, String password){
        this.id = id;
        this.password = password;
        if(id.equals("hong") && password.equals("12345")){
            return true;
        }else{
            return false;
        }
    }

    public void logout(String id){
        System.out.println("로그아웃 되었습니다.");
    }




}
