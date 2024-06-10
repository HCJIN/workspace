package class_basic.memberservice;

public class MemberService {
    private String id;
    private String password;

    public boolean login(String id, String password){
        this.id = id;
        this.password = password;
        if(id.equals("hong")){
            if(password.equals("12345")){
                return true;
            }
        }
        return false;
    }

    public void logout(String id){
        this.id = id;
        System.out.println("로그아웃 되었습니다.");
    }




}
