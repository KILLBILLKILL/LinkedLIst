public class PlayerLInkedList {

    public static void main(String[] args) {
        //创建球员对象
        Player a1=new Player(11,"姚明","小巨人");
        Player a2=new Player(23,"乔丹","飞人");
        Player a3=new Player(24,"科比","黑曼巴");
        Player a4=new Player(3,"艾弗森","答案");
        Player a5=new Player(23,"詹姆斯","小皇帝");
        Player a6=new Player(25,"罗斯","风城玫瑰");
        singlinkrdlist a=new singlinkrdlist();
        a.add2(a1);
        a.add2(a2);
        a.add2(a3);
        a.add2(a4);
        a.add2(a6);
        a.list();
        a.update(a5);
        System.out.println("修改后的节点为");
        a.list();
        a.del(23);
        System.out.println("删除后的节点为");
        a.list();
        System.out.println("原来链表的情况~~");
        a.list();
        int indext=2;
        System.out.println("返回倒数第2个节点为");
        Player res=findLastIndextNode(a.gethead(),indext);
        System.out.println("res="+res);
        System.out.println("反转之后链表的情况~~");
        reverset(a.gethead());
        a.list();

    }
    //新浪面试题，返回链表的倒数第INDEX个节点
    public static Player findLastIndextNode(Player head,int indext)
    {
        if(head.next==null)
        {
            return null;
        }
        Player temp=head.next;
        int length=length(head);
        for(int i=0;i<length-indext;i++)
        {
            temp=temp.next;
        }

        return temp;

    }
    public static int length(Player head)
    {
        if(head.next==null)
        {
            return 0;
        }
        int length =0;
        Player temp=head.next;
        while(true)
        {
            if(temp!=null)
            {
                length++;
                temp=temp.next;
            }
            else
            {
                break;
            }

        }

        return length;
    }
    //腾讯面试题 将链表反转
    public static void reverset(Player head)
    {
        if(head.next==null||head.next.next==null)
        {

            return ;//这种情况不需要反转

        }
        Player temp=head.next;
        Player next=null;
        Player reversehead=new Player(0,"","");
        while(temp!=null)
        {
            next=temp.next;//暂时先保留temp的下一个节点(必须要保留)  否则无法成功遍历
            temp.next=reversehead.next;//将temp的下一个节点指向当前链表的最前端   //这两句就是说必须要插在revesehead的后面
            reversehead.next=temp;//将temp连接到新链表之上
            temp=temp.next;
        }
        head.next=reversehead.next;
    }

}
//创建链表类
class  singlinkrdlist{

    private  Player head=new Player (0,"","");
    //返回头结点
    public Player gethead()
    {

        return head;


    }
    //定义添加方法
    public void add(Player player)
    {
        Player temp=head;
        while(true)
        {
            if(temp.next==null)
            {
                break;//在链表的最后添加
            }
            temp=temp.next;
        }

        temp.next=player;

    }
    //定义顺序添加方法
    public void add2(Player player)
    {
        //头结点不能变化，我们创建临时变量
        Player temp=head;
        boolean flag=false;
        while(true)
        {
            if(temp.next==null)
            {
                break;


            }
            if(temp.next.number>player.number)
            {//在tempde 的后面插入


                break;

            }
            else  if(temp.next.number==player.number)
            {

                flag=true;
                break;
            }

            temp=temp.next;
        }
        if(flag==false)
        {
            player.next=temp.next;//下一个节点相等
            temp.next=player;//player成为了temp的下一个节点

        }
        else
        {

            System.out.println("我们要插入的节点已经存在");

        }
    }
    //修改节点的方法
    public void update(Player player)
    {
        if(head.next==null)
        {
            System.out.println("链表为空");
        }
        Player temp=head;
        boolean flag=false;
        while(true)
        {
            if(temp.next==null)
            {
                break;
            }
            if(temp.next.number==player.number)
            {
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if(flag)
        {
            temp.next.name=player.name;
            temp.next.nickname=player.nickname;
        }
        else {

            System.out.printf("没有找到%d球员,无法修改",player.number);
        }
    }
    //删除节点的方法
    public void del(int number)
    {
        Player temp=head;
        boolean flag=false;
        if(head.next==null)
        {
            System.out.println("链表为空");
        }
        while(true)
        {
            if(temp.next==null)
            {
                break;
            }
            if(temp.next.number==number)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {

            temp.next=temp.next.next;
        }
        else {
            System.out.printf("没有找到%d球员,无法修改",number);
        }
    }
    public void list()
    {
        if(head.next==null)
        {
            System.out.println("链表为空");
            return;
        }

        Player temp=head.next;
        while(true)
        {

            if(temp==null)
            {
                break;
            }

            System.out.println(temp);
            temp=temp.next;
        }

    }
}

//创建球员类
class Player{
    public int number ;
    public String name;
    public String nickname;
    public Player next;
    public Player(int number,String name,String nickname){

        this.number=number;
        this.name=name;
        this.nickname=nickname;
    }
    @Override
    public String toString() {
        return "Player [number=" + number + ", name=" + name + ", nickname=" + nickname + "]";
    }


}
