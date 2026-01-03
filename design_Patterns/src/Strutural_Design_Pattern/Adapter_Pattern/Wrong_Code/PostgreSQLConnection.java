package Strutural_Design_Pattern.Adapter_Pattern.Wrong_Code;


class PostgreSQLConnection {
    public void connectPostgres(String url) {
        System.out.println("Connecting to PostgreSQL: " + url);
    }

    public void runQuery(String query) {
        System.out.println("Running PostgreSQL query: " + query);
    }
}