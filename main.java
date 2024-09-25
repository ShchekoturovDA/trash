
import org.apache.maven.shared.invoker.*;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

public class main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        System.setProperty("maven.home", "C:\\Users\\Дмитрий\\apache-maven-3.9.0");

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("C:\\sber\\SberTasks2024\\pom.xml"));
        request.setGoals(Collections.singletonList("-Ddist=C:\\sber\\SberTasks2024\\src\\down spotbugs:check"));

        Invoker invoker = new DefaultInvoker();
        try {
            invoker.execute(request);
            System.out.println("Maven command executed successfully!");
        } catch (Exception e) {
            System.err.println("Error executing Maven command: " + e.getMessage());
            e.printStackTrace();
        }

        Writer writer = new Writer();
        XMLParser xmlParser = new XMLParser();
//        System.out.println(xmlParser.parse("C:\\sber\\SberTasks2024\\target\\spotbugsXml.xml"));
        writer.writeFile(xmlParser.parse("C:\\sber\\SberTasks2024\\target\\spotbugsXml.xml"));
        System.out.println("looooop");

    }
}
