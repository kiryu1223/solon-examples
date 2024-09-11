package features;

import demo3011.WebApp;
import org.junit.jupiter.api.Test;
import org.noear.nami.Nami;
import org.noear.nami.annotation.NamiBody;
import org.noear.nami.annotation.NamiClient;
import org.noear.nami.coder.snack3.SnackDecoder;
import org.noear.solon.test.SolonTest;
import demo3011.model.UserModel;

/**
 * @author noear 2021/1/5 created
 */
@SolonTest(WebApp.class)
public class HttpParam3Test {
    @Test
    public void nami() {
        ParamService paramService = Nami.builder()
                .decoder(SnackDecoder.instance)
                .create(ParamService.class);

        UserModel userModel = new UserModel();
        userModel.name = "noear";

        UserModel model2 = paramService.model(userModel);

        assert userModel.name.equals(model2.name);
    }


    @NamiClient(path = "/demo2/param", upstream = {"http://localhost:8080"})
    public interface ParamService {
        UserModel model(@NamiBody UserModel model);
    }
}
