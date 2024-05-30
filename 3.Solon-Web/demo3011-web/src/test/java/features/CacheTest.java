package features;

import demo3011.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

@SolonTest(WebApp.class)
public class CacheTest extends HttpTester {
    @Test
    public void test1() throws Exception{
        String rst = path("/cache/").get();

        Thread.sleep(100);

        assert rst.equals(path("/cache/").get());

        Thread.sleep(100);

        assert rst.equals(path("/cache/").get());

        Thread.sleep(100);

        assert rst.equals(path("/cache/").get());
    }

    @Test
    public void test2() throws Exception{
        String rst = path("/cache/").get();

        Thread.sleep(100);

        rst = path("/cache/update").get();
        assert rst.equals(path("/cache/").get());

        Thread.sleep(100);

        rst = path("/cache/update").get();
        assert rst.equals(path("/cache/").get());

        Thread.sleep(100);

        rst = path("/cache/update").get();
        assert rst.equals(path("/cache/").get());
    }

    @Test
    public void test3() throws Exception{
        String rst = path("/cache/").get();

        Thread.sleep(100);

        path("/cache/remove").get();
        assert rst.equals(path("/cache/").get()) == false;

        Thread.sleep(100);

        path("/cache/remove").get();
        assert rst.equals(path("/cache/").get()) == false;

        Thread.sleep(100);

        path("/cache/remove").get();
        assert rst.equals(path("/cache/").get()) == false;
    }
}
