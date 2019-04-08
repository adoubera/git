package HashTable;

public class TestHash {
    public static void main(String[] args) {
        StudentInfo s1 = new StudentInfo(16, 3);
        StudentInfo s2 = new StudentInfo(17, 11);
        StudentInfo s3 = new StudentInfo(17, 23);
        StudentInfo s4 = new StudentInfo(18, 24);
        StudentInfo s5 = new StudentInfo(19, 9);
        HashTable ht = new HashTable();
        ht.put(s1);
        ht.put(s2);
        ht.put(s3);
        ht.put(s4);
        ht.put(s5);
        // 获取目标数据
        StudentInfo target = new StudentInfo(18);
        StudentInfo info = ht.get(target);
        // 根据年龄获取数量
        System.out.println(info.getCounts());

    }

}