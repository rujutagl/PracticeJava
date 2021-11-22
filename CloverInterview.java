import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

/*
Assume that you have an input string that is comprised of *balanced* pairs of '(' and ')' and other characters such that a pair of
balanced parentheses forms a 'capturing group' for all characters within it.
Assume capturing groups are numbered from left to right starting from 0. Please write a function that will return a
 list containing all non-parenthesis characters within a given capturing group.
 If the numbered capturing group does not exist within the input string, then throw an IllegalArgumentException.
 Please see the test cases below for examples.
(a(b)c(d))(e) group=1 result=[a, b,c ,d]
*/
public class CloverInterview {

    public static List<Character> captured(String input, int group) {
        int tmpOpeningCnt = -1;
        boolean capturing = false;
        List<Character> charList= new ArrayList<>();

        if(input.isEmpty()){
            throw new IllegalArgumentException("Error");
        }
        for (char i = 0; i<input.length(); i++ ){
            char charTmp=input.charAt(i);
            if(capturing) {
                //add char to result and figure out where to stop
                if(charTmp == '('){
                    tmpOpeningCnt ++; // 1
                } else if(charTmp == ')'){
                    tmpOpeningCnt--;// 0
                    if(tmpOpeningCnt == 0){
                        return charList;// b,
                    }
                } else{
                    charList.add(charTmp); // charList = a, b, c, d
                }
            }else{
                if(charTmp == '('){
                    tmpOpeningCnt ++; //1
                    if(tmpOpeningCnt == group){
                        capturing = true;
                        tmpOpeningCnt = 1;
                    }
                }
            }
        }
        if(charList.isEmpty()){
            throw new IllegalArgumentException("Error");
        }
        return charList;
    }

    @Test
    public void test01() {
        Assert.assertEquals(Collections.emptyList(), captured("()", 0));
    }

    @Test
    public void test02() {
        Assert.assertEquals(Arrays.asList('a'), captured("(a)", 0));
    }

    @Test
    public void test03() {
        Assert.assertEquals(Arrays.asList('a'), captured("((a))", 0));
    }

    @Test
    public void test04() {
        Assert.assertEquals(Arrays.asList('a'), captured("((a))", 1));
    }

    @Test
    public void test05() {
        Assert.assertEquals(Arrays.asList('a', 'b', 'c', 'd', 'e'), captured("(a(b)c(d)e)", 0));
    }

    @Test
    public void test06() {
        Assert.assertEquals(Arrays.asList('b'), captured("(a(b)c(d)e)", 1));
    }

    @Test
    public void test07() {
        Assert.assertEquals(Arrays.asList('d'), captured("(a(b)c(d)e)", 2));
    }

    @Test
    public void test08() {
        Assert.assertEquals(Arrays.asList('a', 'b', 'c', 'd', 'e'), captured("(a(b(c)d)e)", 0));
    }

    @Test
    public void test09() {
        Assert.assertEquals(Arrays.asList('b', 'c', 'd'), captured("(a(b(c)d)e)", 1));
    }

    @Test
    public void test10() {
        Assert.assertEquals(Arrays.asList('c'), captured("(a(b(c)d)e)", 2));
    }

    @Test
    public void test11() {
        Assert.assertEquals(Arrays.asList('c', 'd'), captured("ab(cd)", 0));
    }

    @Test
    public void test12() {
        Assert.assertEquals(Collections.emptyList(), captured("()(abc)", 0));
    }

    @Test
    public void test13() {
        Assert.assertEquals(Arrays.asList('a', 'b', 'c'), captured("()(abc)", 1));
    }

    @Test
    public void test14() {
        Assert.assertEquals(Arrays.asList('a'), captured("(a)(b)((c)d)", 0));
    }

    @Test
    public void test15() {
        Assert.assertEquals(Arrays.asList('b'), captured("(a)(b)((c)d)", 1));
    }

    @Test
    public void test16() {
        Assert.assertEquals(Arrays.asList('c', 'd'), captured("(a)(b)((c)d)", 2));
    }

    @Test
    public void test17() {
        Assert.assertEquals(Arrays.asList('c'), captured("(a)(b)((c)d)", 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test18() {
        captured("", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test19() {
        captured("()", 1);
    }

    public static void main(String[] args) {
        JUnitCore.main("CloverInterview");
    }
}
