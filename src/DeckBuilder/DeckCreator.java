/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DeckBuilder;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.GregorianCalendar;

public class DeckCreator
{
public static void main(String[] args) throws FileNotFoundException
{
    
GregorianCalendar birthDate = new GregorianCalendar(2005, 02, 14);  
Worker workerman = new Worker();

workerman.age=31;
workerman.name=("Pepito Pimentón");
workerman.username=("pepitouser");
workerman.password="pepitopass";
workerman.birthDate=(birthDate.getTime());
    // Creates the stream to the file that will storage the serialized object
FileOutputStream outputFile = new FileOutputStream("workerman.xml");
    try (XMLEncoder xe = new XMLEncoder(outputFile)) {
        xe.writeObject(workerman);
    }
}}
