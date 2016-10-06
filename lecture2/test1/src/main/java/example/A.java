package example;

import sun.security.krb5.internal.APOptions;

/**
 * Created by drav on 04.10.2016.
 */
public class A {
    public static String str = "base str";

    public  int a;
    public Double db;
    public A(int a,Double db)
    {
        this.a =a;
        this.db = db;
    }
}
class B extends A
{
    public B()
    {
        super(0,0.0);
    }

}
