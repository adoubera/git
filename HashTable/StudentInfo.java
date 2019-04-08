package HashTable;

public class StudentInfo {
    private int age;
    private int counts;

    public StudentInfo(int age) {
        super();
        this.age = age;

    }

    public StudentInfo(int age, int counts) {
        super();
        this.age = age;
        this.counts = counts;

    }

    // 散列函数
    public int hashCode() {
        // 使用age作为存储顺序
        return age;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the counts
     */
    public int getCounts() {
        return counts;
    }

    /**
     * @param counts the counts to set
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

}