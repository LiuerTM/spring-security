package ind.liuer.security.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mingの
 * @date 2022/6/22 15:45
 * @since 1.0
 */
public final class JsonUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String jsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
