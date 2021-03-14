# spring-cloud学习项目
## 项目介绍
- 本项目按照尚硅谷spring-cloud2020版本搭建
  - https://www.bilibili.com/video/BV18E411x7eT?from=search&seid=9522633366948655739

## 项目搭建

### 搭建环境

<table>
    <tr>
        <td>软件名</td>
        <td>spring-cloud</td>
        <td>spring-boot</td>
        <td>alibaba</td>
    </tr>
    <tr>
        <td>版本号</td>
        <td>Hoxton.SR1</td>
        <td>2.2.2.RELEASE</td>
        <td>2.1.0.RELEASE</td>
    </tr>
</table>

<table>
    <tr>
        <td>运行环境</td>
        <td>java</td>
        <td>maven</td>
        <td>mysql</td>
    </tr>
    <tr>
        <td>版本号</td>
        <td>1.8及以上</td>
        <td>3.5及以上</td>
        <td>5.7及以上</td>
    </tr>
</table>

### 软件升级说明

<table>
    <tr>
        <th colspan="4">spring-cloud升级</th>
    </tr>
    <tr>
        <th>组件名称</th>
        <th>升级前组件</th>
        <th>升级后组件</th>
        <th>可选组件</th>
    </tr>
    <tr>
        <th>服务注册中心</th>
        <th>Eureka</th>
        <th>Nacos</th>
        <th>Zookeeper|Consul|Nacos</th>
    </tr>
    <tr>
        <th>服务调用1</th>
        <th>Ribbon</th>
        <th>LoadBalance</th>
        <th>Ribbon</th>
    </tr>
    <tr>
        <th>服务调用2</th>
        <th>Feign</th>
        <th>OpenFeign</th>
        <th>OpenFeign</th>
    </tr>
    <tr>
        <th>服务降级</th>
        <th>Hystrix</th>
        <th>sentienl</th>
        <th>sentienl</th>
    </tr>
    <tr>
        <th>服务网关</th>
        <th>Zuul</th>
        <th>gateway</th>
        <th>gateway</th>
    </tr>
    <tr>
        <th>服务配置</th>
        <th>Config</th>
        <th>Nacos</th>
        <th>Nacos</th>
    </tr>
    <tr>
        <th>服务总线</th>
        <th>Bus</th>
        <th>Nacos</th>
        <th>Nacos</th>
    </tr>
</table>

### 模块说明

<table>
    <tr>
        <th>模块名称</th>
        <th>模块说明</th>
    </tr>
    <tr>
        <th>cloud-api-commons</th>
        <th>平台通用实体或工具</th>
    </tr>
    <tr>
        <th>cloud-eureka-server-7001</th>
        <th>基于eureka的注册中心1</th>
    </tr>
    <tr>
        <th>cloud-eureka-server-7002</th>
        <th>基于eureka的注册中心2</th>
    </tr>
    <tr>
        <th>cloud-consumer-order-80</th>
        <th>基于eureka的服务消费者</th>
    </tr>
    <tr>
        <th>cloud-consumer-order-83</th>
        <th>基于openfeign的服务消费者</th>
    </tr>
    <tr>
        <th>cloud-provider-payment-8001</th>
        <th>基于eureka的服务提供者1</th>
    </tr>
    <tr>
        <th>cloud-provider-payment-8002</th>
        <th>基于eureka的服务提供者2</th>
    </tr>
    <tr>
        <th>cloud-consumer-zk-order-81</th>
        <th>基于zookeeper的服务提供者</th>
    </tr>
    <tr>
        <th>cloud-provider-payment-8004</th>
        <th>基于zookeeper的服务提供者</th>
    </tr>
    <tr>
        <th>cloud-consumer-order-82</th>
        <th>基于consul的服务消费者</th>
    </tr>
    <tr>
        <th>cloud-provider-payment-8006</th>
        <th>基于consul的服务提供者</th>
    </tr>
    <tr>
        <th>cloud-consumer-order-84</th>
        <th>测试hystrix的服务消费者</th>
    </tr>
    <tr>
        <th>cloud-provider-payment-8008</th>
        <th>测试hystrix的服务提供者</th>
    </tr>
    
    
</table>