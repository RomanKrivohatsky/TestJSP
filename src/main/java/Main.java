import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by rom4 on 18.07.14.
 * Creation time 19:23
 * Project name Departments
 */
public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        Test o = (Test) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Test.class}, new IH());

        o.test("xaxa");
    }

    interface Test {
        void test(String s);
    }

        class IH implements InvocationHandler {
        private List depServImpl;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("111");
            try {
                return method.invoke(depServImpl, args);
            } finally {
                System.out.println("222");
            }
        }
    }
}
