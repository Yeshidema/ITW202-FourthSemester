package com.example.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;
   @Before
    public void setUp(){
       mCalculator = new Calculator();
   }
   @Test
   public void addTwoNumber(){
       double result = mCalculator.Add(1d,2d);
       assertThat(result, is(equalTo(3d)));
   }

   @Test
    public void AddTwoNumForNegative(){
       double result = mCalculator.Add(-1d,2d);
       assertThat(result, is(equalTo(1d)));
   }
   @Test
    public void addTwoFloats(){
       double result = mCalculator.Add(1.111f,1.111f);
       assertThat(result,is(closeTo(2.222, 0.01)));
   }

   @Test
    public void SubTwoNumbers(){
       double result = mCalculator.Sub(4d,2d);
       assertThat(result, equalTo(2d));
   }

   @Test
    public void SubWithNegativeNum(){
       double result = mCalculator.Sub(2d,4d);
       assertThat(result, equalTo(-2d));
   }

   @Test
    public void MulTwoNum(){
       double result = mCalculator.Mul(3d,3d);
       assertThat(result,equalTo(9d));
   }

   @Test
    public void MulTwoNumZero(){
       double result = mCalculator.Mul(0d,0d);
       assertThat(result, is(equalTo(0d)));
   }
   @Test
    public void DivTwoNum(){
       double result = mCalculator.Div(6d,2d);
       assertThat(result, is(equalTo(3d)));
   }

   @Test
    public void DivTwoNumZero(){
       double result = mCalculator.Div(4d,0d);
       assertThat(result, equalTo(Double.POSITIVE_INFINITY));
   }


}