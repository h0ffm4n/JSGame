/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benja
 */
public class ClassX implements Runnable {
public  void methodAandB() {
    for(int i=0;i<10;i++) {
        while(GlobalClass.isClassXdone)
        {}
        System.out.println("This is A and B ");
        GlobalClass.isClassXdone = true;
        GlobalClass.isClassYdone = false;
}}
@Override
public void run() {
    methodAandB(); } }