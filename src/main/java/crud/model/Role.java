package crud.model;

public enum Role {
    ADMIN("Admin"), USER("User"), NOBODY("No body");
    private String string;

    Role(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return  string;
    }

    public static Role getRole(String s){
        switch (s){
            case "admin":
                return ADMIN;
            case "user":
                return USER;
            default:
                return NOBODY;
        }

    }
}
