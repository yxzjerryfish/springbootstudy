package fish.study.geekband1;

import java.lang.annotation.*;

/**
 * @author yxzjerryfish
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OutPutLog {
}
