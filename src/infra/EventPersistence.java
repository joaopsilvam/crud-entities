package infra;

import business.model.IEvent;
import util.InfraException;

import java.io.*;
import java.util.HashMap;

public class EventPersistence {
    public static HashMap<String, IEvent> loadEvents(String nomeArquivo) throws InfraException {

        HashMap<String, IEvent> events = new HashMap<>();
        try {
            File arquivo = new File(nomeArquivo);
            if (arquivo.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arquivo));
                events = (HashMap<String, IEvent>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            throw new InfraException();
        } catch(ClassNotFoundException erro2) {
            throw new InfraException();
        }

        return(events);
    }

    public static void saveEvents(HashMap<String, IEvent> events, String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {

            arquivo.getParentFile().mkdirs();
            arquivo.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arquivo));
            objOutput.writeObject(events);
            objOutput.close();

        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
}
