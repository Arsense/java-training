package base.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * http://localhost:8080/doc.html
 * @author tangwei
 * @date 2020/4/7 10:28
 */
@Controller
@Api(tags = "测试管理")
public class SwaggerDemoController {

    @ApiOperation("基本样例测试")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseBody
    public String demo() {
       return "测试成功";
    }

    @ApiOperation("基本样例测试")
    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    @ResponseBody
    public Student demoRequest(Student student) {
        return student;
    }


}
