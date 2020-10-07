package Oct7;

import java.io.FileNotFoundException;

/**
 * @ClassName Exam2_22
 * @Description TODO
 * @Author Alaric
 * @Date 2020/10/7
 **/
public class Exam2_22 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("********测试1***********");
        int n=6,m=3;
        Joseph L=new Joseph(n,m);
        System.out.println("n="+n+",m="+m+"的约瑟夫序列");
        System.out.println(L.Jsequence());
        System.out.println("*******测试2*********");
        n=8;m=4;
        L=new Joseph(n,m);
        System.out.println("n="+n+",m="+m+"的约瑟夫序列");
        System.out.println(L.Jsequence());
    }

   static class Child
        //小孩节点类型
    {
        int no;
        //小孩编号
        Child next;
        //指向下一个结点指针
        public Child(int no1)
            //重载构造方法
        {
            no=no1;
            next=null;
        }
    }



    }
class Joseph {
    int n, m;
    Exam2_22.Child first;

    public Joseph(int n1, int m1) {
        Exam2_22.Child p, t;
        n = n1;
        m = m1;
        first = new Exam2_22.Child(1);
        t = first;
        for (int i = 2; i <= n; i++) {
            p = new Exam2_22.Child(i);
            t.next = p;
            t = p;
        }
        t.next = first;
    }

    public String Jsequence()
    //求解约瑟夫序列
    {
        String ans = " ";
        int i, j;
        Exam2_22.Child p, q;
        for (i = 1; i <= n; i++)
        //共出列N分小孩
        {
            p = first;
            j = 1;
            while (j < m - 1) {
                j++;
                p = p.next;
            }
            q = p.next;
            ans += q.no + " ";
            p.next = q.next;
            first = p.next;
        }
        return ans;
    }
}








