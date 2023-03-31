package demo.orchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SpringBootApplication
public class OrchestrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrationApplication.class, args);
		//DbToJson();
	}

	private static void DbToJson() {
		String url = "jdbc:mysql://localhost:3306/payments";
        String username = "Harsh";
        String password = "Harsh@2024";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metadata = conn.getMetaData();

            String[] types = {"TABLE"};
            ResultSet tableResultSet = metadata.getTables(null, null, "%", types);

            JSONObject schema = new JSONObject();

            while (tableResultSet.next()) {
                String tableName = tableResultSet.getString("TABLE_NAME");

                ResultSet columnResultSet = metadata.getColumns(null, null, tableName, null);

                JSONObject table = new JSONObject();
                while (columnResultSet.next()) {
                    String columnName = columnResultSet.getString("COLUMN_NAME");
                    String columnType = columnResultSet.getString("TYPE_NAME");
                    int columnSize = columnResultSet.getInt("COLUMN_SIZE");

                    JSONObject column = new JSONObject();
                    column.put("type", columnType);
                    column.put("size", columnSize);

                    table.put(columnName, column);
                }

                ResultSet fkResultSet = metadata.getImportedKeys(null, null, tableName);

                JSONArray fks = new JSONArray();
                while (fkResultSet.next()) {
                    String pkTableName = fkResultSet.getString("PKTABLE_NAME");
                    String pkColumnName = fkResultSet.getString("PKCOLUMN_NAME");
                    String fkColumnName = fkResultSet.getString("FKCOLUMN_NAME");

                    JSONObject fk = new JSONObject();
                    fk.put("pk_table", pkTableName);
                    fk.put("pk_column", pkColumnName);
                    fk.put("fk_column", fkColumnName);

                    fks.add(fk);
                }

                table.put("foreign_keys", fks);
                schema.put(tableName, table);
            }

            try (FileWriter writer = new FileWriter("schema.json")) {
                writer.write(schema.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
