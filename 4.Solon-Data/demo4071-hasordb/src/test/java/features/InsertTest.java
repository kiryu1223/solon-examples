package features;

import demo4071.DemoApp;
import demo4071.dso.mapper.AppxMapper;
import net.hasor.db.solon.Db;
import org.junit.jupiter.api.Test;


import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/5/16 created
 */

@SolonTest(DemoApp.class)
public class InsertTest {

    @Db
    AppxMapper appxMapper;

    @Test
    public void test(){

       long id =  appxMapper.appx_add2(12912);
       System.out.println(id);
    }
}
