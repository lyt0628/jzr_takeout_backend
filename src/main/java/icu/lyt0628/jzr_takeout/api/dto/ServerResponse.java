package icu.lyt0628.jzr_takeout.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success" ;
    private static final String FAILED = "failed" ;
    private static final String NOT_FOUND = "not found" ;

    private T data;
    private String message;
    private String status;

    public static  <T> ServerResponse<T> success(T data, String message){
        return  ServerResponse.<T>builder()
                .data(data)
                .message(message)
                .status(SUCCESS)
                .build();
    }

    public static   <T> ServerResponse<T> success(T data){
        return success(data, SUCCESS);
    }
    public static ServerResponse<Object> success() {
        return success(null);
    }

    public static  <T> ServerResponse<T> failed(T data, String message){
        return  ServerResponse.<T>builder()
                .data(data)
                .message(message)
                .status(FAILED)
                .build();
    }

    public static  ServerResponse<Object> failed(String message){
        return  failed(null, NOT_FOUND);
    }
}
