import io.netty.util.internal.StringUtil;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jlz
 * @className: T_40
 * @date 2021/5/7 16:23
 * @description todo
 **/
public class T_40 {
    /**
     * 组合2
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        //排序 很关键
        Arrays.sort(candidates  );
        backtrack(0,candidates,target,track);
        return res;
    }

    private void backtrack(int index,int[] candidates, int target,LinkedList<Integer> track ) {
        if (track.stream().mapToInt(Integer::intValue).sum() == target){
            res.add(new ArrayList<>(track));
            return;
        }
        if (track.stream().mapToInt(Integer::intValue).sum() > target){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //经过排序后 相同的值是连续的
            if(i > index && candidates[i] == candidates[i - 1])
                continue;
            track.addLast(candidates[i]);
            backtrack(i+1,candidates,target,track);
            track.removeLast();
        }
    }

    public strictfp static void main(String[] args) {
        new Hello();
        Doa a = new Doa("a");
        a.t1 = new T1("at");
        Doa b = new Doa("b");
        b.t1 = new T1("bt");
        swap(a,b);
        System.out.println(a.t1.t);
        System.out.println(b.t1.t);
        System.out.println(a.name);
        System.out.println(b.name);
    }
    static void swap(Doa a, Doa b){
        T1 tmp = a.t1;
        a.t1= b.t1;
        b.t1= tmp;
    }

    static void swap2(Doa a, Doa b){
        Doa tmp = a;
        a= b;
        b= tmp;
    }

    enum Size{
        SMALL(1,"小"),
        MED(3,"中"),
        LARGE(4,"大");

        public final int dayValue;

        public String a;
        Size(int dayValue,String a) {
            this.dayValue = dayValue;
            this.a = a;
        }
    }
    static class Doa{
        public String name;

        public T1 t1;
        public Doa(String name) {
            this.name = name;
        }
    }
    static class T1{
        public String t;

        public T1(String t) {
            this.t = t;
        }
    }
    static class Hello{
        static {
            System.out.println("hello");
        }
    }
}
