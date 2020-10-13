package Oct_13;

/**
 * @ClassName SqStringClass
 * @Description TODO
 * @Author Alaric
 * @Date 2020/10/13
 **/
public class SqStringClass {
    final int MaxSize = 100;
    char[] data;
    int size;

    public SqStringClass() {
        data = new char[MaxSize];
        size = 0;
    }
//串的基本运算算法
}

public SqStringClass SubStr(int i,int j) {    //求子串
    SqStringClass s=new SqStringClass();      //新建一个空串
    if (i<0 || i>=size || j<0 || i+j>size) {
        return s;
    }
    //擦描述不正确时返回空串K
    for(int k=i;k<=i+j;k++) {
        s.data[k - i] = data[k];
    }
    s.size=j;
    return s;                                 //返回新建的顺序串
}

public static int Strcmp(SqStringClass s,SqStringClass t) {
    int comlen;
    if(s.size() < t.size()) {
        comlen = s.size();                       //求s和t的共同长度
    }
    else {
        comlen=t.size();
    }
    for(int i=0;i<comlen;i++) {                 //在共同长度内逐个字符比较
        if(s.data[i] > t.data[i]) {
            return 1;
        }
        else {
            return -1;
        }
        if(s.size() == t.size()) {              //s==t
            return 0;
        }
        else if (s.size() > t.size()) {        //s>t
            return 1;
        }
        else {
            return -1;                         //s<t
        }
    }
}