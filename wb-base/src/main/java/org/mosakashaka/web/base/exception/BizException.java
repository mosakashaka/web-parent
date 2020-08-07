package org.mosakashaka.web.base.exception;

public class BizException extends RuntimeException
{
    private Integer code;
    private String description;

    public BizException() {
    }

    public BizException(String message) {
        this(null, message, null);
    }

    public BizException(String message, Throwable cause) {
        this(null, message, cause);
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.description = message;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        if (this.code != null) {
            sb.append("errorCode = [");
            sb.append(this.code);
            sb.append("]");
            if (this.description != null) {
                sb.append("  errorDesc= [");
                sb.append(this.description);
                sb.append("]");
            }
        }

        for (int i = 0; i < getStackTrace().length; i++) {
            sb.append("\r\n\tat ");
            sb.append(getStackTrace()[i]);
        }

        Throwable cause = getCause();

        while (cause != null) {
            sb.append("\r\nCause by: ");
            sb.append(cause.toString());

            for (int i = 0; i < cause.getStackTrace().length; i++) {
                sb.append("\r\n\tat ");
                sb.append(cause.getStackTrace()[i]);
            }

            cause = cause.getCause();
            if (cause != null) {
                sb.append("\r\nCaused by: ");
            }
        }

        return sb.toString();
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
