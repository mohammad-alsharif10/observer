package reactive.observer.services;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.springframework.stereotype.Service;
import reactive.observer.models.Student;

@Service
public class StudentService {

    public Subject<Student> studentSubject = PublishSubject.create();
}
