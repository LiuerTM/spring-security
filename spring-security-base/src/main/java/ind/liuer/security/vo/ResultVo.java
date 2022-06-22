package ind.liuer.security.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mingの
 * @date 2022/6/22 15:36
 * @since 1.0
 */
@Data
@AllArgsConstructor(staticName = "create")
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultVo<T> success(String message, T data) {
        return create(0, message, data);
    }

    public static <T> ResultVo<T> success(String message) {
        return create(0, message, null);
    }

    public static <T> ResultVo<T> failure(String message) {
        return create(1, message, null);
    }
}
