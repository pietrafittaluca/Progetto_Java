package sample.Classi;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database
{
    ///////////////////////////////////////////////////////////////////////////////////
    /*METODI PER IMPLEMENTARE SINGLETON*/
    private static Database dbIsntance; // Static reference to itself

    private Database()
    {
        /* private constructor*/
    }

    public static Database getInstance()
    {
        if (dbIsntance == null)
            dbIsntance = new Database();

        return dbIsntance;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER LA CONNESSIONE AL DATABASE*/
    private static final String URL = "jdbc:mysql://localhost/db_moodtraveling?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Rome&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static Connection con = null;

    public Connection getConnection()
    {
        if (con == null)
        {
            try
            {
                Class.forName(DRIVER_CLASS);
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            catch (SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return con;
    }

    ///////////////////////////////////////////////////////////////////////////////////
     /*METODO PER CERCARE UN UTENTE NEL DATABASE*/
    // Torna 1 se ha trovato l'utente, altrimenti 0
    public int checkUser(String email, String password) throws SQLException
    {
        String cc = null;
        String mail = email.toLowerCase();

        Statement stat = con.createStatement();

        String query = "SELECT COUNT(*) "
                + "FROM UTENTE "
                + "WHERE EMAIL=" + "'" + mail + "' AND PASSWORD_U=" + "'" + password + "'";

        ResultSet rest = stat.executeQuery(query);

        while (rest.next())
        {
            cc = rest.getString(1);
        }

        System.out.println(cc);

        stat.close();
        rest.close();

        return Integer.parseInt(cc);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO CHE RESTITUISCE UNA LISTA DEGLI ATTRIBUTI DELLA TABELLA PASSATA IN INPUT*/
    public ArrayList<String> getMD(String tableName) throws SQLException
    {
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs = dbmd.getColumns(null, null, tableName, "%");

        ArrayList<String> arr_type = new ArrayList<String>();

        while (rs.next())
        {
            String c_name = rs.getString("COLUMN_NAME");
            String c_type = rs.getString("TYPE_NAME");
            arr_type.add(c_type);
            System.out.println("c_name: " + c_name + ", c_type: " + c_type);
        }

        return arr_type;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER INSERIRE UNA RIGA NEL DATABASE*/
    // La query deve essere completa di tutti gli attributi della tabella
    public void insertRow(String table, ArrayList<String> tuple) throws SQLException
    {
        try
        {
            ArrayList<String> md = this.getMD(table);

            String query = "INSERT INTO " + table.toUpperCase() + " VALUES(";
            for (int i = 0; i < md.size() - 1; i++)
            {
                query += "?,";
            }
            query += "?)";

            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query);

            int i = 0;
            for (int j = 1; j <= md.size(); j++, i++)
            {
                if(table.equals("UTENTE") && i == 4)
                {
                    pstmt.setString(j, tuple.get(i));
                }
                else if (md.get(j - 1).equals("VARCHAR"))
                {
                    pstmt.setString(j, tuple.get(i).toLowerCase());
                }
                else if (md.get(j - 1).equals("DATE"))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date langDate = sdf.parse(tuple.get(i));
                    Date sqlDate = new Date(langDate.getTime());
                    pstmt.setDate(j, sqlDate);
                }
                else if (md.get(j - 1).equals("INT"))
                {
                    pstmt.setInt(j, Integer.parseInt(tuple.get(i)));
                }
                else if (md.get(j - 1).equals("FLOAT"))
                {
                    pstmt.setFloat(j, Float.parseFloat(tuple.get(i)));
                }
            }

            pstmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        }
        catch (SQLException | ParseException ex)
        {
            con.rollback();
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER L'INSERIMENTO DI UN VIAGGIO*/
    public void insertViaggio(String nome_offerta, String link, String citta, String tipo) throws SQLException
    {
        try
        {
            String query = "INSERT IGNORE INTO VIAGGIO(NOME_OFFERTA, LINK, CITTA, TIPO) VALUES(" + "'" + nome_offerta.toLowerCase() + "', " + "'" + link.toLowerCase() + "', " + "'" + citta.toLowerCase() + "', " + "'" + tipo + "')";

            con.setAutoCommit(false);
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        }
        catch (SQLException ex)
        {
            con.rollback();
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER L'INSERIMENTO DELLO SCORE DI UN VIAGGIO*/
    public void insertViaggio_SentimentScore(String link_viaggio, float perc_molto_pos, float perc_pos, float perc_neutro, float perc_negativo, float perc_molto_neg) throws SQLException
    {
        String query = "INSERT IGNORE INTO SENTIMENT_SCORE(ID_SENTIMENT, PERC_MOLTO_POS, PERC_POS, PERC_NEUTRO, PERC_NEGATIVO, PERC_MOLTO_NEG) VALUES (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        try
        {
            pstmt.setFloat(1, perc_molto_pos);
            pstmt.setFloat(2, perc_pos);
            pstmt.setFloat(3, perc_neutro);
            pstmt.setFloat(4, perc_negativo);
            pstmt.setFloat(5, perc_molto_neg);

            // execute query, and return number of rows created
            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount=" + rowCount);
        }
        finally
        {
            pstmt.close();
        }

        insertSentimentScoreTravel(link_viaggio, perc_molto_pos, perc_pos, perc_neutro, perc_negativo, perc_molto_neg);
    }

    private void insertSentimentScoreTravel(String link_viaggio, float perc_molto_pos, float perc_pos, float perc_neutro, float perc_negativo, float perc_molto_neg) throws SQLException
    {
        Statement stat = con.createStatement();

        String query = "SELECT MAX(ID_SENTIMENT) FROM SENTIMENT_SCORE";

        ResultSet rest = stat.executeQuery(query);

        String num = "0";
        while (rest.next())
        {
            num = rest.getString(1);
        }
        stat.close();
        rest.close();

        Integer num_int = Integer.parseInt(num);

        query = "INSERT IGNORE INTO SENTIMENT_SCORE_TRAVEL(ID_SENTIMENT, LINK) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        try
        {
            pstmt.setInt(1, num_int);
            pstmt.setString(2, link_viaggio);

            // execute query, and return number of rows created
            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount=" + rowCount);
        }
        finally
        {
            pstmt.close();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER L'INSERIMENTO DI UNA RECENSIONE*/
    public int insertRecensione(String testo, String link) throws SQLException
    {
        Statement stat = con.createStatement();

        String query = "SELECT MAX(ID_RECENSIONE) FROM RECENSIONE";

        ResultSet rest = stat.executeQuery(query);

        String num = "0";
        while (rest.next())
        {
            num = rest.getString(1);
        }
        stat.close();
        rest.close();

        String table = "RECENSIONE";
        ArrayList<String>tuple = new ArrayList<String>();
        int num_int = Integer.parseInt(num);
        num_int++;
        tuple.add(Integer.toString(num_int));
        tuple.add(testo.toLowerCase());
        tuple.add(link.toLowerCase());

        insertRow(table, tuple);

        return num_int;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER L'INSERIMENTO DELLO SCORE DI UNA RECENSIONE*/
    public void insertRecensione_SentimentScore(int id_recensione, float perc_molto_pos, float perc_pos, float perc_neutro, float perc_negativo, float perc_molto_neg) throws SQLException
    {
        String query = "INSERT IGNORE INTO SENTIMENT_SCORE(ID_SENTIMENT, PERC_MOLTO_POS, PERC_POS, PERC_NEUTRO, PERC_NEGATIVO, PERC_MOLTO_NEG) VALUES (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        try
        {
            pstmt.setFloat(1, perc_molto_pos);
            pstmt.setFloat(2, perc_pos);
            pstmt.setFloat(3, perc_neutro);
            pstmt.setFloat(4, perc_negativo);
            pstmt.setFloat(5, perc_molto_neg);

            // execute query, and return number of rows created
            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount=" + rowCount);
        }
        finally
        {
            pstmt.close();
        }

        insertSentimentScoreReview(id_recensione, perc_molto_pos, perc_pos, perc_neutro, perc_negativo, perc_molto_neg);
    }

    private void insertSentimentScoreReview(int id_recensione, float perc_molto_pos, float perc_pos, float perc_neutro, float perc_negativo, float perc_molto_neg) throws SQLException
    {
        // Calcolo ID_SENTIMENT
        Statement stat = con.createStatement();

        String query = "SELECT MAX(ID_SENTIMENT) FROM SENTIMENT_SCORE";

        ResultSet rest = stat.executeQuery(query);

        String id_sentiment = "0";
        while (rest.next())
        {
            id_sentiment = rest.getString(1);
        }
        stat.close();
        rest.close();

        Integer num_id_sentiment = Integer.parseInt(id_sentiment);

/*        // Calcolo ID_RECENSIONE
        stat = con.createStatement();

        query = "SELECT MAX(ID_RECENSIONE) FROM RECENSIONE";

        rest = stat.executeQuery(query);

        String id_recensione = "0";
        while (rest.next())
        {
            id_recensione = rest.getString(1);
        }
        stat.close();
        rest.close();

        Integer num_id_recensione = Integer.parseInt(id_recensione);*/

        // Inserimento

        query = "INSERT IGNORE INTO SENTIMENT_SCORE_REVIEW(ID_SENTIMENT, ID_RECENSIONE) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        try
        {
            pstmt.setInt(1, num_id_sentiment);
            pstmt.setInt(2, id_recensione);

            // execute query, and return number of rows created
            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount=" + rowCount);
        }
        finally
        {
            pstmt.close();
        }

        /*// Inserimento

        query = "INSERT INTO SENTIMENT_SCORE_REVIEW(ID_SENTIMENT, ID_RECENSIONE) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        try
        {
            pstmt.setInt(1, num_id_sentiment);
            pstmt.setInt(2, num_id_recensione);

            // execute query, and return number of rows created
            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount=" + rowCount);
        }
        finally
        {
            pstmt.close();
        }*/
    }

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    /*METODO PER TROVARE UN ELEMENTO NEL DATABASE*/
    public Map<String, String> getInfo(String table, String attr, String attrVal) throws SQLException
    {
        attr = attr.toUpperCase();
        if(attr != "PASSWORD_U" || attr != "TIPO" || attr != "DATA_VIAGGIO" || attr != "FEEDBACK" || attr != "COMPATIBILITA" || attr != "PREZZO")
            attrVal = attrVal.toLowerCase();

        Statement stat = con.createStatement();
        Map<String, String> info = new HashMap<>();

        String query = "SELECT * "
                + "FROM " + table.toUpperCase() + " "
                + "WHERE " + attr.toUpperCase() + "=" + "'" + attrVal + "'";

        ResultSet rest = stat.executeQuery(query);

        ResultSetMetaData rsmd = rest.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rest.next())
        {
            for (int i = 1; i <= columnsNumber; i++)
            {
                info.put(rsmd.getColumnLabel(i), rest.getString(i));
            }
        }

        System.out.println(info);

        return info;
    }
}
