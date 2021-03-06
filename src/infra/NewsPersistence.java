package infra;

import business.model.INews;
import util.InfraException;

import java.io.*;
import java.util.HashMap;

public class NewsPersistence {
    public static HashMap<String, INews> loadPosts(String nomeArquivo) throws InfraException {

        HashMap<String, INews> posts = new HashMap<>();
        try {
            File arquivo = new File(nomeArquivo);
            if (arquivo.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arquivo));
                posts = (HashMap<String, INews>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            throw new InfraException();
        } catch(ClassNotFoundException erro2) {
            throw new InfraException();
        }

        return(posts);
    }

    public static void savePosts(HashMap<String, INews> posts, String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {

            arquivo.getParentFile().mkdirs();
            arquivo.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arquivo));
            objOutput.writeObject(posts);
            objOutput.close();

        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
}
