package client;

import demo3041.common.UserModel;
import demo3041.common.UserService;
import demo3041.server.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.nami.annotation.NamiClient;
import org.noear.snack.ONode;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/4/22 created
 */
@SolonTest(WebApp.class)
public class ClientApp {
    @NamiClient(upstream = "http://localhost:8080/", path = "/rpc/v1/user/")
    UserService userService;

    @Test
    public void test1() {
        UserModel user = userService.getUser();
        System.out.println(ONode.stringify(user));

        assert user.getUserId() > 0;
    }
}
