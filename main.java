import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/lanches";
        String username = "root";
        String password = "56405266885";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o nome do pedido: ");
            String nomePedido = scanner.nextLine();

            System.out.println("Digite o valor do pedido: ");
            String valorPedido = scanner.nextLine();

            System.out.println("Digite a quantidade: ");
            String quantidadePedido = scanner.nextLine();

            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Digite o horário: ");
            String horario = scanner.nextLine();

            String insertQuery = "INSERT INTO pizzaria(nomePedido, valorPedido, quantidade, nomeCliente, horario) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
                preparedStatement.setString(1, nomePedido);
                preparedStatement.setDouble(2, Double.parseDouble(valorPedido));
                preparedStatement.setInt(3, Integer.parseInt(quantidadePedido));
                preparedStatement.setString(4, nomeCliente);
                preparedStatement.setString(5, horario);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " linha(s) inserida(s) com sucesso.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
