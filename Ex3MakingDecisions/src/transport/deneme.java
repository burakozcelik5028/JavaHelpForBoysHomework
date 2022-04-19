package transport;

import java.util.*;
import java.util.function.Predicate;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.lang.*;
import java.time.LocalDate;
import java.time.Month;
import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.*;

public class deneme {
    public static void main(String[] args) {
       int x = getValue();
       System.out.println(x);
       List strs = new ArrayList<String>();
       String name1 = "mt";
       String name2 = "mt";
       
       A1 a = new A1();
       A1 b = new A1();
       
       System.out.println(a.equals(b));
    }

     public static int getValue() {
       return 10;
    }
     
    
}
