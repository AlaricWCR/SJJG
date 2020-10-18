package Oct_18;

/**
 * @ClassName find
 * @Description TODO
 * @Author Alaric
 * @Date 2020/10/18
 **/
public class find {
    public int find(T obj)
    {
//本算法实现查找顺序表中值为obj的元素，如果查找成功，返回元素位序，否则返回0；
        if(isEmpty()){
            System.out.println("顺序表为空");
            return 0;
        }else{
            for(int i=0;i<length;i++)
            {
                //判断元素是否相等
                if(listArray[i].equals(obj))
                {
                    //如果相等返回下标
                    return i+1;
                }
            }
//如果不相等返回-1
            return -1;
        }
    }
}
