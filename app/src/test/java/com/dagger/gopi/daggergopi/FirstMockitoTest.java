package com.dagger.gopi.daggergopi;

import com.dagger.gopi.daggergopi.models.Student;
import com.dagger.gopi.daggergopi.models.StudentWrapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by gopi on 10/03/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class FirstMockitoTest {
    @InjectMocks
    StudentWrapper studentWrapper = new StudentWrapper();
    @Mock
    Student student;


    @Test
    public void testStudentWrapper() {
        when(studentWrapper.getStudent().getAge()).thenReturn(30);
        when(studentWrapper.getStudent().getAge()).thenReturn(40);  // can call multiple times it will be overridden.
        when(studentWrapper.getStudent().getMarks()).thenReturn(25);
//        reset(student);  // reset will reset all the added behaviour , use it when ever reset is required.

//        Assert.assertEquals(studentWrapper.getStudent().howGoodStudentPercent(), 40);  // This will give zero bcoz original object method is not used . ONLY WHEN USED spy(new Student()) the original object functionality is preserved.
        Assert.assertEquals(studentWrapper.getStudent().getAge(), 40);
        Assert.assertEquals(studentWrapper.getStudent().getAge(), 40);
        int age = studentWrapper.getStudent().getAge();
        int marks = studentWrapper.getStudent().getMarks();
        System.out.println("age = " + age + " marks " + marks + " howGoodStudentPercent " + studentWrapper.getStudent().howGoodStudentPercent());
//        Mockito.verify(student, times(4)).getAge();  // how many times this is being referred exact.

        InOrder inOrder = Mockito.inOrder(student);  // order of method access must be getAge() & then getMarks() otherwise it will error out.
        inOrder.verify(student, atLeastOnce()).getAge();
        inOrder.verify(student, atLeastOnce()).getMarks();


        Student spyStudent = spy(new Student());  // use this when u want to mock few methods & rest functionality should work like Original object.
        Mockito.when(spyStudent.getMarks()).thenReturn(25);
        Mockito.when(spyStudent.getAge()).thenReturn(40);

        System.out.println("howGoodStudentPercent " + spyStudent.howGoodStudentPercent());
    }

}
