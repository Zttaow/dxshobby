package club.ztt.util;

/**
 * @author 赵涛涛
 * @date 2017/8/15.
 */
public class CommonException extends RuntimeException {
    private String errorMessage;

    public CommonException() {
    }

    public CommonException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
