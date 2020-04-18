# spring-boot-example
springboot模块示例代码与研究


#### 主要内容
##### 分模块展示示例代码

- [参考文档](https://guides.gradle.org/creating-multi-project-build

> 基础定时任务框架


#### 问题记录
##### 1、项目模块集成插件
> 使用插件集成
```
   implementation platform('org.springframework.boot:spring-boot-dependencies:2.2.6.RELEASE')
```
> 插件出现问题，无法支持lombok配置，暂时废弃
```
   id 'org.springframework.boot' version '2.2.6.RELEASE'
   id 'io.spring.dependency-management' version '1.0.9.RELEASE'
```
##### 2、项目打包方式
> 引入maven插件打包，否则没有install命令。<br/>
> 使用build打包会应用bootJar，暂时不用此种方式。
```$xslt
   gradle clean install --info
```
##### 3、项目运行方式
