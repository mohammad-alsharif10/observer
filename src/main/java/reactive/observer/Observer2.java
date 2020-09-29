package reactive.observer;

import io.reactivex.disposables.Disposable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import reactive.observer.models.Student;
import reactive.observer.services.StudentService;

@Service
@Getter
@Setter
public class Observer2 {

    private final StudentService studentService;
    private Student student;
    private Disposable disposable;

    public Observer2(StudentService studentService) {
        this.studentService = studentService;
        this.disposable = this.studentService.studentSubject
                .subscribe(value -> {
                    this.student=new Student(value.getName()+"from OBSERVER 2",value.getAge(),value.getGrade(),value.getYear());
                    System.out.println(this.student.toString());
                    System.out.println(value.toString());
                });
    }


}
