import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author jlz
 * @className: T_clone
 * @date 2021/5/10 18:26
 * @description todo
 **/
public class T_clone implements Cloneable{

    public String name;
    public Integer age;

    public Date date;

    public T_clone(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    @Override
    protected T_clone clone() throws CloneNotSupportedException {
        //深克隆
        T_clone cloned = (T_clone) super.clone() ;
        //对引用字段分别克隆
        cloned.date = (Date)date.clone();
        return cloned;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        a();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Arrays.asList(1,2,3).stream().filter(integer -> {
                if (finalI > integer.intValue()){
                    return true;
                }
                return false;
            }).min(Comparator.reverseOrder()).get();
        }

        Date date1 = new Date();
        date1.setYear(2020);
        T_clone t1 = new T_clone("1", 12,date1);
        T_clone clone = t1.clone();
        clone.name = "2";

        clone.date.setYear(2021);
        System.out.println(clone.name);
        System.out.println(t1.name);
        System.out.println(clone.date.getYear());
        System.out.println(t1.date.getYear());
    }
    public static void a(){
        throw new RuntimeException("运行时异常");
    }
}
