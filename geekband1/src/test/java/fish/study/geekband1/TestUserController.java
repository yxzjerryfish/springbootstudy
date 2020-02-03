package fish.study.geekband1;


import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.SourceCodePath;
import org.junit.jupiter.api.Test;

public class TestUserController {
    @Test
    public void test(){
        ApiConfig config = new ApiConfig();
        config.setStrict(true);
        config.setAllInOne(true);
        config.setOutPath("E:\\md");
        config.setSourceCodePaths(SourceCodePath.path().setPath("/src/main/java"));
        ApiDocBuilder.buildApiDoc(config);
    }
}
