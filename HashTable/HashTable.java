package HashTable;

public class HashTable {
    private StudentInfo[] data = new StudentInfo[100];

    public void put(StudentInfo s) {
        // 调用散列函数，获取存储位置
        int index = s.hashCode();
        // 添加元素
        data[index] = s;
    }

    public StudentInfo get(StudentInfo s) {
        return data[s.hashCode()];

    }
}