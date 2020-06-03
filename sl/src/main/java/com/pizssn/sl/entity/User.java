package com.pizssn.sl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity//表示这是一个实体类
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})//本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate, 在 jpa 工作过程中，就会创造代理类来继承 User ，并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键策略
    @Column(name = "id")
    int id;
    String username;
    String password;
}
