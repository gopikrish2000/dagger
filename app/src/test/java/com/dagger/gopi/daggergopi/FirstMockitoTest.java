package com.dagger.gopi.daggergopi;

import com.dagger.gopi.daggergopi.models.Student;
import com.dagger.gopi.daggergopi.models.StudentWrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
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

    @Before
    public void setUp() {
        // do setup operations here.
    }

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
        System.out.println("age = " + age + " marks " + marks + " howGoodStudentPercent " + studentWrapper.getStudent().howGoodStudentPercent());  // here it returns howGoodStudentPercent = 0
//        Mockito.verify(student, times(4)).getAge();  // how many times this is being referred exact.

        InOrder inOrder = Mockito.inOrder(student);  // order of method access must be getAge() & then getMarks() otherwise it will error out.
        inOrder.verify(student, atLeastOnce()).getAge();
        inOrder.verify(student, atLeastOnce()).getMarks();


        Student spyStudent = spy(new Student());  // use this when u want to mock few methods & rest functionality should work like Original object.
        Mockito.when(spyStudent.getMarks()).thenReturn(25);
        Mockito.when(spyStudent.getAge()).thenReturn(40);

        System.out.println("howGoodStudentPercent " + spyStudent.howGoodStudentPercent());  // returns correct value.

         doAnswer(invocation -> {   // to override void method use doAnswer with when.
             System.out.println(" overriding void method behaviour");
             return null;
         }).when(student).voidMethodDoingNothing();

         student.voidMethodDoingNothing();

        Mockito.doCallRealMethod().when(student).samplePrint();   // For mocked object in case u want to call Real object implementation for it use doCallRealMethod or use Spy object ...
        student.samplePrint();

        Mockito.doCallRealMethod().when(student).howGoodStudentPercent();
        System.out.println("age = " + age + " marks " + marks + " howGoodStudentPercent " + studentWrapper.getStudent().howGoodStudentPercent());  // after calling doCallRealMethod  howGoodStudentPercent returns Correct value.

        Mockito.when(student.getPersonalizedName("sampleName")).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String argument = (String) invocation.getArgument(0);
                if(argument.contains("sample")){
                    return "MockitoChangedSampleName";
                }
                return argument;
            }
        });

        System.out.println(" personalizedName for sampleName is  " + student.getPersonalizedName("sampleName") + " personalizedName for dummyName is " + student.getPersonalizedName("dummyName"));

    }

}
