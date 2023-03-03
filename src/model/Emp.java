//员工实体类
package model;
public class Emp {
    private Integer id; //工号
    private String name; //姓名
    private String gender; //性别
    private Integer age; //年龄
    private String dept; //部门
    private String job; //职务
    private Double sal; //工资
    public Emp() {
    }
    public Emp(Integer id, String name, String gender, Integer age, String dept, String job, Double sal) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dept = dept;
        this.job = job;
        this.sal = sal;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Double getSal() {
        return sal;
    }
    public void setSal(Double sal) {
        this.sal = sal;
    }
}