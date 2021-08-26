package repository;

import model.Funcionario;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IRepository<Funcionario> {

    @Override
    public List<Funcionario> findAll() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM public.funcionarios ");
        ResultSet resultSet = null;
        resultSet = statement.executeQuery();

        List<Funcionario> funcionarios = new ArrayList<>();

        while (resultSet.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(resultSet.getString(1));
            funcionario.setId(Long.valueOf(resultSet.getString(2)));
            funcionario.setNome(resultSet.getString(3));
            funcionario.setSalario(Double.valueOf(resultSet.getString(4)));
            funcionarios.add(funcionario);
        }
        conn.close();
        return funcionarios;
    }

    @Override
    public Funcionario findById(Integer id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement3 = conn.prepareStatement("SELECT * FROM public.funcionarios WHERE id = ?");
        statement3.setInt(1, id);
        ResultSet resultSet3 = null;
        resultSet3 = statement3.executeQuery();

        System.out.println("---- Listagem INI ----");
        while (resultSet3.next()) {
            String index = resultSet3.getString(2);
            System.out.println(index);
        }
        System.out.println("---- Listagem FIM ----");
        conn.close();

        return new Funcionario();
    }

}