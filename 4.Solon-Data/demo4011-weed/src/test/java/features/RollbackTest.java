package features;

import demo4011.DemoApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.annotation.TestRollback;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(DemoApp.class)
public class RollbackTest extends HttpTester {

    @Db
    DbContext db;

    @Test
    public void test1() throws Exception {
        clear(db);
    }

    @TestRollback
    @Test
    public void test2() throws Exception {
        db.table("test").set("v1", "1111").insert();
        db.table("test").set("v1", "1111").insert();
        db.table("test").set("v1", "1111").insert();

        assert db.table("test").selectCount() == 3;
    }

    @Test
    public void test3() throws Exception {
        assert db.table("test").selectCount() == 0;
    }

    private void clear(DbContext db) throws Exception {
        db.exe("TRUNCATE TABLE test");
    }
}
