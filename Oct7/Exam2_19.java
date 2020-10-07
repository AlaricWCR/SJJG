package Oct7;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import javax.sound.sampled.DataLine;

/**
 * @ClassName Exam2_19
 * @Description TODO
 * @Author Alaric
 * @Date 2020/10/7
 **/
import  java.util.*;

public class Exam2_19 {
    public static void swap(DLinkNode1<Integer> p,DLinkNode1<Integer> q)
    //交换p和q结点值
    {   int tmp=p.data;
    p.data=p.data;q.data=tmp;
    tmp=p.freq;
    p.freq=q.freq;q.freq=tmp;
    }


static class DLinkNode1<E>                      //双链表结点泛型类
{
    E data;                              //节点中元素值
    int freq;                            //节点访问频度
    DLinkNode1<E> prior;                 //前驱结点指针
    DLinkNode1<E> next;                  //后继结点指针
    public DLinkNode1()                  //构造方法
    {
        freq=0;
        prior=null;
        next=null;
    }
    public DLinkNode1(E d){//重构方法
        freq = 0; data = d;
        prior = null ;
        next = null;
    }
}


static class DLinkListClass1 <E>
{
    DLinkNode1<E> dhead;
    public DLinkListClass1()
    {
        dhead= new DLinkNode1<E>();
        dhead.prior=null;
        dhead.next=null;
    }
    //线性表的基本运算算法
    public void CreateListR( E[] a)
    {
        DLinkNode1<E> s,t;
        t=dhead;
        for(int i=0;i<a.length;i++)
        {
            s=new DLinkNode1<E>(a[i]);
            t.next=s;
            s.prior=t;
            t=s;
        }
        t.next=null;
    }
    @Override
    public String toString()
    {
        String  ans="";
        DLinkNode1<E> p=dhead.next;
        while (p!=null)
        {
            ans+=p.data+"["+p.freq+"]";
            p=p.next;
        }
        return ans;
    }

}


public static boolean LocateElem(DLinkListClass1<Integer> L,Integer X)
        //查找值为x的节点
{
    DLinkNode1<Integer> p,pre;
    //p指向开始结点
    p=L.dhead.next;
    while  (p!=null && !p.data.equals(X)) {
        p = p.next;
    }
    if (p==null){
        return false;
    }                               //未找到值为X的结点返回false
    p.freq++;                                        //找到值为X的节点P
    pre=p.prior;
    //若p.freq比前驱大，两者值交换
    while (pre!=L.dhead && pre.freq<p.freq)
    {
        swap(pre, p);
        p = pre;
        //怕、pre同步前移
        pre = p.prior;
    }
    //成功找到值为X的结点返回true
    return true;
    }



    public static void Find(DLinkListClass1<Integer> L,Integer x) {
        //测试结果输出
        System.out.println("查找值为" + x + "的节点");
        if (LocateElem(L, x)) {
            System.out.println("查找成功，双链表L：" + L.toString());
        }
        else {
            System.out.println("查找失败");
        }
    }
    public static void main (String[] args)
    {
        Integer [] a={1,2,3,4,5};
        DLinkListClass1<Integer> L = new DLinkListClass1<Integer>();
        L.CreateListR(a);
        System.out.println("L: "+L.toString());
        Find(L,5);      Find(L,1);
        Find(L,4);      Find(L,5);
        Find(L,2);       Find(L,4);
        Find(L,5);
    }
}