package fish.study.geekband1;

import com.alibaba.fastjson.JSON;
import fish.study.geekband1.Constant.KeyValueMap;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * 解析Annotation.
 *
 * @date: 2019-12-26
 * @version: 1.0
 * @author: fish paradise
 */
@Aspect
@Order(1)
@Component
@Slf4j
public class AspectLog {
    @Pointcut("@annotation(fish.study.geekband1.OutPutLog)")
    private void cut(){}

    @Around("cut()")
    public void After(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?> cls = signature.getReturnType();
        Field[] fields =  cls.getDeclaredFields();
        String before  = "{";
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
        log.info(before + fileString + "}");
        point.proceed();
    }
}