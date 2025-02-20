package com.zeroToHero.FinalProject.database.queries.prepQueries;

public interface DropQuery {
    String dropTables =
        "DROP FUNCTION IF EXISTS f_GetUsersByPageNumberAndSize;\n" +
        "DROP FUNCTION IF EXISTS f_GetToursByPageNumberAndSize;\n" +
        "DROP TABLE IF EXISTS destinations;\n" +
        "DROP TABLE IF EXISTS cities;\n" +
        "DROP TABLE IF EXISTS comments;\n" +
        "DROP TABLE IF EXISTS blogs;\n" +
        "DROP TABLE IF EXISTS reviews;\n" +
        "DROP TABLE IF EXISTS bookings;\n" +
        "DROP TABLE IF EXISTS tours;\n" +
        "DROP TABLE IF EXISTS users;\n" +
        "DROP TABLE IF EXISTS countries;\n" +
        "DROP TYPE IF EXISTS role_type;";
}
