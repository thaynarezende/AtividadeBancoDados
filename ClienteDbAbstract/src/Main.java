import model.Diretor;
import repository.DiretorRepository;
import service.DiretorService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DiretorService diretorService = new DiretorService();
        DiretorRepository repository = new DiretorRepository();

        //Criando um novo diretor
        Diretor diretor = new Diretor(new Long(1), "Thayna", "09080003817", 10.000, 6.000);
        diretorService.save(diretor);

        //Alterando um novo diretor
        diretor.setNome(diretor.getNome() + " - alterado");
        diretorService.update(diretor);

        //Buscar todos os diretores
        System.out.println("Buscar diretor criado");
        List<Diretor> lista = repository.findAll();
        System.out.println(lista.get(0).getNome());

    }
}
