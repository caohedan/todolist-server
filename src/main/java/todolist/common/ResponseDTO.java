package todolist.common;

public class ResponseDTO<T> {
    private int status;
    private String message;
    private T data;

    public static ResponseDTO error(int status, String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(status);
        responseDTO.setMessage(message);
        return responseDTO;
    }

    public static ResponseDTO success(int status, String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(status);
        responseDTO.setMessage(message);
        return responseDTO;
    }

    public static <V> ResponseDTO success(int status, String message,V data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(status);
        responseDTO.setMessage(message);
        responseDTO.setData(data);
        return responseDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
