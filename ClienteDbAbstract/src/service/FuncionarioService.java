package service;

import model.Funcionario;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioService implements IService<Funcionario> {

    @Override
    public Funcionario save(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement insert = conn.prepareStatement("insert into public.diretores (id,nome,cpf,salario,bonus) values(?,?,?,?,?)");
        insert.setLong(1, funcionario.getId());
        insert.setString(2, funcionario.getNome());
        insert.setString(3, funcionario.getCpf());
        insert.setDouble(4, funcionario.getSalario());
        insert.execute();
        conn.close();
        return funcionario;
    }

    @Override
    public Funcionario update(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement update = conn.prepareStatement("UPDATE public.diretores SET nome = ?, cpf = ?, salario = ?,bonus = ? WHERE id = ?");
        update.setString(1, funcionario.getNome());
        update.setString(2, funcionario.getCpf());
        update.setDouble(3, funcionario.getSalario());
        update.setLong(5, funcionario.getId());
        update.executeUpdate();
        conn.close();
        return funcionario;
    }

    @Override
    public Funcionario delete(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement2 = conn.prepareStatement("DELETE FROM public.diretores WHERE ID = ?");
        statement2.setLong(1, funcionario.getId());
        statement2.executeUpdate();
        conn.close();
        return funcionario;
    }
}