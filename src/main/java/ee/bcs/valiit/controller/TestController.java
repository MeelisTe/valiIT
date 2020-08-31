package ee.bcs.valiit.controller;

import ee.bcs.valiit.Lesson1MathUtil;
import ee.bcs.valiit.Lesson2;
import ee.bcs.valiit.Lesson3;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private static final List<Employee> employees = new ArrayList();

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employees;
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
        employees.add(employee);
    }






    //Lesson1MathUtil:

    @GetMapping("/Lesson1MathUtilmin/min1/min2/")
    public int Lesson1MathUtilmin(@RequestParam("min1") int id, @RequestParam("min2") int id2) {
        int a = Lesson1MathUtil.min(id, id2);
        return a;

        // nt. kui min1 = 4 ja min2 = 1, siis http://localhost:8080/Lesson1MathUtilmin/min1/min2/?min1=4&min2=1
        // ehk "/Lesson1MathUtilmin/min1/min2/" lisada ?min1=4&min2=1
    }

    @GetMapping("/Lesson1MathUtilmax/{max1}/{max2}/")
    public int Lesson1MathUtilmax(@PathVariable("max1") Integer x, @PathVariable("max2") Integer y) {
        int a = Lesson1MathUtil.max(x, y);
        return a;
    }

    @GetMapping("/Lesson1MathUtilabs/{abs1}/")
    public int Lesson1MathUtilabs(@PathVariable("abs1") Integer x) {
        int a = Lesson1MathUtil.abs(x);
        return a;
    }

    @GetMapping("/Lesson1MathUtilisEven/{even1}/")
    public boolean Lesson1MathUtilisEven(@PathVariable("even1") Integer x) {
        boolean a = Lesson1MathUtil.isEven(x);
        return a;
    }

    @GetMapping("/Lesson1MathUtilmin2/{min1}/{min2}/{min3}/")
    public int Lesson1MathUtilmin2(@PathVariable("min1") Integer a, @PathVariable("min2") Integer b, @PathVariable("min3") Integer c) {
        a = Lesson1MathUtil.min2(a, b, c);
        return a;
    }

    @GetMapping("/Lesson1MathUtilmax2/{max1}/{max2}/{max3}/")
    public int Lesson1MathUtilmax2(@PathVariable("max1") Integer a, @PathVariable("max2") Integer b, @PathVariable("max3") Integer c) {
        a = Lesson1MathUtil.max2(a, b, c);
        return a;
    }

    //Lesson 2:

    @GetMapping("/Lesson2excercise1/{exercise1}/")
    public int[] Lesson2excercise1(@PathVariable("exercise1") int[] id) {
        int[] a = Lesson2.exercise1(id);
        return a;
    }

    //Lesson 3:

    @GetMapping("/Lesson3sum/{min1}/{min2}/")
    public int test(@PathVariable("min1") int x, @PathVariable("min2") Integer y) {
        int a = Lesson3.sum(x, y);
        return a;

        // nt. kui x = 4 ja y = 5, siis http://localhost:8080/Lesson3sum/4/5/
        // ehk "/Lesson3sum/{min1}/{min2}/" ja asendada {min1} - 4 ja {min2} - 5
    }

    //GetSet:

    @GetMapping("dto")
    public Employee dtoTest() {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setAge(20);

        return employee;
    }

    @PostMapping("dto")
    public void postTest(@RequestBody Employee employee) {
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
    }


}