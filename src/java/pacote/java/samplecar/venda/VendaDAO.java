package pacote.java.samplecar.venda;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class VendaDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public VendaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (nome_cliente, nome_vendedor, id_veiculo, preco_venda) VALUES (?, ?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, venda.getNome_cliente());
        statement.setString(2, venda.getNome_vendendor());
        statement.setInt(3, venda.getId_veiculo());
        statement.setFloat(4, venda.getPrice());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Venda> listAllVendas() throws SQLException {
        List<Venda> listVenda = new ArrayList<>();
         
        String sql = "SELECT * FROM venda";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("venda_id");
            String nome_vendedor =  resultSet.getString("nome_vendedor");
            String nome_cliente = resultSet.getString("nome_cliente");
            int id_veiculo = resultSet.getInt("id_veiculo");
            float preco_venda = resultSet.getFloat("preco_venda");
            Venda venda = new Venda(id, nome_cliente, nome_vendedor, id_veiculo, preco_venda);
            listVenda.add(venda);
        }
         
        resultSet.close();
        statement.close();
        disconnect();
       
        return listVenda;
    }
     
    public boolean deleteVenda(Venda venda) throws SQLException {
        String sql = "DELETE FROM venda where venda_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, venda.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateVenda (Venda venda) throws SQLException {
        String sql = "UPDATE venda SET nome_vendedor = ?, nome_cliente = ?, id_veiculo = ?, preco_venda = ?";
        sql += " WHERE venda_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, venda.getNome_vendendor());
        statement.setString(2, venda.getNome_cliente());
        statement.setInt(3, venda.getId_veiculo());
        statement.setFloat(4, venda.getPrice());
        statement.setInt(5, venda.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Venda getVenda(int id) throws SQLException {
        Venda venda = null;
        String sql = "SELECT * FROM venda WHERE venda_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nome_vendedor =  resultSet.getString("nome_vendedor");
            String nome_cliente = resultSet.getString("nome_cliente");
            int id_veiculo = resultSet.getInt("id_veiculo");
            float preco_venda = resultSet.getFloat("preco_venda");
             
            venda = new Venda(id, nome_vendedor, nome_cliente, id_veiculo, preco_venda);
        }
         
        resultSet.close();
        statement.close();
         
        return venda;
    }
}
