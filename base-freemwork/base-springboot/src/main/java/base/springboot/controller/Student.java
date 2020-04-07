package base.springboot.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tangwei
 * @date 2020/4/7 11:02
 */
@ApiModel("学习对象")
public class Student {

    @ApiModelProperty( notes = "学生名称")
    private String name;

    @ApiModelProperty( notes = "学生年龄")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
