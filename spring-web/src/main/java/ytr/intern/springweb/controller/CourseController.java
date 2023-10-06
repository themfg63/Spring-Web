package ytr.intern.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/* UYGULAMA
    -> Bir controller tanımlayın ve aşağıdaki URL'i parse edebilecek şekilde düzenleyin:
    /courses/15?name=testName&instructor=testPerson
    -> '15 testName testPerson' yazan bir controller function'ı yazın.
 */


@Controller
public class CourseController {
    @RequestMapping("/courses/{coursesNumber}")
    public void courses(@PathVariable Long courseNumber, @RequestParam String name, @RequestParam String instructor){
        System.out.println(courseNumber + " " + name + " " + instructor );
    }
}
