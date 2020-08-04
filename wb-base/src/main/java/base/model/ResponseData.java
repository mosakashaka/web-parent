package base.model;

public class ResponseData<T> {
    private boolean success;
    private T data;
    private Integer code;
    private String message;

    public ResponseData<T> success(T data) {
        success = true;
        data = data;

        return this;
    }

    public ResponseData<T> fail(Integer errCode, String errMsg) {
        success = false;
        message = errMsg;
        code = errCode;

        return this;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
