package fish.study.geekband1;

import fish.study.geekband1.Constant.KeyValueMap;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class Geekband1Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Geekband1Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Properties properties = PropertiesLoaderUtils.loadAllProperties("keyValue.properties");
		for (Map.Entry pro:properties.entrySet()){
			KeyValueMap.mappingMap.put(pro.getKey().toString(),pro.getValue().toString());
		}
	}
}
