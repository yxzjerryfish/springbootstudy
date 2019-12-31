package fish.study.geekband1;

import fish.study.geekband1.Constant.KeyValueMap;
import fish.study.geekband1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

@Slf4j
public class LogClassMethod {
    public static void getLog(Class<?> clz){
        Field[] fields =  clz.getDeclaredFields();
        String fileString = "";
        for (Field field:fields){
            String m = KeyValueMap.mappingMap.get(field.getType().getName());
            if(StringUtils.isEmpty(m)){
                m = "\"\"";
            }
            String beforefiled = "\""+field.getName()+"\" : "+m + ",";
            log.info("************************************************");
            log.info(field.getName() + " "+ field.getType());
            fileString = fileString + beforefiled;
        }
        log.info(fileString);
    }

    public static void main(String[] args) {
        getLog(User.class);
    }
}
