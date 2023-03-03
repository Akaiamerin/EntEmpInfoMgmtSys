//管理员实体类
package model;
public class Admin {
    private String acct; //管理员账号
    private String pwd; //管理员密码
    public Admin() {
    }
    public Admin(String acct, String pwd) {
        this.acct = acct;
        this.pwd = pwd;
    }
    public String getAcct() {
        return acct;
    }
    public void setAcct(String acct) {
        this.acct = acct;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}