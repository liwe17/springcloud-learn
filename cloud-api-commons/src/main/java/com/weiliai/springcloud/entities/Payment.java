package com.weiliai.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Payment implements Serializable
{
    private Long id;
    private String serial;
}
