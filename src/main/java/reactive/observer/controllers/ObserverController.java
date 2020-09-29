package reactive.observer.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactive.observer.Observer1;
import reactive.observer.Observer2;
import reactive.observer.models.Student;
import reactive.observer.services.StudentService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/observe")
public class ObserverController {

    private final StudentService studentService;
    private final Observer1 observer1;
    private final Observer2 observer2;

    public ObserverController(StudentService studentService, Observer1 observer1, Observer2 observer2) {
        this.studentService = studentService;
        this.observer1 = observer1;
        this.observer2 = observer2;
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public Student newEntity(@RequestBody Student student) {
        this.studentService.studentSubject.onNext(student);
        return student;
    }

    @RequestMapping(path = "/newValues", method = RequestMethod.GET)
    public List<Student> newValues() {
        List<Student>studentList= Arrays.asList(observer1.getStudent(),observer2.getStudent());
        System.out.println(studentList);
        return studentList;
    }




}
