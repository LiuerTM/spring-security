package ind.liuer.security.exception;

/**
 * @author Mingの
 * @date 2022/6/22 15:47
 * @since 1.0
 */
public class FrameworkException extends RuntimeException {

    private static final long serialVersionUID = -7577522002715106692L;

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
