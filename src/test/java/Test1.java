import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

/**
 * @author jlz
 * @className: Test1
 * @date 2021/5/14 14:35
 * @description todo
 **/
public class Test1 {
    static final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void a(){
        int x = -1;
        assert x >0:x;
        Queue<String> deque = new LinkedBlockingDeque();
        deque.offer("a");
        String poll = deque.poll();
        logger.info("结果是{}", deque.poll());
//        logger.info("hello");
    }

    @Test
    public void a2() throws RuntimeException{
        logger.info("a2 方法");
        a();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10); //使用操作系统内存
        ByteBuffer allocate = ByteBuffer.allocate(10); //使用java堆内存
    }

    public static <T extends Comparable> Pair minmax(T a){
        int i = a.compareTo(a);
        return new Pair<>();
    }
    public static <T extends Comparable,U extends Comparable> Pair minmax(T a,U u){
        int i = u.compareTo(a);
        return new Pair<>();
    }
    @Test
    public void testSupply(){
        //将方法引用作为参数传递给listFiles
        File[] files = new File(".").listFiles(File::isHidden);
        System.out.println(Arrays.stream(files).findFirst().get().getName());
    }

}
