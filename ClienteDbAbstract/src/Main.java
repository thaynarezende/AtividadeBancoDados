import model.Diretor;
import model.Funcionario;
import repository.DiretorRepository;
import repository.FuncionarioRepository;
import service.DiretorService;
import service.FuncionarioService;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DiretorService diretorService = new DiretorService();
        DiretorRepository repository = new DiretorRepository();
        FuncionarioService funcionarioService = new FuncionarioService() ;
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

        //Criando um novo diretor
        Diretor diretor = new Diretor(new Long(1), "Thayna", "09080003817", 10.000, 6.000);
        diretorService.save(diretor);

        //Criando um novo funcionario
        Funcionario funcionario = new Funcionario(new Long(1), "João", "0215448444", 5.000);
        funcionarioService.save(funcionario);

        //Alterando um novo diretor
        diretor.setNome(diretor.getNome() + " - alterado");
        diretorService.update(diretor);

        //Alterando um novo funcionario
        funcionario.setNome(funcionario.getNome() + " - alterado");
        funcionarioService.update(funcionario);

        //Buscar todos os diretores
        System.out.println("Buscar diretor criado");
        List<Funcionario> lista = funcionarioRepository.findAll();
        System.out.println(lista.get(0).getNome());

        //Buscar todos os funcionarios
        System.out.println("Buscar funcionario criado");
        List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();
        System.out.println(listaDeFuncionarios.get(0).getNome());


    }
}