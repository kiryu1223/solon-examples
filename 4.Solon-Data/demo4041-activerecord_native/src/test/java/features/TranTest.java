package features;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;

import org.noear.solon.test.SolonTest;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;
import demo4041.DemoApp;


@SolonTest(DemoApp.class)
public class TranTest extends HttpTester {

    @Db
    DbContext db;

    @Test
    public void test() throws Exception {
        clear(db);
        path("/tran/test").get();
        path("/tran/test").get();
        path("/tran/test").get();
        assert db.table("test").selectCount() == 6;
    }

    @Test
    public void test2() throws Exception {
        clear(db);
        path("/tran/test2").get();
        path("/tran/test2").get();
        path("/tran/test2").get();
        assert db.table("test").selectCount() == 0;
    }

    @Test
    public void test11() throws Exception {
        clear(db);
        path("/tran/test11").get();
        path("/tran/test11").get();
        path("/tran/test11").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test12() throws Exception {
        clear(db);
        path("/tran/test12").get();
        path("/tran/test12").get();
        path("/tran/test12").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test21() throws Exception {
        clear(db);
        path("/tran/test21").get();
        path("/tran/test21").get();
        path("/tran/test21").get();
        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test22() throws Exception {
        clear(db);
        path("/tran/test22").get();
        path("/tran/test22").get();
        path("/tran/test22").get();
        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }


    @Test
    public void test41() throws Exception {
        clear(db);
        path("/tran/test41").get();
        path("/tran/test41").get();
        path("/tran/test41").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test51() throws Exception {
        clear(db);
        path("/tran/test51").get();
        path("/tran/test51").get();
        path("/tran/test51").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test52() throws Exception {
        clear(db);
        path("/tran/test52").get();
        path("/tran/test52").get();
        path("/tran/test52").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 1; //因为有cache，只被执行了1次
    }

    @Test
    public void test61() throws Exception {
        clear(db);
        path("/tran/test61").get();
        path("/tran/test61").get();
        path("/tran/test61").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test63() throws Exception {
        clear(db);
        path("/tran/test63").get();
        path("/tran/test63").get();
        path("/tran/test63").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test71() throws Exception {
        clear(db);
        path("/tran/test71").get();
        path("/tran/test71").get();
        path("/tran/test71").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 3;
    }

    @Test
    public void test73() throws Exception {
        clear(db);
        path("/tran/test73").get();
        path("/tran/test73").get();
        path("/tran/test73").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test74() throws Exception {
        clear(db);
        path("/tran/test74").get();
        path("/tran/test74").get();
        path("/tran/test74").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 0;
    }

    @Test
    public void test75() throws Exception {
        clear(db);
        path("/tran/test75").get();
        path("/tran/test75").get();
        path("/tran/test75").get();

        long count = db.table("test").selectCount();
        System.out.println(count);
        assert count == 1;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
