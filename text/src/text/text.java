package text;
class  A
{
    String s = "class : A";
}
class  B  extends  A
{
    String s = "class : B";
}
public class text
{
   static public void main(String arg[])
   {
     B b1,b2 = new B( );
     A a1,a2;
     a1 = (A)b2;
     a2 = b2;
     System.out.println(a1.s);
     System.out.println(a2.s);
     b1 = (B)a1;
     System.out.println(b1.s);
   }
}
