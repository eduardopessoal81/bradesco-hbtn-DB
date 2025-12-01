package main;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class UsuarioOperations {

    private MongoCollection<Document> collection;

    public UsuarioOperations(MongoDatabase database) {
        this.collection = database.getCollection("usuarios");
    }

    // 1) INSERIR OS 3 USUÁRIOS
    public void inserirUsuarios() {

        Usuario u1 = new Usuario("Alice", 25);
        Usuario u2 = new Usuario("Bob", 30);
        Usuario u3 = new Usuario("Charlie", 35);

        collection.insertMany(
                java.util.List.of(
                        u1.toDocument(),
                        u2.toDocument(),
                        u3.toDocument()
                )
        );

        System.out.println("Usuários inseridos com sucesso!");
    }

    // 2) CONSULTAR USUÁRIOS
    public void consultarUsuarios() {
        System.out.println("Lista de usuários:");

        for (Document doc : collection.find()) {
            Usuario usuario = Usuario.fromDocument(doc);
            System.out.println(usuario);
        }

        System.out.println("--------------------------------");
    }

    // 3) ATUALIZAR IDADE DO BOB PARA 32
    public void atualizarBob() {

        UpdateResult result = collection.updateOne(
                eq("nome", "Bob"),
                set("idade", 32)
        );

        if (result.getModifiedCount() > 0) {
            System.out.println("Bob atualizado para 32 anos!");
        } else {
            System.out.println("Bob não encontrado para atualização.");
        }
    }

    // 4) REMOVER CHARLIE
    public void removerCharlie() {

        DeleteResult result = collection.deleteOne(eq("nome", "Charlie"));

        if (result.getDeletedCount() > 0) {
            System.out.println("Charlie removido com sucesso!");
        } else {
            System.out.println("Charlie não encontrado para remoção.");
        }
    }
}