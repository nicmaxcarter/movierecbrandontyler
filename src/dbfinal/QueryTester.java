package dbfinal;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QueryTester {

    private static final String url = "jdbc:mysql://localhost:3306/movieRecommender3000?useSSL=false";
    private static final String user = "root";
    private static final String password = "drc_DB2016";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static String query;
    private static BufferedReader br;
    private static Scanner scan;

    public static void main(String[] args) throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver error. Exiting....");
            System.exit(0);
        }
        
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Database connected successfully");
        System.out.println("Schema: movieRecommender3000");
        // Statement object to execute query
        stmt = conn.createStatement();
        

        rs.close();
        stmt.close();
        conn.close();
    }

    // Query 1
    static String query1(String n)
    {
    	String retval = "";

        String sql =    "SELECT m.title, m.year, m.rtAudienceScore, m.rtPictureURL, m.imdbPictureURL " +
                        "FROM movies m " +
                        "ORDER BY rtAudienceScore desc " +
                        "LIMIT " + n;

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    retval += rsmd.getColumnName(i) + "\t";
                }
            retval += "\n";

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) retval += ",  ";
                    String columnValue = rs.getString(i);
                    retval += columnValue;
                }
                retval += "\n";
            }

        } catch (SQLException ex){
            retval = "Whoops you suck!";
            System.out.println("went with the catch");
            return retval;
        }

 
        System.out.println("worked");
        return "still not working";
    }

    // Query 2
     static String query2(String str)
    {
    	 String retval = "";

        String sql =    "SELECT m.title, m.year, m.rtaudiencescore, rtpictureurl, m.imdbpictureurl, t.value " +
                        "FROM movies m, tags t, user_taggedmovies ut " +
                        "WHERE (m.title LIKE '%" + str + "%') AND (ut.movieid = m.id) AND (ut.tagid = t.id) ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            retval = "Whoops you suck!";
            return retval;
        }
        
        return retval;
       
    }

    // Query 3
    static void query3(String str, int limit)
    {
        System.out.println("\n\n");

        String sql =    "SELECT m.title, m.year, m.rtaudiencescore, rtpictureurl, m.imdbpictureurl, g.genre " +
                        "FROM movies m, movie_genres g " +
                        "WHERE g.movieid = m.id AND (g.genre LIKE '%" + str + "%') " +
                        "ORDER BY m.rtaudiencescore desc " +
                        "LIMIT " + limit;

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 4
    static void query4(String str)
    {
        System.out.println("\n\n");

        String sql =    "SELECT DISTINCT m.title, m.year, m.rtaudiencescore, rtpictureurl, m.imdbpictureurl, d.directorname " +
                        "FROM movies m, movie_directors d " +
                        "WHERE (d.movieid = m.id) AND (d.directorname LIKE '%" + str + "%') " +
                        "ORDER BY m.title";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 5
    static void query5(String str)
    {
        System.out.println("\n\n");

        String sql =    "SELECT DISTINCT m.title, m.year, m.rtaudiencescore, rtpictureurl, m.imdbpictureurl, a.actorname " +
                        "FROM movies m, movie_actors a " +
                        "WHERE (m.id = a.movieid) AND (a.actorname LIKE '%" + str + "%') " +
                        "ORDER BY m.title";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 6
    static void query6(String str)
    {
        System.out.println("\n\n");

        String sql =    "SELECT DISTINCT m.title, m.year, m.rtaudiencescore, rtpictureurl, m.imdbpictureurl, t.value " +
                        "FROM movies m, movie_tags mt, tags t " +
                        "WHERE (m.id = mt.movieid) AND (mt.tagid = t.id) AND (t.value LIKE '%" + str + "%') " +
                        "ORDER BY m.rtaudiencescore DESC " +
                        "LIMIT 10000";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 7
    static void query7(int k)
    {
        System.out.println("\n\n");

        String sql =    "SELECT DISTINCT directorname, AVG(rtaudiencescore) as average " +
                        "FROM movies, movie_directors " +
                        "WHERE movie_directors.movieid = movies.id " +
                        "GROUP BY directorname " +
                        "HAVING COUNT(*) >= " + k + " " +
                        "ORDER BY average DESC, directorname " +
                        "LIMIT 10";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 8
    static void query8(int k)
    {
        System.out.println("\n\n");

        String sql =    "SELECT DISTINCT actorname, AVG(rtaudiencescore) as average " +
                        "FROM movies, movie_actors " +
                        "WHERE movie_actors.movieid = movies.id " +
                        "GROUP BY actorname " +
                        "HAVING COUNT(*) >= " + k + " " +
                        "ORDER BY average DESC, actorname " +
                        "LIMIT 10";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 9
    static void query9(int k)
    {
        System.out.println("\n\n");

        String sql =    "SELECT u.userid, m.title, u.rating, g.genre " +
                        "FROM user_ratedmovies u, movies m, movie_genres g " +
                        "WHERE (m.id = u.movieid) AND (u.userid = " + k + ") AND (g.movieid = m.id) " +
                        "ORDER BY g.genre, m.title ";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }

        System.out.println("\n\n");
    }

    // Query 10
    static void query10(String str)
    {
        System.out.println("\n\n");

        String sql =    "SELECT m.title, t.value " +
                        "FROM movies m, tags t, movie_tags mt " +
                        "WHERE (m.title LIKE '%" + str + "%') AND (mt.movieid = m.id) AND (mt.tagid = t.id) ";

        try {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // print out the column titles separated by tab
            for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "\t");
                }
            System.out.println();

            // print out each tuple
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println();
            }

        } catch (SQLException ex){
            System.out.println("Whoops you suck!");
        }
        System.out.println("\n\n");
    }
}
