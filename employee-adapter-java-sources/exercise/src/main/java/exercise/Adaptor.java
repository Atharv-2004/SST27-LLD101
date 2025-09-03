package exercise;

import java.util.Objects;

public final class Adaptor implements Employee {
  private final EmployeeCSV csv;
  private final EmployeeDB db;
  private final EmployeeLDAP ldap;

  private Adaptor(EmployeeCSV csv, EmployeeDB db, EmployeeLDAP ldap) {
    this.csv = csv;
    this.db = db;
    this.ldap = ldap;
  }

  public static Adaptor fromCsv(EmployeeCSV csv) {
    return new Adaptor(Objects.requireNonNull(csv), null, null);
  }

  public static Adaptor fromDb(EmployeeDB db) {
    return new Adaptor(null, Objects.requireNonNull(db), null);
  }

  public static Adaptor fromLdap(EmployeeLDAP ldap) {
    return new Adaptor(null, null, Objects.requireNonNull(ldap));
  }

  @Override
  public String getId() {
    if (csv != null) return csv.tokens()[0];
    if (db != null) return String.valueOf(db.getId());
    return ldap.get("uid");
  }

  @Override
  public String getFirstName() {
    if (csv != null) return csv.tokens()[1];
    if (db != null) return db.getFirstName();
    return ldap.get("givenName");
  }

  @Override
  public String getLastName() {
    if (csv != null) return csv.tokens()[2];
    if (db != null) return db.getSurname();
    return ldap.get("sn");
  }

  @Override
  public String getEmail() {
    if (csv != null) return csv.tokens()[3];
    if (db != null) return db.getEmailAddress();
    return ldap.get("mail");
  }
}


