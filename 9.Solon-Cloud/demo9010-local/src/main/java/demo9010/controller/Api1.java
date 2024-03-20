package demo9010.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Whitelist;

/**
 * @author noear 2022/11/22 created
 */
@Valid
@Mapping("api")
@Controller
public class Api1 {
    @Whitelist
    @Mapping("list1")
    public boolean list1(Context ctx) {
        return CloudClient.list().inListOfIp("whitelist", ctx.realIp());
    }

    @Mapping("list2")
    public String list2() {
        return "ok";
    }
}
