package springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: cloud2020
 * @description: 传递给前端的类
 * @author: Silince
 * @create: 2020-11-20 20:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    // 防止data为null的构造
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
