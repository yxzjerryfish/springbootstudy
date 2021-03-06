package fish.study.geekband1;

import fish.study.geekband1.Utils.DateUtils;
import fish.study.geekband1.controller.UserController;
import fish.study.geekband1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.Type;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.relational.core.sql.In;
import org.springframework.util.StringUtils;
import java.lang.reflect.Method;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class LogClassMethod {
    public static void getLog(Class<?> clz) {
        HashMap<String,String> mappingMap = new HashMap<>();
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("keyValue.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert properties != null;
        for (Map.Entry<Object,Object> pro:properties.entrySet()){
            mappingMap.put(pro.getKey().toString(),pro.getValue().toString());
        }
        Field[] fields =  clz.getDeclaredFields();
        StringBuilder fileString = new StringBuilder();
        for (Field field:fields){
            String m = mappingMap.get(field.getType().getName());
            if(StringUtils.isEmpty(m)){
                m = "\"\"";
            }
            String beforefiled = "\""+field.getName()+"\" : "+m + ",";
            log.info("************************************************");
            log.info(field.getName() + " "+ field.getType());
            fileString.append(beforefiled);
        }
        log.info(fileString.toString());
    }

    public static void getMethodLog(Method method){
        Class<?>  clz= method.getReturnType();
        getLog(clz);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        getLog(User.class);
        Method method = UserController.class.getMethod("getUser");
        getMethodLog(method);
    }
}
