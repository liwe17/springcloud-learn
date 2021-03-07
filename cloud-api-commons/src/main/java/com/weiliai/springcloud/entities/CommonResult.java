package com.weiliai.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 通用返回结果集
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
